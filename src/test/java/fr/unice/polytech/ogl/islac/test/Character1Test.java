package fr.unice.polytech.ogl.islac.test;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import fr.unice.polytech.ogl.islac.character.Character1;
import fr.unice.polytech.ogl.islac.data.Pos;
import fr.unice.polytech.ogl.islac.data.Ressources;
import fr.unice.polytech.ogl.islac.data.Tuils;

public class Character1Test {
	
	Character1 c;
	
	@Before public void init(){
		c = new Character1();
	}
	
	@Test public void addPa(){
		c.setPa(5);
		c.addPa(5);
		assertEquals(c.getPa(),0);
	}
	
	
	@Test public void testPosition(){
		Pos pos = new Pos(0, 0);
		assertEquals(pos,c.getPos());
		pos = new Pos(10,5);
		c.setPos(pos);
		assertEquals(pos,c.getPos());
	}
	
	@Test public void testNb(){
		assertEquals(0,c.getNbTotal());
		c.setNbTotal(50);
		assertEquals(50,c.getNbTotal());
		
		assertEquals(0,c.getNbLand());
		c.setNbLand(10);
		assertEquals(10,c.getNbLand());	
		
		assertEquals(40,c.getNbBoat());	
	}
	
	@Test public void getNbBoat(){
		Character1 c = new Character1();
		c.setNbLand(50);
		c.setNbTotal(70);
		assertEquals(c.getNbBoat(), 20);
	}
	
	
	
	@Test public void setCurrentTuil() {
		Character1 c = new Character1();
		Tuils t = new Tuils(4,7);
		Tuils t2 = new Tuils(9,16);
		c.setCurrentTuil(t);
		
		assertEquals(c.getCurrentTuil().getPos().getX(), t.getPos().getX());
		assertEquals(c.getCurrentTuil().getPos().getY(), t.getPos().getY());

		c.setCurrentTuil(t2);
		
		assertEquals(c.getCurrentTuil().getPos().getX(), t2.getPos().getX());
		assertEquals(c.getCurrentTuil().getPos().getY(), t2.getPos().getY());

	}

	@Test public void setObj() {
		Character1 c = new Character1();
		ArrayList<Ressources> obj = new ArrayList<Ressources>();
		Ressources r = new Ressources("WOOD", 50);
		obj.add(r);
		c.setObj(obj);
		assertEquals(c.getPrimaryObjectives().get(0).getName(), "WOOD");
		assertEquals(c.getPrimaryObjectives().get(0).getQuantityNeeded(), 50);

	}
	
	@Test public void testRessources(){
		assertNotNull(c.getPrimaryObjectives());
		ArrayList<Ressources> resources = new ArrayList<Ressources>();
		resources.add(new Ressources("WOOD", 10));
		resources.add(new Ressources("FUR", 50));
		resources.add(new Ressources("FLOWER", 150));

		c.setObj(resources);
		
		assertNotNull(c.getRessource("FUR"));
		assertNotNull(c.getRessource("WOOD"));
		assertNull(c.getRessource("FISH"));
		
		assertEquals(c.getRessource("FLOWER").getName(), "FLOWER");
		assertEquals(c.getRessource("FLOWER").getQuantityNeeded(), 150);
		
	}
	
}

	
	