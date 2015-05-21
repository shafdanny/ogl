package fr.unice.polytech.ogl.islac.action;

import java.util.HashMap;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import fr.unice.polytech.ogl.islac.tool.JSONTools;


/**
 * Transformer des ressources primaires à des ressources secondaires.
 * 
 * @author Shafiq Daniel
 *
 */
public class Transform extends Action implements JSONTools{
	
	public String act(HashMap<String,Integer> resource){
		return generateJSONString(resource);
	}
	
	@Override
	public void read(String data, Action a) {
		long cost = (long) getData(data, "cost");
		//System.out.println(cost);
		String resourceTransformed = (String) getData(data, "extras", "kind");
		//System.out.println(resourceTransformed);
		long amountProduced = (long) getData(data, "extras", "production");
		//System.out.println(amountProduced);
	}

	@Override
	public Object getData(String json, String... key) {
		JSONParser parser = new JSONParser();
		Object result = new Object();
		try {
			Object obj = (JSONObject) parser.parse(json);
			JSONObject jsonObj = (JSONObject)obj;
			result = jsonObj.get(key[0]);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		if(key.length != 1){
			try {
				Object obj = parser.parse(result.toString());
				JSONObject jsonObj = (JSONObject)obj;
				result = jsonObj.get(key[1]);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	@Override
	public String generateJSONString(Object... parameter) {
		JSONObject action = new JSONObject();
		JSONObject param = new JSONObject();
		
		action.put("action", "transform");
		
		HashMap<String, Integer> resource = (HashMap<String,Integer>) parameter[0];
		
		for(String key:resource.keySet()){
			param.put(key,resource.get(key));
		}
		
		action.put("parameters", param);		
		
		return action.toString();
	}
}
