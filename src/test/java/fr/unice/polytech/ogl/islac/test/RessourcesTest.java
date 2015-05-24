package fr.unice.polytech.ogl.islac.test;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.unice.polytech.ogl.islac.data.Ressources;

public class RessourcesTest {
	
	 @Test public void testEstimCost()
	 {
		 Ressources r1=new Ressources("FUR",400);
		 assertEquals(r1.estimCost(),4500);
		 
		 Ressources r2=new Ressources("ORE",10);
		 assertEquals(r2.estimCost(),580);
		 
		 Ressources r3=new Ressources("FISH",400);
		 assertEquals(r3.estimCost(),900);
		 
		 Ressources r4=new Ressources("??",100);
		 assertEquals(r4.estimCost(),600);
		 
		 
		 
	 }

}
