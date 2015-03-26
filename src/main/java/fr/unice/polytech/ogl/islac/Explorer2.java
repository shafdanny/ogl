package fr.unice.polytech.ogl.islac;

import eu.ace_design.island.bot.*;
import org.json.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Explorer2  {

	Simulator sim1;
	

	
	public void initialize(String context) {
    	sim1=new Simulator();
    	sim1.init(context);
    	
		
	}

 
	public String takeDecision() {
    	return sim1.simul();
    	
    	
		
	}

    
	public void acknowledgeResults(String results) {
		
    	sim1.simul2(results);
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JSONObject obj;
		JSONParser jsonparser;
		obj = new JSONObject();
		
		
		JSONObject objective = new JSONObject();
		JSONArray list = new JSONArray();
		
		objective.put("resource", "WOOD");
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
		
		System.out.println(a.takeDecision());
		a.acknowledgeResults("{\"status\": \"OK\", \"cost\":12}");
		System.out.println(a.sim1.act.getC().getPa());
		
		System.out.println(a.takeDecision());	
		a.acknowledgeResults("{\"status\" : \"OK\", \"cost\":8,\"extras\":{\"resources\":[\"FUR\",\"FLOWER\"],\"altitude\":-23}}");
		System.out.println(a.sim1.act.getC().getPa());
		
		System.out.println(a.takeDecision());
		
	}

}
