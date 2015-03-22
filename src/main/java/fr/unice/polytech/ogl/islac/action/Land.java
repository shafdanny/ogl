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
	
	public String act(String creek_id, long l){
		return "{ \"action\": \"land\", \n \"parameters\": {\"creek\":" + "\""+ creek_id + "\", \"people\":" +	l + "} \n}";
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

