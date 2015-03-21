package fr.unice.polytech.ogl.islac.action;

public class Move_to extends Action {

	
	public Move_to()
	{
		this.name="Move_to";
	}
	@Override
	// Méthodes move_to
	
	public String act(String direction){
		return "{ \"action\": \"move_to\", \"parameters\": {\"direction\": " +"\""+ direction+"\" " +"} }";
	}
}
