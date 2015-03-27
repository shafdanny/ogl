package fr.unice.polytech.ogl.islac.action;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import fr.unice.polytech.ogl.islac.character.Character1;
import fr.unice.polytech.ogl.islac.data.Arena;

public class Explore extends Action {

	
	public Explore()
	{
		this.name="Explore";
	}
	@Override
	public String act(){
		return "{ \"action\": \"explore\" }";
	}

	@Override
	public String act(String info) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String act(String info, int number) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void read(String data,Action a){
	
		try {
	    	  JSONParser parser=new JSONParser();		  
		      JSONObject obj = (JSONObject)parser.parse(data);
		      JSONObject obj1= (JSONObject)obj.get("extras");
		      JSONArray array= (JSONArray)obj1.get("ressources");
		      JSONObject obj2= (JSONObject)array.get(0);
		      
		      
		      long pa=(long)obj.get("cost");
		      
		      if (a.getC().getCurrentTuil().isObj1()){
		    	  
		    	  for (int k=0; k<array.size();k++){
		    		  JSONObject obj3= (JSONObject)array.get(k);
		    		  if (obj3.get("resource")==a.getMap().getObj1()){
		    			  if (obj3.get("amount")=="LOW"){
		    				  a.getC().getCurrentTuil().setObj1(0);
		    			  }
		    			  else a.getC().getCurrentTuil().setObj1(1);
		    				  
		    		  }
		    	  }
		      }

		      if (a.getC().getCurrentTuil().isObj2()){
		    	  
		    	  for (int k=0; k<array.size();k++){
		    		  JSONObject obj3= (JSONObject)array.get(k);
		    		  if (obj3.get("resource")==a.getMap().getObj2()){
		    			  if (obj3.get("amount")=="LOW"){
		    				  a.getC().getCurrentTuil().setObj2(0);
		    			  }
		    			  else a.getC().getCurrentTuil().setObj2(1);
		    				  
		    		  }
		    	  }
		      }
		      
		      
		      long altitude=(long)obj1.get("altitude");
		      
		      
		     a.getC().addPa(pa);
		      
		      
		} catch (ParseException e) {
			e.printStackTrace();
	}
	
	}	
	
	
	
}
