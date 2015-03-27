package fr.unice.polytech.ogl.islac.test;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Ignore;
import org.junit.Test;

import eu.ace_design.island.bot.IExplorerRaid;
import fr.unice.polytech.ogl.islac.Explorer;
/**
 * 
 * Global test to see the interaction between explorer and the game engine.
 * Multiple scenarios can be given to see what is the response of the robot.
 * 
 * @author Shafiq
 *
 */
public class GlobalTest {
	// A sample of initialisation message
	String context = getContext(); //TODO an example of init
	String creekId = "THIS34IS12A85CREEK87ID";
	
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
		
		objective.put("resource", "FISH");
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
		IExplorerRaid r = new Explorer();
		assertNotNull(r);
		r.initialize(context);
		// The robot should land in the given creek
		String decision = r.takeDecision();
		assertEquals("land",getStringValue(decision,"action"));
		assertEquals(creekId,getStringValue(decision,"parameters","creek"));
		//System.out.println(getStringValue(decision,"parameters","creek"));
		//System.out.println(getStringValue(decision,"action"));
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
	 * Scenario #XX
	 * The scouted tile is full of resources that is needed in the objective.
	 * The robot should move to this tile. 
	 */
	@Ignore public void scoutedHighResourceTile(){
		
	}
	
	/**
	 * Scenario #XX
	 * Low action point.
	 * Stop the game.
	 */
	@Ignore public void lowPA(){
		
	}
	
	
	
}
