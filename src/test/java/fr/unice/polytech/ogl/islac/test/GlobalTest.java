package fr.unice.polytech.ogl.islac.test;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import eu.ace_design.island.bot.IExplorerRaid;
import fr.unice.polytech.ogl.islac.Explorer;
import fr.unice.polytech.ogl.islac.Simulator;
import fr.unice.polytech.ogl.islac.data.Ressources;



/**
 * 
 * Global test to see the interaction between explorer and the game engine.
 * Multiple scenarios can be given to see what is the response of the robot.
 * The robot intelligence can be represented by an automata with different states and transitions
 * The states is the action that it takes and the transition is the decision making. 
 * 
 * 0 INIT
 * 1 LAND
 * 2 SCOUT
 * 3 GLIMPSE
 * 4 MOVE_TO
 * 5 EXPLORE
 * 6 EXPLOIT
 * 7 TRANSFORM
 * 8 STOP
 * 
 * @author Shafiq
 *
 */
public class GlobalTest {
	// A sample of initialisation message
	String context = getContext(); //TODO an example of init
	String creekId = "THIS34IS12A85CREEK87ID";
	//IExplorerRaid r;
	Explorer r;
	String decision;
	
	/**
	 * This correspond to the step 0 INIT (saving the data needed in the robot)
	 */
	@Before public void initRobot(){
		r = new Explorer();
		r.initialize(context);
		//System.out.println("initialisation");
	}
	
	/**
	 * This correspond to the step 1 LAND (landing the robot on a creek given)
	 */
	@Test public void land(){
		decision = r.takeDecision();
		//System.out.println(decision);
		assertEquals("land",getStringValue(decision,"action"));
		assertEquals(creekId,getStringValue(decision,"parameters","creek"));
		r.acknowledgeResults("{ \"status\":\"OK\", \"cost\": 12 }");
	}
	
	/**
	 * Generate the initialisation string. 
	 * @return
	 */
	public String getContext(){
		JSONObject obj;
		JSONParser jsonparser;
		obj = new JSONObject();		
		
		JSONObject objective = new JSONObject();
		JSONArray list = new JSONArray();
		
		objective.put("resource", "WOOD");
		objective.put("amount", new Integer(600));
		
		
	
		list.add(objective);
				
		obj.put("creek", "THIS34IS12A85CREEK87ID"); // cannot use creekId ???
		obj.put("budget", new Integer(600));
		obj.put("men", new Integer(50));
		obj.put("objective", list);
		
		//System.out.println(obj.toString());
		
		return obj.toString();
	}
	
	/**
	 * The string returned by the robot when taking decision is in JSON format.
	 * Return the value corresponding to a key given in a JSON string.
	 * 
	 * @param decision
	 * @param key
	 * @return
	 */
	public String getStringValue(String decision,String key){
		JSONParser parser = new JSONParser();
		
		JSONObject jsonObject;
		try {
			jsonObject = (JSONObject) parser.parse(decision);
			String result = (String)jsonObject.get(key);	
			return result;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return "";		
	}
	
	public String getStringValue(String decision,String key1, String key2){
		JSONParser parser = new JSONParser();
		
		JSONObject jsonObject;
		try {
			jsonObject = (JSONObject) parser.parse(decision);
			JSONObject parameter = (JSONObject) jsonObject.get(key1);	
			String result = (String)parameter.get(key2);
			return result;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return "";		
	}
	
	/**
	 * Initialization test. Make sure that the explorer is created (not null)
	 * and that it receive the information given at the start of the game. 
	 */
	@Test public void initExplorer(){
		//IExplorerRaid r = new Explorer();
		assertNotNull(r);		
	}
	
	/**
	 * Scenario #XX
	 * The game engine give warning that the robot is going to the boundary of the map.
	 * The robot should not proceed to the tile that is out of boundary. 
	 */
	@Ignore public void approachingBoundary(){
		
	}
	
	/**
	 * Scenario #XX
	 * The current tile is full of resources that is needed in the objective.
	 * The robot should exploit this tile. 
	 */
	@Ignore public void inHighResourceTile(){
		
	}
	
	/**
	 * Test the behavior of the robot after a landing.
	 * We expect that the robot to scout at all direction until it found a tile
	 * with the objective resource.
	 * In this case, it scout all NSEW tile.
	 */
	@Test public void afterLandNoRessourceSurround(){
		land();
		
		decision = r.takeDecision();
		assertEquals("scout",getStringValue(decision,"action"));
		//System.out.println(decision);
		r.acknowledgeResults("{\"cost\": 6,\"extras\": {\"altitude\": 0,\"resources\": [\"FUR\",\"FISH\"]},\"status\": \"OK\"}");
		decision = r.takeDecision();
		assertEquals("scout",getStringValue(decision,"action"));
		//System.out.println(decision);
		r.acknowledgeResults("{\"cost\": 6,\"extras\": {\"altitude\": 0,\"resources\": [\"FUR\",\"FISH\"]},\"status\": \"OK\"}");
		decision = r.takeDecision();
		assertEquals("scout",getStringValue(decision,"action"));
		//System.out.println(decision);
		r.acknowledgeResults("{\"cost\": 6,\"extras\": {\"altitude\": 0,\"resources\": [\"FUR\",\"FISH\"]},\"status\": \"OK\"}");
		decision = r.takeDecision();
		assertEquals("scout",getStringValue(decision,"action"));
		//System.out.println(decision);
		r.acknowledgeResults("{\"cost\": 6,\"extras\": {\"altitude\": 0,\"resources\": [\"FUR\",\"FISH\"]},\"status\": \"OK\"}");	
	}
	
	/**
	 * Scenario #XX
	 * The scouted tile have resources that is needed in the objective.
	 * The robot should move to this tile. 
	 */
	@Test public void scoutedResourceTile(){
		land();
		
		decision = r.takeDecision();
		//System.out.println(decision);
		r.acknowledgeResults("{\"cost\": 6,\"extras\": {\"altitude\": 0,\"resources\": [\"FUR\",\"WOOD\"]},\"status\": \"OK\"}");
		
		decision = r.takeDecision();
		String dir = "";
		
		r.acknowledgeResults("{\"cost\": 6,\"extras\": {\"altitude\": 0,\"resources\": [\"FUR\",\"WOOD\"]},\"status\": \"OK\"}");
		
		try {
	    	  JSONParser parser=new JSONParser();		  
		      JSONObject obj = (JSONObject)parser.parse(decision);
		      JSONObject obj1= (JSONObject)obj.get("parameters");
		      dir = obj1.get("direction").toString();
		      
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		assertEquals("move_to",getStringValue(decision,"action"));
		assertEquals("N",dir);
		//System.out.println("scoutedHRT : " + decision);
		r.acknowledgeResults("{\"status\":\"OK\", \"cost\": 21}");
		
	}
	
	/**
	 * Scenario #XX
	 * Low action point.
	 * Stop the game.
	 */
	@Test public void lowPA(){
		decision = r.takeDecision();
		//System.out.println(decision);
		assertEquals("land",getStringValue(decision,"action"));
		assertEquals(creekId,getStringValue(decision,"parameters","creek"));
		r.acknowledgeResults("{ \"status\":\"OK\", \"cost\": 550 }");
		decision = r.takeDecision();
		//System.out.println("LOWPA : " + decision);
		assertEquals("stop",getStringValue(decision,"action"));
	}
	
	/**
	 * Problem detected in week13
	 * If no resource is detected after scouting, go to any tile randomly.
	 *  
	 */
	@Test public void noResourceScouted(){
		afterLandNoRessourceSurround();
		
		decision = r.takeDecision();
		assertEquals("move_to",getStringValue(decision,"action"));
		//System.out.println(decision);
		//assertEquals("scout",getStringValue(decision,"action"));
	}
	
	/**
	 * If we just moved to a tile with resource (we know this because the tile is scouted),
	 * we should Explore before Exploit?
	 * For now exploit it immediately!
	 */
	@Test public void inTileWithResource(){
		scoutedResourceTile();
		decision = r.takeDecision();
		//System.out.println(decision);
		assertEquals("exploit",getStringValue(decision,"action"));
		assertEquals("WOOD",getStringValue(decision,"parameters","resource"));
	}
	
	/**
	 * The tile contains multiple ressources needed in the objective.
	 * We expect the robot to exploit all the ressources needed.
	 * When the amount exploited is little, do a scout. 
	 *  
	 */	
	@Test public void inTileWithMultipleResources(){
		Explorer expl = new Explorer();
		String objective = "{\"creek\": \"b92004d5-505d-450a-a167-c57c7d4b02ff\",\"men\": 25,\"budget\": 9000,\"objective\": [{\"amount\": 50,\"resource\": \"QUARTZ\"},{\"amount\": 500,\"resource\": \"FUR\"}]}";
		expl.initialize(objective);
		//System.out.println(objective);
		
		//System.out.println(expl.sim1.act.getC().getObj().get(0).getName());
		
		decision = expl.takeDecision();
		//System.out.println(decision);
		assertEquals("land",getStringValue(decision,"action"));
		//assertEquals(creekId,getStringValue(decision,"parameters","creek"));
		expl.acknowledgeResults("{ \"status\":\"OK\", \"cost\": 12 }");
		
		decision = expl.takeDecision();
		assertEquals("scout",getStringValue(decision,"action"));
		//System.out.println(decision);
		expl.acknowledgeResults("{\"cost\": 6,\"extras\": {\"altitude\": 0,\"resources\": [\"FUR\",\"QUARTZ\"]},\"status\": \"OK\"}");
				
		
		decision = expl.takeDecision();
		//System.out.println(decision);
		expl.acknowledgeResults("{ \"status\":\"OK\", \"cost\": 12 }");
		//System.out.println(decision);
		//System.out.println(expl.sim1.act.getC().getCurrentTuil().getObj1());
		
		decision = expl.takeDecision();
		assertEquals(getStringValue(decision, "action"),"exploit");
		//System.out.println(decision);
		//System.out.println(decision);
		expl.acknowledgeResults("{\"status\":\"OK\", \"cost\": 37, \"extras\": { \"amount\": 1 } }");
		decision = expl.takeDecision();
		//System.out.println(decision);
		assertEquals(getStringValue(decision, "action"),"exploit");
		//System.out.println(decision);
		//expl.acknowledgeResults("{\"status\":\"OK\", \"cost\": 37, \"extras\": { \"amount\": 5 } }");
		//decision = expl.takeDecision();
		//assertEquals(getStringValue(decision, "action"),"scout");
		//System.out.println(decision);
	}
	
	
	/**
	 * After moving to a tile with the resource needed, Explore the tile
	 */
	@Ignore public void afterMove(){
		
	}
	
	/**
	 * Problem detected in week16.
	 * When the robot scouted the surrounding NSEW tiles, all the tiles have FISH.
	 * 
	 * Solution : Do a glimpse to make sure that the tile scouted contains land.
	 * 
	 * 
	 */
	@Test public void nearbyTilesContainsWater(){
		land();
		decision = r.takeDecision();
		//System.out.println(decision);
		
		r.acknowledgeResults("{\"cost\": 6,\"extras\": {\"altitude\": 0,\"resources\": [\"FISH\"]},\"status\": \"OK\"}");
		decision = r.takeDecision();
		//System.out.println(decision);
		r.acknowledgeResults("{\"cost\": 6,\"extras\": {\"altitude\": 0,\"resources\": [\"FISH\"]},\"status\": \"OK\"}");
		decision = r.takeDecision();
		//System.out.println(decision);
		r.acknowledgeResults("{\"cost\": 6,\"extras\": {\"altitude\": 0,\"resources\": [\"FISH\"]},\"status\": \"OK\"}");
		decision = r.takeDecision();
		//System.out.println(decision);
		r.acknowledgeResults("{\"cost\": 6,\"extras\": {\"altitude\": 0,\"resources\": [\"FISH\"]},\"status\": \"OK\"}");		
		decision = r.takeDecision();
		//System.out.println(decision);
		assertEquals("glimpse", getStringValue(decision, "action"));
	}
	
	@Test public void collectedEnoughResources(){
		land();
		
		//System.out.println(r.sim1.act.getC().getObjectivesAsString());
		
		decision = r.takeDecision();
		//System.out.println(decision);
		r.acknowledgeResults("{\"cost\": 6,\"extras\": {\"altitude\": 0,\"resources\": [\"FUR\",\"WOOD\"]},\"status\": \"OK\"}");

		decision = r.takeDecision();
		//System.out.println(decision);
		r.acknowledgeResults("{\"status\":\"OK\", \"cost\": 21}");

		decision = r.takeDecision();
		//System.out.println(decision);
		r.acknowledgeResults("{\"status\":\"OK\", \"cost\": 37, \"extras\": { \"amount\": 601 } }");
		
		decision = r.takeDecision();
		//System.out.println(r.sim1.act.getC().getObjectivesAsString());
		//System.out.println(decision);
		
	}
	
	/**
	 * Based on week19
	 */
	@Test public void primaryAndSecondaryObjectives(){
		Explorer expl = new Explorer();
		String objective = "{\"creek\": \"84886921-6aec-4fcc-89e0-17c7b2c6d48d\",\"men\": 15,\"budget\": 10000,\"objective\": [{\"amount\": 15,\"resource\": \"GLASS\"}{\"amount\": 400,\"resource\": \"QUARTZ\"},{\"amount\": 100,\"resource\": \"FUR\"},{\"amount\": 500,\"resource\": \"PLANK\"}]}";
		
		expl.initialize(objective);
		//System.out.println(objective);
		decision = expl.takeDecision();
		//System.out.println(decision);
		expl.acknowledgeResults("{\"cost\": 16,\"extras\": {},\"status\": \"OK\"}");
		
		decision = expl.takeDecision();
		//System.out.println(decision);
		
	}
	
	/**
	 * Problem detected in week17. 
	 * When an objective is completed, the robot should repeat the behaviour with another objective.
	 */
	@Test public void anObjectiveIsCompleted(){
		// initialization
		Explorer exp = new Explorer();
		String objective = "{\"creek\": \"ebd87be3-4fce-4ee4-b03a-c935bde042f0\",\"men\": 30,\"budget\": 9000,\"objective\": [{\"amount\": 500,\"resource\": \"WOOD\"},{\"amount\": 50,\"resource\": \"FUR\"}]}";
		exp.initialize(objective);
		
		// land
		decision = exp.takeDecision();
		System.out.println(decision);		
		assertEquals("land", getStringValue(decision, "action"));
		exp.acknowledgeResults("{\"cost\": 16,\"extras\": {},\"status\": \"OK\"}");
		
		decision = exp.takeDecision();
		System.out.println(decision);
		exp.acknowledgeResults("{\"cost\": 6,\"extras\": {\"altitude\": 0,\"resources\": [\"FISH\"]},\"status\": \"OK\"}");
		
		decision = exp.takeDecision();
		System.out.println(decision);
		exp.acknowledgeResults("{\"cost\": 6,\"extras\": {\"altitude\": 0,\"resources\": [\"WOOD\"]},\"status\": \"OK\"}");

		decision = exp.takeDecision();
		System.out.println(decision);
		exp.acknowledgeResults("{\"cost\": 3,\"extras\": {},\"status\": \"OK\"}");
		
		//System.out.println(exp.sim1.act.getC().getObjectivesAsString());
		assertTrue(exp.sim1.act.getC().getPrimaryObjectives().contains(new Ressources("WOOD", 500)));
		
		decision = exp.takeDecision();
		System.out.println(decision);
		exp.acknowledgeResults("{\"status\":\"OK\", \"cost\": 37, \"extras\": { \"amount\": 601 } }");

		//System.out.println(exp.sim1.act.getC().getObjectivesAsString());
		
		decision = exp.takeDecision();
		System.out.println(decision);
		exp.acknowledgeResults("{\"cost\": 6,\"extras\": {\"altitude\": 0,\"resources\": [\"WOOD\"]},\"status\": \"OK\"}");
		
		assertFalse(exp.sim1.act.getC().getPrimaryObjectives().contains(new Ressources("WOOD", 500)));
		//System.out.println(exp.sim1.act.getC().getObjectivesAsString());
		
		decision = exp.takeDecision();
		System.out.println(decision);
	}
	
}
