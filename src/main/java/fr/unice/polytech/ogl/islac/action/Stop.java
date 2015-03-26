package fr.unice.polytech.ogl.islac.action;

public class Stop extends Action {

	
	public Stop()
	{
		this.name="Stop";
	}
	@Override
	public String act() {
		return "{ \"action\": \"stop\" }";
	}
	
	public void read(String a,Action b)
	{
		
	}
}
