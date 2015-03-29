package fr.unice.polytech.ogl.islac.test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.unice.polytech.ogl.islac.character.Character1;

public class Character1Test {
	
	public void addPa(){
	Character1 c = new Character1();
	Character1 expected = new Character1();
	Character1 result = new Character1();
	c.setPa(5);
	expected.setPa(15);
	result.setPa(c.getPa()+10);
	assertEquals(expected.getPa(), result.getPa());
	}
}

	
	