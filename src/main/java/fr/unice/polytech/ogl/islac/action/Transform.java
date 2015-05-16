package fr.unice.polytech.ogl.islac.action;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * Transformer des ressources primaires à des ressources secondaires.
 * 
 * @author Shafiq Daniel
 *
 */
public class Transform extends Action{
	
	public String act(HashMap<String,Integer> resource){
		return generateJson(resource);
	}

	private String generateJson(HashMap<String, Integer> resource) {
		JSONObject action = new JSONObject();
		JSONObject param = new JSONObject();
		
		try {
			action.put("action", "transform");
			
			for(String key:resource.keySet()){
				param.put(key,resource.get(key));
			}
			
			action.put("parameters", param);
		} catch (JSONException e) {
			e.printStackTrace();
		}		
		
		return action.toString();
	}
	
	@Override
	public void read(String data, Action a) {
		// TODO Auto-generated method stub
		super.read(data, a);
	}
}
