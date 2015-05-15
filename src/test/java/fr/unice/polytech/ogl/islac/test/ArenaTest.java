package fr.unice.polytech.ogl.islac.test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import fr.unice.polytech.ogl.islac.character.Character1;
import fr.unice.polytech.ogl.islac.data.Arena;
import fr.unice.polytech.ogl.islac.data.Pos;
import fr.unice.polytech.ogl.islac.data.Ressources;
import fr.unice.polytech.ogl.islac.data.Tuils;

public class ArenaTest {
	
	Character1 c;
	Arena a;
	HashMap<Pos,Tuils> map;
	Tuils t;

	
	@Before public void init(){
		c = new Character1();
		a = new Arena(c);
	}
	
	@Test public void update() {
		assertNotNull(c.getObj());
		ArrayList<Ressources> resources = new ArrayList<Ressources>();
		resources.add(new Ressources("WOOD", 10));
		resources.add(new Ressources("FUR", 50));
		resources.add(new Ressources("FLOWER", 150));
		c.setObj(resources);

		a.update(c);
		
		assertEquals(c.getObj().get(0).getName(), "WOOD");
		assertEquals(c.getObj().get(1).getName(), "FUR");
		assertEquals(c.getObj().get(2).getName(), "FLOWER");
	}

	@Test public void addTuils()
	{
		Pos p = new Pos(5,10);
		t = new Tuils(p);
		a.addTuils(t);

		assertEquals(a.getMap().size(), 1);
		assertTrue(a.getMap().containsValue(t));
	}

	@Test public void getNewPos()
	{
		t = new Tuils(0,0);

		System.out.println(a.getNewPos(t,"N").getY());
		
		assertEquals(a.getNewPos(t,"N").getY(), 1);
		assertEquals(a.getNewPos(t,"N").getX(), 0);
		
		assertEquals(a.getNewPos(t,"S").getY(), -1);
		assertEquals(a.getNewPos(t,"S").getX(), 0);

		assertEquals(a.getNewPos(t,"E").getY(), 0);
		assertEquals(a.getNewPos(t,"E").getX(), 1);

		assertEquals(a.getNewPos(t,"W").getX(), -1);
		assertEquals(a.getNewPos(t,"W").getY(), 0);
	}
	
	@Test public void getD()
	{
		t = new Tuils(0,0);
		a.addTuils(t);
		assertNull(a.getD(t,"N"));
		Tuils t1 = new Tuils(0,1);
		a.addTuils(t1);
		assertEquals(a.getD(t,"N"),t1);
	}
	
	@Test public void scout()
	{
		
	}
	
	@Test public void getListCreek() 
	{
		
	}

	@Test public void setListCreek() 
	{
		
	}


	public void getObj1() 
	{
		
	}


	public void setObj1() 
	{
		
	}


	public void getObj2() 
	{
		
	}


	public void setObj2() 
	{
		
	}
	
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	
	public void bestD()
	{
	
	}


	public void getMap() {
	}


	public void setMap() {
		
	}
	
	public void match(){
		
	}


	public void getObj3() {
	}


	public void setObj3(String obj3) {
	}
	                                                            
}
