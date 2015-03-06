package fr.unice.polytech.ogl.islac;

import java.util.*;

public class Methods {
	private List<String> positionCreek;
	
	
	public String stop(){
		return "{ \"action\": \"stop\" }";
	}
	
	// Méthodes pour les creek
	
	
	public String land(String creek_id, int number){
		return "{ \"action\": \"land\", \"parameters\": {\"creek\":" + creek_id + ", \"people\":" +	number + "}}";
	}
	
	public String getPositionCreek(){
		return null;
	}
	
	public void addPositionCreek(String creek_id){
		positionCreek.add(creek_id);
	}
	
	
	// Méthodes scout
	
	public String scout(String direction){
		return "{ \"action\": \"scout\", \"parameters\": {\"direction\":" + direction +"} }";
	}
}


	
