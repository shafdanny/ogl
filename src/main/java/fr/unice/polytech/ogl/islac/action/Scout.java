package fr.unice.polytech.ogl.islac.action;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.*;
import fr.unice.polytech.ogl.islac.data.Arena;

public class Scout extends Action {
	
	
@Override
	public void read(String data){
	
		try {
	    	  JSONParser parser=new JSONParser();		  
		      JSONObject obj = (JSONObject)parser.parse(data);
		      JSONObject obj1= (JSONObject)obj.get("extras");
		      JSONArray array= (JSONArray)obj1.get("ressources");
		      
		      int pa=(int)obj.get("cost");
		      ArrayList<String> ressources = new ArrayList<String>();
		      for (int k=0; k<array.size(); k++)
		      {
		    	  ressources.add((String)array.get(k));
		      }
		      int altitude=(int)obj1.get("altitude");
		      
		      
		      c.addPa(pa);
		      
		      
		} catch (ParseException e) {
			e.printStackTrace();
	}
	
	}


	public String act(String dir){
		return "{ \"action\": \"scout\", \"parameters\": {\"direction\": " +"\""+ dir+"\" " +"} }";
	}
	
	
	
}
