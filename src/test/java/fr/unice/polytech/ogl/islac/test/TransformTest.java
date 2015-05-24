package fr.unice.polytech.ogl.islac.test;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import fr.unice.polytech.ogl.islac.Explorer;
import fr.unice.polytech.ogl.islac.action.Transform;

public class TransformTest {

	Transform transform;
	HashMap<String, Integer> resourceList;
	
	@Before public void init(){
		transform = new Transform();
		resourceList = new HashMap<>();
	}
	
	@Test public void actTransformTest() {				
		//System.out.println(transform.act(resourceList));
		assertEquals("transform", transform.getData(transform.act(resourceList),"action"));
		resourceList.put("SUGAR_CANE", 100);
		resourceList.put("FRUIT", 10);
		assertEquals((long)100, transform.getData(transform.act(resourceList), "parameters", "SUGAR_CANE"));
		//System.out.println(transform.generateJSONString(resourceList));
	}
	
	@Test public void readTransformTest(){
		String response = "{\"status\": \"OK\",\"cost\": 12,\"extras\": {\"kind\": \"RUM\", \"production\": 9}}";	
		//transform.read(response, null);
		
		//Explorer e = new Explorer();
		//e.initialize("{\"creek\": \"b92004d5-505d-450a-a167-c57c7d4b02ff\",\"men\": 25,\"budget\": 9000,\"objective\": [{\"amount\": 50,\"resource\": \"QUARTZ\"},{\"amount\": 500,\"resource\": \"FUR\"}]}");
		//String decision = e.takeDecision();
		//System.out.println(decision);
		//e.acknowledgeResults("{ \"status\":\"OK\", \"cost\": 12 }");
			
	}
	
	/**
	 * 
	 */
	@Test public void explorerTransformTest(){
		Explorer e = new Explorer();
		e.initialize("{\"creek\": \"b92004d5-505d-450a-a167-c57c7d4b02ff\",\"men\": 25,\"budget\": 9000,\"objective\": [{\"amount\": 50,\"resource\": \"PLANK\"},{\"amount\": 500,\"resource\": \"FUR\"}]}");
		String decision = e.takeDecision();
		System.out.println(decision);
		System.out.println(e.sim1.act.getC().getObjectivesAsString());
		e.acknowledgeResults("{ \"status\":\"OK\", \"cost\": 12 }");
		
		decision = e.takeDecision();
		System.out.println(decision);
		e.acknowledgeResults("{\"cost\": 6,\"extras\": {\"altitude\": 0,\"resources\": [\"WOOD\"]},\"status\": \"OK\"}");

		System.out.println(e.sim1.act.getMap().getD(e.sim1.act.getC().getCurrentTuil(), "N"));
		
		decision = e.takeDecision();
		System.out.println(decision);
		e.acknowledgeResults("{\"status\":\"OK\", \"cost\": 21}");
		
		decision = e.takeDecision();
		System.out.println(decision);		
		e.acknowledgeResults("{\"cost\": 7,\"extras\": {\"amount\": 5},\"status\": \"OK\"}");
		
		//System.out.println(e.sim1.act.getC().getObjectivesAsString());
		
		decision = e.takeDecision();
		System.out.println(decision);	
		e.acknowledgeResults("{\"cost\": 5,\"extras\": {\"production\": 3,\"kind\": \"PLANK\"},\"status\": \"OK\"}");
		
		//System.out.println(e.sim1.act.getC().getObjectivesAsString());
		
		decision = e.takeDecision();
		System.out.println(decision);	
		e.acknowledgeResults("{\"cost\": 5,\"extras\": {\"production\": 3,\"kind\": \"PLANK\"},\"status\": \"OK\"}");
		
		//System.out.println(e.sim1.act.getC().getObjectivesAsString());
		
		decision = e.takeDecision();
		System.out.println(decision);	
		e.acknowledgeResults("{\"cost\": 5,\"extras\": {\"production\": 3,\"kind\": \"PLANK\"},\"status\": \"OK\"}");
		
		
		decision = e.takeDecision();
		System.out.println(decision);	
		e.acknowledgeResults("{\"cost\": 5,\"extras\": {\"production\": 3,\"kind\": \"PLANK\"},\"status\": \"OK\"}");
		
		
		decision = e.takeDecision();
		System.out.println(decision);	
		e.acknowledgeResults("{\"cost\": 5,\"extras\": {\"production\": 3,\"kind\": \"PLANK\"},\"status\": \"OK\"}");
		
		decision = e.takeDecision();
		System.out.println(decision);	
	}


}
