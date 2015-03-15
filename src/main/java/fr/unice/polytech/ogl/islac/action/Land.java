package fr.unice.polytech.ogl.islac.action;

public class Land extends Action {
	
	@Override
	public String act(String creek_id, int number){
		return "{ \"action\": \"land\", \"parameters\": {\"creek\":" + creek_id + ", \"people\":" +	number + "}}";
	}

	@Override
	public String act() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String act(String info) {
		// TODO Auto-generated method stub
		return null;
	}
}
