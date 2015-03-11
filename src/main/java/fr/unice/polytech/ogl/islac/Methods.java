package fr.unice.polytech.ogl.islac;

import java.util.*;

public class Methods {
	private List<String> positionCreek;
	private int turn;
	
	
	public Methods()
	{
		positionCreek=new <String>ArrayList();
		turn =0;
	}
	
	public int getTurn()
	{
		return turn;
	}
	
	public void updateTurn()
	{
		turn++;
	}
	
	public String stop(){
		return "{ \"action\": \"stop\" }";
	}
	

	// Méthodes pour les creek
	

	public void extraireInfo(String context)
	{
		String g1="\"";
		char g2=g1.charAt(0);
		int i1=context.indexOf(g2,context.indexOf(g2,context.indexOf(g2,context.indexOf(g2,0))))+1;
		int i2=context.indexOf(g2,i1+1);
		String creek=context.substring(i1,i2);
	
		positionCreek.add(creek);
	}

	
	public String land(String creek_id, int number){
		return "{ \"action\": \"land\", \"parameters\": {\"creek\":" + creek_id + ", \"people\":" +	number + "}}";
	}
	
	public List getPositionCreek(){
		return positionCreek;
	}
	
	public void addPositionCreek(String creek_id){
		positionCreek.add(creek_id);
	}
	
	
	// Méthodes scout
	
	public String scout(String direction){
		return "{ \"action\": \"scout\", \"parameters\": {\"direction\": " +"\""+ direction+"\" " +"} }";
	}
	
	// Méthodes explore
	
	
	public String explore(){
		return "{ \"action\": \"explore\" }";
	}
	
	// Méthodes exploit
	// Attention: ressource en majuscule: WOOD
	
	public String exploit(String ressource){
		return "{ \"action\": \"exploit\", \"parameters\": {\"ressource\": " +"\""+ ressource+"\" " +"} }";
	}
	
	/**
	 * Choisir quel action à faire selon une certaine parametres / calcul.
	 * Pour l'instant, just faire stop
	 * 
	 * @return 
	 */
	public String chooseDecision(){
		
		if (turn-1 ==1)
		{
			land(positionCreek.get(0),1);
		}
		
		if(turn-1==2)
		{
			scout("N");
		}
		if(turn-1==3)
		{
			stop();
		}
	/*	int decision = 1;
		
		//switch
		
		switch (decision) {
			case 1:
				return stop();
				break;
			case 2:
				return null;
				break;
				
			default:
				return stop()
		} */
		return stop();
	}

	// Méthodes move_to
	
	public String move_to(String direction){
		return "{ \"action\": \"move_to\", \"parameters\": {\"direction\": " +"\""+ direction+"\" " +"} }";
	}
	
	// Test
	
	public static void main(String[] args){
		Methods m1 = new Methods();
		System.out.println(m1.scout("N"));
		String test= "{\"creek\":\"creek_id\",\"budget\": 600,\"men\": 50,\"objective\": [ { \"resource\": \"WOOD\", \"amount\": 600 }]}";
		m1.extraireInfo(test);
		System.out.println(m1.getPositionCreek().get(0));
		
	}
}


	
