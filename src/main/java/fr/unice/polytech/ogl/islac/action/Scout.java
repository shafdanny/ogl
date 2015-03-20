package fr.unice.polytech.ogl.islac.action;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Scout extends Action {
	
	
@Override
	public void read(String s){
	
		try {
	    	  JSONParser parser=new JSONParser();		  
		      JSONObject obj = (JSONObject)parser.parse(s);
		      JSONObject obj1= (JSONObject)obj.get("extras");
		      
		      int pa=(int)obj.get("cost");
		      
		      c.addPa(pa);
		      
		      
		} catch (ParseException e) {
			e.printStackTrace();
	}
	
	}


	public String act(String dir){
		return "{ \"action\": \"scout\", \"parameters\": {\"direction\": " +"\""+ dir+"\" " +"} }";
	}
	
	
	
}
