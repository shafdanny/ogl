package fr.unice.polytech.ogl.islac.test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import fr.unice.polytech.ogl.islac.action.Action;
import fr.unice.polytech.ogl.islac.action.Explore;
import fr.unice.polytech.ogl.islac.action.Scout;
import fr.unice.polytech.ogl.islac.character.*;
import fr.unice.polytech.ogl.islac.data.Arena;
import fr.unice.polytech.ogl.islac.data.Pos;
import fr.unice.polytech.ogl.islac.data.Tuils;

public class ExploreTest {

	@Ignore public void readExplore(){

			String s = "{\"status\":\"OK\", \"cost\": 39,\"extras\": {\"resources\":[{\"resource\": \"WOOD\",\"amount\": \"HIGH\",\"cond\": \"EASY\"},{\"resource\": \"FUR\", \"amount\": \"LOW\",\"cond\": \"FAIR\"},{\"resource\": \"FLOWER\", \"amount\": \"MEDIUM\", \"cond\": \"HARSH\" }],\"pois\": [{\"kind\": \"CREEK\", \"id\": \"creek_identifier_2\" }]}}";
			
			Action test= new Action();
			test.initAction();
			Tuils t1=new Tuils(0,0);
			test.getC().setCurrentTuil(t1);	
			test.setLastAction(new Explore());

			//System.out.println(test.getC().getPa());
			new Explore().read(s,test);
			
			//long k= test.getC().getPa();
			
			//System.out.println(k);
			// assertEquals(k, -8);
			test.getC().getCurrentTuil();
			
			assert(test.getC().getCurrentTuil().isWood());
			assert(test.getMap().getD(test.getC().getCurrentTuil(),"N").isFur());
			assert(test.getMap().getD(test.getC().getCurrentTuil(),"N").isFlower());
			assert(!test.getMap().getD(test.getC().getCurrentTuil(),"N").isFish());
			assert(!test.getMap().getD(test.getC().getCurrentTuil(),"N").isOnlyFish()); 
				
	}
}
