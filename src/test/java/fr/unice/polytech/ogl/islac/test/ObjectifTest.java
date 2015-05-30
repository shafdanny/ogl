package fr.unice.polytech.ogl.islac.test;

import static org.junit.Assert.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Ignore;
import org.junit.Test;

import fr.unice.polytech.ogl.islac.Explorer;

public class ObjectifTest {

	public void collectOneObjectif(String ressource1, String ressource2, String ressource3, String destination, String ressourceAcollecter) {
		
		JSONObject obj;
		JSONParser jsonparser;
		obj = new JSONObject();
		 
		
		JSONObject objective = new JSONObject();
		JSONObject objective2 = new JSONObject();
		JSONObject objective3 = new JSONObject();
		JSONArray list = new JSONArray();
		
		objective.put("resource", ressource1);

		objective.put("amount", new Integer(600));
		
		objective2.put("resource", ressource2);

		objective2.put("amount", new Integer(400));
	
		objective3.put("resource", ressource3);

		objective3.put("amount", new Integer(300));



		list.add(objective);
		list.add(objective2);
		list.add(objective3);
		
		//System.out.println("Liste:");
		//System.out.println(list);
				
		obj.put("creek", "THIS34IS12A85CREEK87ID");
		obj.put("budget", new Integer(600));
		obj.put("men", new Integer(50));
		obj.put("objective", list);
		System.out.println(obj);
		String init = obj.toJSONString();
		Explorer a=new Explorer();
		
		
		a.initialize(init);
		
		//System.out.println(init);
		//land
		
		
		String s = "{ \"action\": \"land\", \n \"parameters\": {\"creek\":" + "\""+ "THIS34IS12A85CREEK87ID" + "\", \"people\":" +	1 + "} \n}";
		assertEquals(a.takeDecision(), s); 
				
		a.acknowledgeResults("{\"status\": \"OK\", \"cost\":12}");
		
		//scout nord

		String s1 = "{\"action\":\"scout\",\"parameters\":{\"direction\":" +"\""+ destination+"\"" +"}}";
		
		assertEquals(a.takeDecision(), s1); 
		
		a.acknowledgeResults("{\"status\" : \"OK\", \"cost\":8,\"extras\":{\"resources\":[\""+ressource1+"\", \""+ressource2+"\", \""+ressource3+"\"],\"altitude\":-23}}");
		
		//move N
		
		/*a.takeDecision();
		a.acknowledgeResults("{\"status\" : \"OK\", \"cost\":8,\"extras\":{\"resources\":[\"ressource1\", \"ressource2\", \"ressource3\"],\"altitude\":-23}}");

		a.takeDecision();
		a.acknowledgeResults("{\"status\" : \"OK\", \"cost\":8,\"extras\":{\"resources\":[\"ressource1\", \"ressource2\", \"ressource3\"],\"altitude\":-23}}");

		a.takeDecision();
		a.acknowledgeResults("{\"status\" : \"OK\", \"cost\":8,\"extras\":{\"resources\":[\"ressource1\", \"ressource2\", \"ressource3\"],\"altitude\":-23}}");
		*/
		
		String s2 = "{ \"action\": \"move_to\", \"parameters\": {\"direction\": " +"\""+ destination+"\" " +"} }";
		assertEquals(a.takeDecision(), s2);
		
		a.acknowledgeResults("{\"status\": \"OK\", \"cost\":12}");
		
		//expoit
		
		//a.takeDecision();
		String s3 = "{ \"action\": \"exploit\", \"parameters\": {\""+"resource"+"\": " +"\""+ ressourceAcollecter+"\" " +"} }";
		assertEquals(a.takeDecision(), s3);
		
		a.acknowledgeResults("{\"status\" : \"OK\", \"cost\":8,\"extras\":{\"amount\": 200 }}");

		//System.out.println(a.sim1.act.getC().getObj().get(0).getQuantity());
	}
	
	// exploit pour l'objectif 1
	
	@Test public void testObjectif1() { 
		collectOneObjectif("WOOD","FUR","FLOWER","N","WOOD");
	}
	

	// exploit pour l'objectif 2
	
	@Ignore public void testObjectif2() { 
		collectOneObjectif("WOOD","FUR","FLOWER","N","FUR");
	}
	

	// exploit pour l'objectif 3
	
	@Ignore public void testObjectif3() { 
		collectOneObjectif("WOOD","FUR","FLOWER","N","FLOWER");
	}
}


