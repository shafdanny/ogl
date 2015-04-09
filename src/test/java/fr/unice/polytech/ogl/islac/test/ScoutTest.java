package fr.unice.polytech.ogl.islac.test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.unice.polytech.ogl.islac.action.Action;
import fr.unice.polytech.ogl.islac.action.Scout;
import fr.unice.polytech.ogl.islac.character.*;
import fr.unice.polytech.ogl.islac.data.Arena;
import fr.unice.polytech.ogl.islac.data.Pos;
import fr.unice.polytech.ogl.islac.data.Tuils;

public class ScoutTest {

	@Test public void readScout(){

			String s = "{\"status\":\"OK\", \"cost\": 8,\"extras\": {\"resources\": [\"WOOD\", \"FUR\", \"FLOWER\"], \"altitude\" : -23}}";
			
			Action test= new Action();
			test.initAction();
			Tuils t1=new Tuils(0,0);
			test.getC().setCurrentTuil(t1);	
			//Arena map = test.getMap();
			test.setLastAction(new Scout());
			test.setLastDirection("N");

			//System.out.println(test.getC().getPa());
			new Scout().read(s,test);
			
			long k= test.getC().getPa();
			
		//	System.out.println(k);
			// assertEquals(k, -8);
			test.getC().getCurrentTuil();
			
			assert(test.getMap().getD(test.getC().getCurrentTuil(),"N").isWood());
			assert(test.getMap().getD(test.getC().getCurrentTuil(),"N").isFur());
			assert(test.getMap().getD(test.getC().getCurrentTuil(),"N").isFlower());
			assert(!test.getMap().getD(test.getC().getCurrentTuil(),"N").isFish());
			assert(!test.getMap().getD(test.getC().getCurrentTuil(),"N").isOnlyFish()); 
				
	}
}
