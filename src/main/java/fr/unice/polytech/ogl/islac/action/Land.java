package fr.unice.polytech.ogl.islac.action;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Land extends Action {
	
	
	public Land()
	{
		this.name="Land";
	}
	@Override
	public String act(String creek_id, int number){
		return "{ \"action\": \"land\", \"parameters\": {\"creek\":" + creek_id + ", \"people\":" +	number + "}}";
	}

	@Override
	public String act() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String act(String info) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void read(String info,Action act)
	{
		try {
	    	  JSONParser parser=new JSONParser();		  
		      JSONObject obj = (JSONObject)parser.parse(info);
		  		
		      
		      long pa=(long)obj.get("cost");    
		      	act.getC().addPa(pa);
	
	} catch (ParseException e) {
		e.printStackTrace();
		}
		
	}
	
}

