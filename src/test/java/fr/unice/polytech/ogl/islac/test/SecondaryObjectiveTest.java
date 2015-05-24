package fr.unice.polytech.ogl.islac.test;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.unice.polytech.ogl.islac.Explorer;

public class SecondaryObjectiveTest {

	@Test
	public void test() {
		Explorer expl = new Explorer();
		String objective = "{\"creek\": \"b92004d5-505d-450a-a167-c57c7d4b02ff\",\"men\": 25,\"budget\": 9000,\"objective\": [{\"amount\": 50,\"resource\": \"PLANK\"},{\"amount\": 500,\"resource\": \"FUR\"}]}";
		expl.initialize(objective);
		
		System.out.println(expl.sim1.act.getC().getObjectivesAsString());
	}
	
	

}
