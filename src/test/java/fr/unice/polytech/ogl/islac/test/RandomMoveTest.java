package fr.unice.polytech.ogl.islac.test;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import fr.unice.polytech.ogl.islac.Explorer2;

public class RandomMoveTest {

	
	public void randomMoove()
	{
		JSONObject obj;
		JSONParser jsonparser;
		obj = new JSONObject();
		 
		
		JSONObject objective = new JSONObject();
		JSONArray list = new JSONArray();
		
		objective.put("resource", "FISH");
		objective.put("amount", new Integer(600));
	
		list.add(objective);
				
		obj.put("creek", "THIS34IS12A85CREEK87ID");
		obj.put("budget", new Integer(600));
		obj.put("men", new Integer(50));
		obj.put("objective", list);
		System.out.println(obj);
		String init = obj.toJSONString();
		Explorer2 a=new Explorer2();
		
		
		a.initialize(init);
		
		
		//land
		System.out.println(a.takeDecision());
		
		a.acknowledgeResults("{\"status\": \"OK\", \"cost\":12}");
		
		//scout nord
		System.out.println(a.takeDecision());	
		a.acknowledgeResults("{\"status\" : \"OK\", \"cost\":8,\"extras\":{\"resources\":[\"FISH\"],\"altitude\":-23}}");
		
		//scout sud
		System.out.println(a.takeDecision());	
		a.acknowledgeResults("{\"status\" : \"OK\", \"cost\":8,\"extras\":{\"resources\":[\"other\"],\"altitude\":-23}}");
		
		//scout est
		System.out.println(a.takeDecision());	
		a.acknowledgeResults("{\"status\" : \"OK\", \"cost\":8,\"extras\":{\"resources\":[\"other\"],\"altitude\":-23}}");
		
		//scout ouest
		System.out.println(a.takeDecision());	
		a.acknowledgeResults("{\"status\" : \"OK\", \"cost\":8,\"extras\":{\"resources\":[\"other\"],\"altitude\":-23}}");
		
		//moove n
		System.out.println(a.takeDecision());	
	}
}
