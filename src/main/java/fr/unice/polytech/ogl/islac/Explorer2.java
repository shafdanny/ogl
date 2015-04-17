package fr.unice.polytech.ogl.islac;

import java.util.HashMap;

import eu.ace_design.island.bot.*;
import fr.unice.polytech.ogl.islac.data.Arena;
import fr.unice.polytech.ogl.islac.data.Tuils;

import org.json.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Explorer2  {

	public Simulator sim1;
	

	
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
		
		
		//land
		System.out.println(a.takeDecision());
		
		a.acknowledgeResults("{\"status\": \"OK\", \"cost\":12}");
		
		//scout nord
		System.out.println(a.takeDecision());	
		a.acknowledgeResults("{\"status\" : \"OK\", \"cost\":8,\"extras\":{\"resources\":[\"WOOD\"],\"altitude\":-23}}");
		
		//move N
		
		
		/*System.out.println(a.takeDecision());
		a.acknowledgeResults("{\"status\": \"OK\", \"cost\":12}");*/
		
		//System.out.println(a.sim1.act.getC().getPos());
		//expoit
		//System.out.println(a.takeDecision());	
		//a.acknowledgeResults("{\"status\" : \"OK\", \"cost\":8,\"extras\":{\"amount\": 800 }}");
	
	//	System.out.println(a.sim1.act.getC().getObj().get(0).getQuantity());
	
		
		
		
	// scout S
		System.out.println(a.takeDecision());	
		a.acknowledgeResults("{\"status\" : \"OK\", \"cost\":8,\"extras\":{\"resources\":[\"FISH\"],\"altitude\":-23}}");
		
		//scout E
		System.out.println(a.takeDecision());	
		a.acknowledgeResults("{\"status\" : \"OK\", \"cost\":8,\"extras\":{\"resources\":[\"FSH\"],\"altitude\":-23}}");
		
		//scout W
		System.out.println(a.takeDecision());	
		a.acknowledgeResults("{\"status\" : \"OK\", \"cost\":8,\"extras\":{\"resources\":[\"FSH\"],\"altitude\":-23}}");
		
		// 
		System.out.println(a.takeDecision());
		a.acknowledgeResults("{\"status\" : \"OK\", \"cost\":8,\"extras\":{\"amount\": 800 }}");
		
		
		
	//	a.acknowledgeResults("{\"status\" : \"OK\", \"cost\":8,\"extras\":{\"resources\":[\"Fish\"],\"altitude\":-23}}");
		
		
		System.out.println(a.takeDecision());
		a.sim1.act.getC().getCurrentTuil().getPos().getX();
		a.sim1.act.getC().getCurrentTuil().getPos().getY();
		a.acknowledgeResults("{\"status\" : \"OK\", \"cost\":8,\"extras\":{\"resources\":[\"WOOD\",\"FLOWER\"],\"altitude\":-23}}");
		
		
		System.out.println(a.takeDecision());
		System.out.println(+a.sim1.act.getC().getCurrentTuil().getPos().getX());
		System.out.println(+a.sim1.act.getC().getCurrentTuil().getPos().getY());
		System.out.println(a.takeDecision());
		a.acknowledgeResults("{\"status\" : \"OK\", \"cost\":8,\"extras\":{\"resources\":[\"FUR\",\"FLOWER\"],\"altitude\":-23}}");
		System.out.println(a.takeDecision());
		System.out.println(a.takeDecision());

		
		System.out.println(a.takeDecision());
		a.acknowledgeResults("{\"status\" : \"OK\", \"cost\":8,\"extras\":{\"resources\":[\"FUR\",\"FLOWER\"],\"altitude\":-23}}");
		System.out.println(a.takeDecision());
		a.acknowledgeResults("{\"status\" : \"OK\", \"cost\":8,\"extras\":{\"resources\":[\"FUR\",\"FLOWER\"],\"altitude\":-23}}");
		System.out.println(a.takeDecision());
		System.out.println(a.takeDecision());
		a.sim1.act.getC().getCurrentTuil().getPos().getX();
		a.sim1.act.getC().getCurrentTuil().getPos().getY();
		a.acknowledgeResults("{\"status\" : \"OK\", \"cost\":8,\"extras\":{\"resources\":[\"FLOWER\"],\"altitude\":-23}}");
		System.out.println(a.takeDecision());
		/*System.out.println(a.takeDecision());
		a.acknowledgeResults("{\"status\" : \"OK\", \"cost\":8,\"extras\":{\"resources\":[\"WOOD\",\"FLOWER\"],\"altitude\":-23}}");
		System.out.println(a.takeDecision());
		System.out.println(a.takeDecision());
		*/
		
		
		
		/*
		
		Arena are=new Arena();
		are.addTuils(new Tuils(0,0));
		are.addTuils(new Tuils(0,1));
		System.out.println(are.getD(new Tuils(0,0), "N").getPos().getY());
		
		*/
		
	}

}
