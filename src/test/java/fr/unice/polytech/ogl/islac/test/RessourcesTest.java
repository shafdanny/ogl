package fr.unice.polytech.ogl.islac.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

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
	 
	 @Test public void testSecondaryObjective(){
		 Ressources glass=new Ressources("GLASS",10);		 
		 assertTrue(glass.resourceNeededToTransform().contains(new Ressources("QUARTZ",10)));
		 assertTrue(glass.resourceNeededToTransform().contains(new Ressources("WOOD",5)));
		 assertFalse(glass.resourceNeededToTransform().contains(new Ressources("FISH",5)));
		 		 
		 Ressources ingot=new Ressources("INGOT",10);
		 assertTrue(ingot.resourceNeededToTransform().contains(new Ressources("ORE",5)));
		 assertTrue(ingot.resourceNeededToTransform().contains(new Ressources("WOOD",5)));
		 assertFalse(ingot.resourceNeededToTransform().contains(new Ressources("QUARTZ",5)));
		 
		 Ressources plank=new Ressources("PLANK",10);
		 assertTrue(plank.resourceNeededToTransform().contains(new Ressources("WOOD",1)));
		 assertFalse(plank.resourceNeededToTransform().contains(new Ressources("WOOD",5)));
		 assertFalse(plank.resourceNeededToTransform().contains(new Ressources("FISH",5)));
		 
		 Ressources leather=new Ressources("LEATHER",10);
		 assertTrue(leather.resourceNeededToTransform().contains(new Ressources("FUR",3)));
		 assertFalse(leather.resourceNeededToTransform().contains(new Ressources("WOOD",5)));
		 assertFalse(leather.resourceNeededToTransform().contains(new Ressources("FISH",5)));
		 
		 Ressources rum=new Ressources("RUM",10);
		 assertTrue(rum.resourceNeededToTransform().contains(new Ressources("SUGAR_CANE",10)));
		 assertTrue(rum.resourceNeededToTransform().contains(new Ressources("FRUITS",1)));
		 assertFalse(rum.resourceNeededToTransform().contains(new Ressources("FISH",5)));
		 
	 }

}
