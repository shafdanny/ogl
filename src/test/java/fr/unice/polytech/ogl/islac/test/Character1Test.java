package fr.unice.polytech.ogl.islac.test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.unice.polytech.ogl.islac.character.Character1;

public class Character1Test {
	
	//private Character1
	
	

	@Before public void setUp() {
		Character1 c = new Character1();
		Character1 expected = new Character1();
		Character1 result = new Character1();
	} 
	
	@Test public void addPa(int pa){
	Character1 c = null;
	c.setPa(5);
	Character1 expected = null;
	expected.setPa(15);
	Character1 result = null;
	result.setPa(c.getPa()+10);
	assertEquals(expected.getPa(), result.getPa());
	}
}

	
	