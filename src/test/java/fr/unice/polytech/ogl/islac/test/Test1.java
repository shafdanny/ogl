package fr.unice.polytech.ogl.islac.test;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import eu.ace_design.island.bot.*;
import fr.unice.polytech.ogl.islac.data.Arena;
import fr.unice.polytech.ogl.islac.data.Tuils;

import org.json.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Test;

import fr.unice.polytech.ogl.islac.Explorer;


public class Test1 {

	/*
	
	public void test1()
	{
			
		
		JSONObject obj=new JSONObject();
		JSONParser jsonparser;
		
		 
		
		JSONObject objective = new JSONObject();
		JSONObject objective1 = new JSONObject();
		JSONObject objective2 = new JSONObject();
		JSONArray list = new JSONArray();
		
		objective1.put("resource", "WOOD");
		//objective.put("resource", "EDO");
		objective1.put("amount", new Integer(600));
		list.add(objective1);
		
		objective.put("resource", "SUGAR");

		objective.put("amount", new Integer(600));
		
		
	
		list.add(objective);
				
		obj.put("creek", "THIS34IS12A85CREEK87ID");
		obj.put("budget", new Integer(600));
		obj.put("men", new Integer(50));
		obj.put("objective", list);
		System.out.println(obj);
		String init = obj.toJSONString();
		Explorer a=new Explorer();
		
		
		a.initialize(init);
		
		assert(true);
	}*/
	
	
	/**
	 * A transformer en assert
	 * @param args
	 */
	public static void main(String [] args)
	{
		JSONObject obj=new JSONObject();
		JSONParser jsonparser;
		
		 
		
		JSONObject objective = new JSONObject();
		JSONObject objective1 = new JSONObject();
		JSONObject objective2 = new JSONObject();
		JSONArray list = new JSONArray();
		
		objective1.put("resource", "FLOWER");
		//objective.put("resource", "EDO");
		objective1.put("amount", new Integer(2));
		list.add(objective1);
		
		objective.put("resource", "FUR");

		objective.put("amount", new Integer(300));
		list.add(objective);
		
		objective2.put("resource", "SUGAR_CANE");
		objective2.put("amount",new Integer(600));

		list.add(objective2);
	
		
				
		obj.put("creek", "THIS34IS12A85CREEK87ID");
		obj.put("budget", new Integer(600));
		obj.put("men", new Integer(50));
		obj.put("objective", list);
		System.out.println(obj);
		String init = obj.toJSONString();
		Explorer a=new Explorer();	
		a.initialize(init);
		
		//land
		System.out.println(a.takeDecision());
		a.acknowledgeResults("{\"status\": \"OK\", \"cost\":12}");
		
		//scout nord
		System.out.println(a.takeDecision());
		a.acknowledgeResults("{\"status\" : \"OK\", \"cost\":8,\"extras\":{\"resources\":[\"FUR\"],\"altitude\":-23}}");
		
		//System.out.println(a.sim1.act.getC().getObj().get(1).getName());
		//System.out.println(a.sim1.act.getMap().getObj3());
		
		//move to nord
		System.out.println(a.takeDecision());
		a.acknowledgeResults("{\"status\": \"OK\", \"cost\":12}");
		
		
		//exploit fur
		
		System.out.println(a.takeDecision());
		a.acknowledgeResults("{\"status\" : \"OK\", \"cost\":8,\"extras\":{\"amount\": 301}}");
		
		//scout N
		
		System.out.println(a.takeDecision());
		a.acknowledgeResults("{\"status\" : \"OK\", \"cost\":8,\"extras\":{\"resources\":[\"FUR\"],\"altitude\":-23}}");
		
	
		
		//scout sud
		System.out.println(a.takeDecision());
		a.acknowledgeResults("{\"status\" : \"OK\", \"cost\":8,\"extras\":{\"resources\":[\"SUGAR_CANE\"],\"altitude\":-23}}");
				
			
				
		//move to sud
		System.out.println(a.takeDecision());
		a.acknowledgeResults("{\"status\": \"OK\", \"cost\":12}");
		
		//exploit sugar_cane
		
		System.out.println(a.takeDecision());
		a.acknowledgeResults("{\"status\" : \"OK\", \"cost\":8,\"extras\":{\"amount\": 21}}");
	}
	
	
}