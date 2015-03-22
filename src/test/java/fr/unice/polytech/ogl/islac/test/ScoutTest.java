package fr.unice.polytech.ogl.islac.test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.unice.polytech.ogl.islac.action.Action;
import fr.unice.polytech.ogl.islac.action.Scout;
import fr.unice.polytech.ogl.islac.character.*;
import fr.unice.polytech.ogl.islac.data.Arena;
import fr.unice.polytech.ogl.islac.data.Tuils;

public class ScoutTest {

	 public void readScout(){
		
		String s = "{\"status\":\"OK\", \"cost\": 8,\"extras\": {\"resources\": [\"WOOD\", \"FUR\", \"FLOWER\"], \"altitude\" : -23}}";
		Action test= new Action();
		Tuils t1=new Tuils(0,0);
		test.getC().setCurrentTuil(t1);	
		Arena map = test.getMap();
		//test.setLastAction(new Scout());
		test.setLastDirection("N");
		
		//new Scout().readScout(s);
		long k= test.getC().getPa();
		//assertEquals(k, -8);
	/*	assert(map.getD(test.getC().getCurrentTuil(),"N").isWood());
		assert(map.getD(test.getC().getCurrentTuil(),"N").isFur());
		assert(map.getD(test.getC().getCurrentTuil(),"N").isFlower());
		assert(!map.getD(test.getC().getCurrentTuil(),"N").isFish());
		assert(!map.getD(test.getC().getCurrentTuil(),"N").isOnlyFish());
		*/
		
		
	}
}
