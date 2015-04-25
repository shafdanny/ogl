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
	
		Character1 expected = new Character1();
		Character1 result = new Character1();
		c.setPa(5);
		expected.setPa(15);
		result.setPa(c.getPa()+10);
		assertEquals(expected.getPa(), result.getPa());
		
		c.addPa(5);
		assertEquals(0,c.getPa());
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
	
	@Test public void testTuils(){
		Tuils tuil = new Tuils();
		c.setCurrentTuil(tuil);
		assertEquals(tuil,c.getCurrentTuil());
	}
	
	@Test public void testRessources(){
		assertNotNull(c.getObj());
		ArrayList<Ressources> resources = new ArrayList<Ressources>();
		resources.add(new Ressources("WOOD", 10));
		resources.add(new Ressources("FUR", 10));
		c.setObj(resources);
		assertNotNull(c.getRessource("FUR"));
		assertNotNull(c.getRessource("WOOD"));
		assertNull(c.getRessource("FISH"));
	}
	
}

	
	