package fr.unice.polytech.ogl.islac.action;

public class Stop extends Action {

	
	@Override
	public String act() {
		return "{ \"action\": \"stop\" }";
	}
}
