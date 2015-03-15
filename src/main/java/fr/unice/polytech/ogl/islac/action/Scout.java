package fr.unice.polytech.ogl.islac.action;

public class Scout extends Action {
	
	
@Override
	public void read(String s)
{
	
}

public String act(String dir){
	return "{ \"action\": \"scout\", \"parameters\": {\"direction\": " +"\""+ dir+"\" " +"} }";
}
	
}
