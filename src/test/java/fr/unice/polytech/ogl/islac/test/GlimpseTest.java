package fr.unice.polytech.ogl.islac.test;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import fr.unice.polytech.ogl.islac.Explorer;
import fr.unice.polytech.ogl.islac.action.Action;
import fr.unice.polytech.ogl.islac.action.Glimpse;
import fr.unice.polytech.ogl.islac.action.Scout;
import fr.unice.polytech.ogl.islac.data.Pos;
import fr.unice.polytech.ogl.islac.data.Tuils;

public class GlimpseTest {

	@Test
	public void createGlimpse() {
		Action glimpse = new Glimpse();
		assertNotNull(glimpse);
		//System.out.println(glimpse.act());	
		//System.out.println(glimpse.act("N",2));
	}
	
	
	@Test
	public void testGlimpse(){
		Explorer e = new Explorer();
		e.initialize("{\"creek\": \"b92004d5-505d-450a-a167-c57c7d4b02ff\",\"men\": 25,\"budget\": 9000,\"objective\": [{\"amount\": 50,\"resource\": \"QUARTZ\"},{\"amount\": 500,\"resource\": \"FUR\"}]}");
		String decision = e.takeDecision();
		//System.out.println(decision);
		e.acknowledgeResults("{ \"status\":\"OK\", \"cost\": 12 }");
		
		decision = e.takeDecision();
		//System.out.println(decision);
		e.acknowledgeResults("{\"cost\": 6,\"extras\": {\"altitude\": 0,\"resources\": [\"FISH\"]},\"status\": \"OK\"}");
		//System.out.println(e.sim1.act.getMap().getMap().get(new Pos(0,1)).isOnlyFish());
		assertTrue(e.sim1.act.getMap().getD(e.sim1.act.getC().getCurrentTuil(), e.sim1.act.getLastDirection()).isOnlyFish());
		
		decision = e.takeDecision();
		//System.out.println(decision);
		//e.acknowledgeResults("{\"cost\": 6,\"extras\": {\"altitude\": 0,\"resources\": [\"FISH\"]},\"status\": \"OK\"}");
		//System.out.println(e.sim1.act.getMap().getMap().get(new Pos(0,1)).isOnlyFish());
		//assertTrue(e.sim1.act.getMap().getD(e.sim1.act.getC().getCurrentTuil(), e.sim1.act.getLastDirection()).isOnlyFish());
		/*
		decision = e.takeDecision();
		//System.out.println(decision);
		e.acknowledgeResults("{\"cost\": 6,\"extras\": {\"altitude\": 0,\"resources\": [\"FISH\"]},\"status\": \"OK\"}");
		//System.out.println(e.sim1.act.getMap().getMap().get(new Pos(0,1)).isOnlyFish());
		assertTrue(e.sim1.act.getMap().getD(e.sim1.act.getC().getCurrentTuil(), e.sim1.act.getLastDirection()).isOnlyFish());

		decision = e.takeDecision();
		//System.out.println(decision);
		e.acknowledgeResults("{\"cost\": 6,\"extras\": {\"altitude\": 0,\"resources\": [\"FISH\"]},\"status\": \"OK\"}");		
		//System.out.println(e.sim1.act.getMap().getMap().get(new Pos(0,1)).isOnlyFish());
		assertTrue(e.sim1.act.getMap().getD(e.sim1.act.getC().getCurrentTuil(), e.sim1.act.getLastDirection()).isOnlyFish());
		
		decision = e.takeDecision();
		System.out.println(decision);
		String glimpseResponse = "{ \"status\": \"OK\", \"cost\": 12,\"extras\": {\"asked_range\": 2,\"report\": [[[\"MANGROVE\", 80.0], [\"BEACH\", 20.0]],[[\"MANGROVE\", 40.0], [\"TROPICAL_RAIN_FOREST\", 40.0], [\"TROPICAL_SEASONAL_FOREST\", 20.0]],[\"TROPICAL_RAIN_FOREST\", \"TROPICAL_SEASONAL_FOREST\"],[\"TROPICAL_RAIN_FOREST\"]]}}";
		e.acknowledgeResults(glimpseResponse);
		System.out.println(e.sim1.act.getMap().getD(e.sim1.act.getC().getCurrentTuil(), e.sim1.act.getLastDirection()).isOnlyFish());
		assertFalse(e.sim1.act.getMap().getD(e.sim1.act.getC().getCurrentTuil(), e.sim1.act.getLastDirection()).isOnlyFish());

		decision = e.takeDecision();
		//System.out.println(decision);*/
	}

}
