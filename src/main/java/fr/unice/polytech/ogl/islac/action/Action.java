package fr.unice.polytech.ogl.islac.action;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import fr.unice.polytech.ogl.islac.data.*;
import fr.unice.polytech.ogl.islac.character.*;

public class Action {
	
	int x=250;
	int y=250;
	
	Exploit e1=new Exploit();
	Explore e= new Explore();
	Land l=new Land();
	Move_to m=new Move_to();
	Scout s=new Scout();
	Stop s1=new Stop();
	Map map=new Map();
	Character1 c=new Character1();
	
	
	public Action()
	{
		
		
		
	}

	
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
	
	public void read(String s)
	{
		 try {
	    	  JSONParser parser=new JSONParser();		  
		      JSONObject obj = (JSONObject)parser.parse(s);
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


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public Exploit getE1() {
		return e1;
	}


	public void setE1(Exploit e1) {
		this.e1 = e1;
	}


	public Explore getE() {
		return e;
	}


	public void setE(Explore e) {
		this.e = e;
	}


	public Land getL() {
		return l;
	}


	public void setL(Land l) {
		this.l = l;
	}


	public Move_to getM() {
		return m;
	}


	public void setM(Move_to m) {
		this.m = m;
	}


	public Scout getS() {
		return s;
	}


	public void setS(Scout s) {
		this.s = s;
	}


	public Stop getS1() {
		return s1;
	}


	public void setS1(Stop s1) {
		this.s1 = s1;
	}


	public Map getMap() {
		return map;
	}


	public void setMap(Map map) {
		this.map = map;
	}


	public Character1 getC() {
		return c;
	}


	public void setC(Character1 c) {
		this.c = c;
	}
	
	
}
