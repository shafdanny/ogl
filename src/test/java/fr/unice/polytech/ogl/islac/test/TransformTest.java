package fr.unice.polytech.ogl.islac.test;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;

import fr.unice.polytech.ogl.islac.action.Transform;

public class TransformTest {

	Transform transform;
	HashMap<String, Integer> resourceList;
	
	@Before public void init(){
		transform = new Transform();
		resourceList = new HashMap<>();
	}
	
	@Test public void actTransformTest() {				
		
		assertEquals("transform", getDataFromJson(transform.act(resourceList),"action"));
		
		resourceList.put("SUGAR_CANE", 100);
		assertEquals((long)100, getDataFromJson(transform.act(resourceList), "parameters", "SUGAR_CANE"));
	}
	
	@Test public void readTransformTest(){
		String response = "{\"status\": \"OK\",cost: 12,\"extras\": {\"kind\": \"RUM\", \"production\": 9}}";
			
	}
	
	public Object getDataFromJson(String jsonString, String key){
		JSONParser parser = new JSONParser();
		Object result = new Object();
		try {
			Object obj = parser.parse(jsonString);
			JSONObject json = (JSONObject)obj;
			//System.out.println(json.toString());
			result = json.get(key);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	
		return result;
	}
	
public Object getDataFromJson(String jsonString, String key1, String key2){
		JSONObject jsonObj = (JSONObject)getDataFromJson(jsonString, key1);
		
		Object result = new Object();
		//System.out.println(jsonObj.toString());
		result = jsonObj.get(key2);
		return result;
	}

}
