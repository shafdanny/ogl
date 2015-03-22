package fr.unice.polytech.ogl.islac.action;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.*;

import fr.unice.polytech.ogl.islac.character.Character1;
import fr.unice.polytech.ogl.islac.data.Arena;
import fr.unice.polytech.ogl.islac.data.Tuils;

public class Scout extends Action {
	
	
	public Scout()
	{
		this.name="Scout";
	}
@Override
	public void read(String data,Action a){
	
		try {
			
	    	  JSONParser parser=new JSONParser();		  
		      JSONObject obj = (JSONObject)parser.parse(data);
		      JSONObject obj1= (JSONObject)obj.get("extras");
		      
		      JSONArray array= (JSONArray)obj1.get("resources");
		
		      long pa=(long)obj.get("cost");
		      ArrayList<String> ressources = new ArrayList<String>();
		      
		      
		      for (int k=0; k<array.size(); k++)
		      {
		    	
		    	  ressources.add((String)array.get(k));
		      }
		      long altitude=(long)obj1.get("altitude");
		      
		      a.getMap().scout(a.getC().getCurrentTuil(),a.getLastDirection(),ressources,altitude);
	
		      a.getC().addPa(pa);
		      
		      
		} catch (ParseException e) {
			e.printStackTrace();
	}
	
	}


	public String act(String dir,Action a){
		
		//a.getMap().getD(a.getC().getCurrentTuil(), dir).setScooted(true);
		return "{ \"action\": \"scout\", \"parameters\": {\"direction\": " +"\""+ dir+"\" " +"} }";
	}
	
	
	
}
