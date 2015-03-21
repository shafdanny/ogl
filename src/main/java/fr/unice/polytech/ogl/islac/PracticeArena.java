package fr.unice.polytech.ogl.islac;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import eu.ace_design.island.bot.IExplorerRaid;

public class PracticeArena {
	JSONObject obj;
	JSONParser jsonparser;
	String init;
	String result;
	public boolean endOfGame;
	
	public PracticeArena(){
		endOfGame = false;
		result = "this is a result";
		obj = new JSONObject();
		JSONObject objective = new JSONObject();
		JSONArray list = new JSONArray();
		
		objective.put("resource", "WOOD");
		objective.put("amount", new Integer(600));
	
		list.add(objective);
				
		obj.put("creek", "THIS34IS12A85CREEK87ID");
		obj.put("budget", new Integer(600));
		obj.put("men", new Integer(50));
		obj.put("objective", list);
		System.out.println(obj);
		init = obj.toJSONString();
	}	
	
	public String getInit(){
		return init;
	}
	
	public void handleDecision(String decision){
		String action = getAction(decision);
		
		switch(action){
			case "land":System.out.println("---LANDING---");break;
			case "exploit":System.out.println("---EXPLOITING---");break;
			case "explore":System.out.println("---EXPLORING---");break;
			case "move_to":System.out.println("---MOVING---");break;
			case "scout":System.out.println("---SCOUTING---");break;
			case "stop":System.out.println("---STOPING---");break;
			default:System.out.println("ERROR !! ACTION INVALID !!");
					break;
		}
		
	}
	
	public String getAction(String decision){
		JSONObject js = new JSONObject();
		try {
			jsonparser = new JSONParser();
			js = (JSONObject)jsonparser.parse(decision);			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return (js.get("action").toString());
	}
	
	private String getResult() {
		// TODO Auto-generated method stub
		return result;
	}
	
	public static void main(String[] args) {
		PracticeArena p = new PracticeArena();
		
		String decision = "{ \"action\": \"land\", \"parameters\": {\"creek\":" + 10 + ", \"people\":" +	20 + "}}";
		p.handleDecision(decision);
		IExplorerRaid r = new Explorer();
		r.initialize(p.getInit());
		
		while (!p.endOfGame) {
			//String decision = r.takeDecision();
			// handle decision
			p.handleDecision(decision);
			r.acknowledgeResults(p.getResult());
		}
	}

	
	
}
