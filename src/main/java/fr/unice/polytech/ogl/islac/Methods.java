package fr.unice.polytech.ogl.islac;

public class Methods {
	
	
	public String stop(){
		return "{ \"action\": \"stop\" }";
	}
	
	public String land(String creek_id, int number){
		return "{ \"action\": \"land\", \"parameters\": {\"creek\":" + creek_id + ", \"people\":" +	number + "}}";
	}
}

	
