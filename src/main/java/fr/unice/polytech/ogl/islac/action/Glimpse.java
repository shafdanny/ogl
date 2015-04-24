package fr.unice.polytech.ogl.islac.action;

public class Glimpse extends Action {

	
	
	@Override
	public String act() {
		return "{\"action\": \"glimpse\",\"parameters\": { \"direction\": \"N\", \"range\": 2 }}";
	}
	
	public String act(String direction, int range){
		return "{\"action\": \"glimpse\",\"parameters\": { \"direction\": \"" + direction + "\", \"range\": " + range + " }}";
	}
}
