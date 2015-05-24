package fr.unice.polytech.ogl.islac.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import fr.unice.polytech.ogl.islac.data.Ressources;
import fr.unice.polytech.ogl.islac.data.SecondaryRessources;

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
		 SecondaryRessources glass=new SecondaryRessources("GLASS",10);		 
		 assertTrue(glass.getResourceNeededToTransform().contains(new Ressources("QUARTZ",10)));
		 assertTrue(glass.getResourceNeededToTransform().contains(new Ressources("WOOD",5)));
		 assertFalse(glass.getResourceNeededToTransform().contains(new Ressources("FISH",5)));
		 		 
		 SecondaryRessources ingot=new SecondaryRessources("INGOT",10);
		 assertTrue(ingot.getResourceNeededToTransform().contains(new Ressources("ORE",5)));
		 assertTrue(ingot.getResourceNeededToTransform().contains(new Ressources("WOOD",5)));
		 assertFalse(ingot.getResourceNeededToTransform().contains(new Ressources("QUARTZ",5)));
		 
		 SecondaryRessources plank=new SecondaryRessources("PLANK",10);
		 assertTrue(plank.getResourceNeededToTransform().contains(new Ressources("WOOD",1)));
		 assertFalse(plank.getResourceNeededToTransform().contains(new Ressources("WOOD",5)));
		 assertFalse(plank.getResourceNeededToTransform().contains(new Ressources("FISH",5)));
		 
		 SecondaryRessources leather =new SecondaryRessources("LEATHER",10);
		 assertTrue(leather.getResourceNeededToTransform().contains(new Ressources("FUR",3)));
		 assertFalse(leather.getResourceNeededToTransform().contains(new Ressources("WOOD",5)));
		 assertFalse(leather.getResourceNeededToTransform().contains(new Ressources("FISH",5)));
		 
		 SecondaryRessources rum=new SecondaryRessources("RUM",10);
		 assertTrue(rum.getResourceNeededToTransform().contains(new Ressources("SUGAR_CANE",10)));
		 assertTrue(rum.getResourceNeededToTransform().contains(new Ressources("FRUITS",1)));
		 assertFalse(rum.getResourceNeededToTransform().contains(new Ressources("FISH",5)));
		 
	 }

}
