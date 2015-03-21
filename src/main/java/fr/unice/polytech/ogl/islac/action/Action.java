package fr.unice.polytech.ogl.islac.action;

import java.util.ArrayList;
import java.util.Map;

import fr.unice.*;
import java.util.List;


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
		
	}
	public void read(String data)
	{
		 try {
	    	  JSONParser parser=new JSONParser();		  
		      JSONObject obj = (JSONObject)parser.parse(data);
		      String creek_id=(String)obj.get("creek");
		      int pa=(int)obj.get("budget");
		      int men =(int)obj.get("men");
		      map.getListCreek().add(creek_id);
		      c.setPa(pa);
		      
		      
		      //Ressources re=new Wood();
		      
		      
		      
		} catch (ParseException e) {
			e.printStackTrace();
	}
	
	}

	// Méthodes pour exploit


	
	public Arena getMap() {
		return map;
	}


	public void setMap(Arena map) {
		this.map = map;
	}


	public Action getLastAction() {
		return lastAction;
	}

	public void setLastAction(Action lastAction) {
		this.lastAction = lastAction;
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

}
