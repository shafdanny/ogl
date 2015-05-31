package fr.unice.polytech.ogl.islac.test;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.unice.polytech.ogl.islac.Explorer;

public class Week19Test {

	@Test
	public void test() {
		Explorer expl = new Explorer();
		String objective = "{\"creek\": \"84886921-6aec-4fcc-89e0-17c7b2c6d48d\",\"men\": 15,\"budget\": 10000,\"objective\": [{\"amount\": 15,\"resource\": \"GLASS\"}{\"amount\": 400,\"resource\": \"QUARTZ\"},{\"amount\": 100,\"resource\": \"FUR\"},{\"amount\": 500,\"resource\": \"PLANK\"}]}";
		
		expl.initialize(objective);
		//System.out.println(objective);
		
		String decision = expl.takeDecision();
		System.out.println(decision);
		expl.acknowledgeResults("{\"cost\": 16,\"extras\": {},\"status\": \"OK\"}");
		
		decision = expl.takeDecision();
		System.out.println(decision);
	}

}
