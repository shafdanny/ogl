package fr.unice.polytech.ogl.islac.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import fr.unice.polytech.ogl.islac.Explorer;
import fr.unice.polytech.ogl.islac.data.Ressources;
import fr.unice.polytech.ogl.islac.data.SecondaryRessources;

public class SecondaryRessourcesTest {

	@Test
	public void test() {
		Ressources woodPrim = new Ressources("WOOD", 100);
		SecondaryRessources plank = new SecondaryRessources("PLANK", 50);
		
		Explorer e = new Explorer();
		e.initialize("{\"creek\": \"b920045-505d-450a-a167-c57c7d4b02ff\",\"men\": 25,\"budget\": 9000,\"objective\": [{\"amount\": 50,\"resource\": \"PLANK\"},{\"amount\": 500,\"resource\": \"WOOD\"}]}");
		String decision = e.takeDecision();
		System.out.println(decision);
		
		System.out.println(e.sim1.act.getC().getObjectivesAsString());
		
		ArrayList<Ressources> resourcesNeeded = plank.getResourceNeededToTransform();
		
		for(Ressources res:resourcesNeeded){
			res.addAmountCollected(5);
			System.out.println(res);
			
			for(Ressources res2:e.sim1.act.getC().getPrimaryObjectives()){
				if(res2.isForSecondary())
					System.out.println(res2);
			}
		}
		
		
		
	}

}
