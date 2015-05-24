package fr.unice.polytech.ogl.islac.action;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import fr.unice.polytech.ogl.islac.character.Character1;
import fr.unice.polytech.ogl.islac.data.Arena;
import fr.unice.polytech.ogl.islac.tool.JSONTools;

public class Explore extends Action {

	
	public Explore()
	{
		this.name="Explore";
	}
	
	/**
	 * Méthode act, permet de réaliser un Explore
	 * @param /
	 * @return String
	 */
	
	@Override
	public String act(){
		return "{ \"action\": \"explore\" }";
	}


	/**
	 * Méthode read de la classe explore, récupère la quantité de ressource
	 * collectée et la difficulté d'accès et le coût en pa.
	 * On récupère aussi le coût en pa.
	 * Permet également de savoir si on récupère la ressource ou non,
	 * via le setObj().
	 * @param data, act
	 */
	/*
	@Override
	public void read(String data,Action a){
	
		try {
	    	  JSONParser parser=new JSONParser();		  
		      JSONObject obj = (JSONObject)parser.parse(data);
		      JSONObject obj1= (JSONObject)obj.get("extras");
		      JSONArray array= (JSONArray)obj1.get("ressources");
		      JSONObject obj2= (JSONObject)array.get(0);
		      
		      
		      long pa=(long)obj.get("cost");
		      
		      if (a.getC().getCurrentTuil().isObj(1)){
		    	  
		    	  for (int k=0; k<array.size();k++){
		    		  JSONObject obj3= (JSONObject)array.get(k);
		    		  
		    		  // on vérifie que la ressource est dans les objectifs
		    		  if (obj3.get("resource").equals(a.getMap().getObj1())){
		    			  
		    			  // si amount est "low" on ne récupère rien (setObj1 est à 0)
		    			  if (obj3.get("amount").equals("LOW")){
		    				  a.getC().getCurrentTuil().setObj1(0);
		    			  }
		    			  	 // si amount n'est pas "low" on peut récupérer la ressource (setObj1 est à 1)
		    			  else a.getC().getCurrentTuil().setObj1(1);
		    				  
		    		  }
		    	  }
		      }
		      //idem avec le deuxième objectif
		      if (a.getC().getCurrentTuil().isObj(2)){
		    	  
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
		      
		     a.getC().addPa(pa);
		      
		      
		} catch (ParseException e) {
			e.printStackTrace();
		}
	
	}*/

	
	
}
