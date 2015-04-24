package fr.unice.polytech.ogl.islac.test;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.unice.polytech.ogl.islac.action.Action;
import fr.unice.polytech.ogl.islac.action.Glimpse;

public class GlimpseTest {

	@Test
	public void createGlimpse() {
		Action glimpse = new Glimpse();
		assertNotNull(glimpse);
		System.out.println(glimpse.act());	
		System.out.println(glimpse.act("N",2));
	}

}
