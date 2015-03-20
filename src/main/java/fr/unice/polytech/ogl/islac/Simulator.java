package fr.unice.polytech.ogl.islac;

import fr.unice.polytech.ogl.islac.*;
import fr.unice.polytech.ogl.islac.action.Action;

public class Simulator {

	private Action act;
	private Action lastAct;
	private int nbTurn;
	private boolean stop;
	int k=1;
	
	
	public void init(String context)
	{
		act=new Action();
		nbTurn=0;
		act.read(context);
	}
	

	public String simul()
	{
		nbTurn++;
		return null;
		
	}
	
	public void simul2(String context){
		lastAct.read(context);
	}
	
	
	
	

}
