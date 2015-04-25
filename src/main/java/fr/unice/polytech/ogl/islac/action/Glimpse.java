package fr.unice.polytech.ogl.islac.action;

public class Glimpse extends Action {

	String direction;
	int range;
	
	@Override
	public String act() {
		return "{\"action\": \"glimpse\",\"parameters\": { \"direction\": \"N\", \"range\": 2 }}";
	}
	
	@Override
	public String act(String direction, int range){
		return "{\"action\": \"glimpse\",\"parameters\": { \"direction\": \"" + direction + "\", \"range\": " + range + " }}";
	}
	
	
}
