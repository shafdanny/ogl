package fr.unice.polytech.ogl.islac.test;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.unice.polytech.ogl.islac.Explorer;

public class MovementTest {

	@Test
	public void test() {
		Explorer e = new Explorer();
		String context = "{\"creek\": \"f5ba8aa4-540e-4fd3-b5d7-6834590e675c\",\"men\": 15,\"budget\": 10000,\"objective\": [{\"amount\": 15,\"resource\": \"GLASS\"},{\"amount\": 400,\"resource\": \"QUARTZ\"},{\"amount\": 100,\"resource\": \"FUR\"},{\"amount\": 500,\"resource\": \"PLANK\"}]}";
		e.initialize(context);
		String decision = e.takeDecision();
		System.out.println(decision);
		e.acknowledgeResults("{\"cost\": 13,\"extras\": {},\"status\": \"OK\"}");
		
		decision = e.takeDecision();
		System.out.println(decision);
		e.acknowledgeResults("{\"cost\": 6,\"extras\": {\"altitude\": 0,\"resources\": [\"FISH\"]},\"status\": \"OK\"}");

		decision = e.takeDecision();
		System.out.println(decision);
		e.acknowledgeResults("{\"cost\": 6,\"extras\": {\"altitude\": 1,\"resources\": [\"FISH\"]},\"status\": \"OK\"}");

		decision = e.takeDecision();
		System.out.println(decision);
		e.acknowledgeResults("{\"cost\": 4,\"extras\": {\"altitude\": 0,\"resources\": [\"FISH\"]},\"status\": \"OK\"}");
		
		decision = e.takeDecision();
		System.out.println(decision);
		e.acknowledgeResults("{\"cost\": 6,\"extras\": {\"altitude\": 1,\"resources\": [\"FISH\"]},\"status\": \"OK\"}");

		decision = e.takeDecision();
		System.out.println(decision);
		e.acknowledgeResults("{\"cost\": 7,\"extras\": {\"asked_range\": 2,\"report\": [[[\"OCEAN\",62.88],[\"OCEAN\",34.09],[\"BEACH\",3.03]],[[\"OCEAN\",65.4],[\"BEACH\",34.6]]]}}");

		decision = e.takeDecision();
		System.out.println(decision);
		e.acknowledgeResults("{\"cost\": 3,\"extras\": {},\"status\": \"OK\"}");
		
		decision = e.takeDecision();
		System.out.println(decision);
		e.acknowledgeResults("{\"cost\": 6,\"extras\": {\"altitude\": 0,\"resources\": [\"FISH\"]},\"status\": \"OK\"}");

		decision = e.takeDecision();
		System.out.println(decision);
		e.acknowledgeResults("{\"cost\": 6,\"extras\": {\"altitude\": 1,\"resources\": [\"FISH\"]},\"status\": \"OK\"}");

		decision = e.takeDecision();
		System.out.println(decision);
		e.acknowledgeResults("{\"cost\": 4,\"extras\": {\"altitude\": 0,\"resources\": [\"FISH\"]},\"status\": \"OK\"}");
		
		decision = e.takeDecision();
		System.out.println(decision);
		e.acknowledgeResults("{\"cost\": 6,\"extras\": {\"altitude\": 1,\"resources\": []},\"status\": \"OK\"}");

		decision = e.takeDecision();
		System.out.println(decision);
		e.acknowledgeResults("{\"cost\": 4,\"extras\": {},\"status\": \"OK\"}");
		
		decision = e.takeDecision();
		System.out.println(decision);

	}

}
