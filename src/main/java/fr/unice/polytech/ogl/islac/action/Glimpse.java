package fr.unice.polytech.ogl.islac.action;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import fr.unice.polytech.ogl.islac.data.Pos;
import fr.unice.polytech.ogl.islac.data.Tuils;

public class Glimpse extends Action {

	String direction;
	int range;
	
	public Glimpse(){
		this.name = "Glimpse";
	}
	
	@Override
	public String act() {
		return "{\"action\": \"glimpse\",\"parameters\": { \"direction\": \"N\", \"range\": 2 }}";
	}
	
	@Override
	public String act(String direction, int range){
		return "{\"action\": \"glimpse\",\"parameters\": { \"direction\": \"" + direction + "\", \"range\": " + range + " }}";
	}
	
	@Override
	public String act(String direction, Action a) {
		return act(direction,2);
	}
	
	@Override
	public void read(String data, Action a) {
		//System.out.println(data);
		try {			
	    	  JSONParser parser = new JSONParser();		  
		      JSONObject obj = (JSONObject)parser.parse(data);
		      JSONObject obj1= (JSONObject)obj.get("extras");
		      
		      JSONArray array= (JSONArray)obj1.get("report");
		
		      JSONArray case2array = (JSONArray) array.get(1);
		      
		      long pa=(long)obj.get("cost");  
		      //System.out.println(pa);
		      a.getC().addPa(pa);
		      
		      //System.out.println(array.toString());      
		      //System.out.println(case2array.toString());   
		      
		      int terrainNb = case2array.size();
		      Pos newPos=a.getMap().getNewPos(a.getC().getCurrentTuil(),direction);
		      if (a.getMap().getD(a.getC().getCurrentTuil(), a.getLastDirection())==null)
		      {
		    		
		    	 a.getMap().getMap().put(newPos,new Tuils(newPos));
		    	 a.getMap().getD(a.getC().getCurrentTuil(), a.getLastDirection()).setOnlyFish(true);
				
		     
		      }
		      for (int i=0;i<terrainNb;i++){
		    	  JSONArray terrain = (JSONArray)case2array.get(i);
		    	  String typeOfTerrain = (String) terrain.get(0);
		    	  //System.out.println(typeOfTerrain);
		    	  if(!typeOfTerrain.equals("OCEAN")&& !typeOfTerrain.equals("LAKES")){
		    		  a.getMap().getD(a.getC().getCurrentTuil(), a.getLastDirection()).setOnlyFish(false);
		    	  }
		      }
		      
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
}
