package fr.unice.polytech.ogl.islac.action;

import java.util.ArrayList;
import fr.unice.polytech.ogl.islac.data.*;
import java.util.Map;

import fr.unice.*;
import java.util.List;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import fr.unice.polytech.ogl.islac.data.*;
import fr.unice.polytech.ogl.islac.character.*;

public class Action {
	
	String name;
	protected Action lastAction;
	Arena map;
	Character1 c;
	private List<String> listCreek;
	private String lastDirection;

	
	
	public Action()
	{
		
		
	}
	
	public void initAction()
	{
		listCreek=new ArrayList<String>();		
		setMap(new Arena());
		setC(new Character1());
	}
//Méthodes
	

	
	public String act()
	{
		return null;
	}
	
	public String act(String info)
	{
		return null;
	}
	

	public String act(String info, int number)
	{
		return null;
	}
	
	
	public void read(String data,Action a)
	{
		{
			 try {
		    	  JSONParser parser=new JSONParser();		  
			      JSONObject obj = (JSONObject)parser.parse(data);
			      String creek_id=(String)obj.get("creek");
			      int pa=(int)obj.get("budget");
			      int men =(int)obj.get("men");
			      a.getMap().getListCreek().add(creek_id);
			      a.getC().setPa(pa);
			      a.getC().setNbTotal(men);
			      JSONArray array=(JSONArray) obj.get("objective");
			      
			      ArrayList<Ressources> objective = new ArrayList<Ressources>();
			      for (int k=0; k<array.size(); k++)
			      {
			    	  
			    	  JSONObject objN= (JSONObject) array.get(k);
			    	  String nom=(String)objN.get("resource");
			    	  long quantity=(long)objN.get("amount");
			    	  objective.add(new Ressources(nom,quantity));
			    	  	  
			      }
			      
			      
			      
			    
			      
			      
			      
			} catch (ParseException e) {
				e.printStackTrace();
		}
		
		}
	}
	public void read(String data)
	{
		/** try {
	    	  JSONParser parser=new JSONParser();		  
		      JSONObject obj = (JSONObject)parser.parse(data);
		      String creek_id=(String)obj.get("creek");
		      int pa=(int)obj.get("budget");
		      int men =(int)obj.get("men");
		      map.getListCreek().add(creek_id);
		      //a.getC().setPa(pa);
		      c.setNbTotal(men);
		      JSONArray array=(JSONArray) obj.get("objective");
		      
		      ArrayList<Ressources> objective = new ArrayList<Ressources>();
		      for (int k=0; k<array.size(); k++)
		      {
		    	  
		    	  JSONObject objN= (JSONObject) array.get(k);
		    	  String nom=(String)objN.get("resource");
		    	  int quantity=(int)objN.get("amount");
		    	  objective.add(new Ressources(nom,quantity));
		    	  	  
		      }
		      
		      
		      
		    
		      
		      
		      
		} catch (ParseException e) {
			e.printStackTrace();
	}
	*/
	}

	// Méthodes pour exploit


	
	public Arena getMap() {
		return map;
	}


	public void setMap(Arena map) {
		this.map = map;
	}




	public String getLastDirection() {
		return lastDirection;
	}

	public void setLastDirection(String lastDirection) {
		this.lastDirection = lastDirection;
	}

	public Character1 getC() {
		return c;
	}


	public void setC(Character1 c) {
		this.c = c;
	}



	public List<String> getListCreek() {
		return listCreek;
	}

	public void setListCreek(ArrayList<String> listCreek) {
		this.listCreek = listCreek;
	}
	
	public boolean equals(Action a){
		if (this.name.equals(a.name))
		{
			return true;
		}
		else return false;
	}

	public String act(String direction, Action a) {
		// TODO Auto-generated method stub
		return null;
	}

	public Action getLastAction() {
		return lastAction;
	}

	public void setLastAction(Action lastAction) {
		this.lastAction = lastAction;
	}

	public String getRessourceName() {
		// TODO Auto-generated method stub
		return null;
		
	}

}
