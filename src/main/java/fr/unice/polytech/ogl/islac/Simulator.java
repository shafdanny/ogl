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
		
		if (stop)
		{
			return act.getS().act();
		}
		
		if (nbTurn==1)
		{
			return act.getL().act(act.getMap().getListCreek().get(0));
		}
		
		if (nbTurn==2)
		{
			return act.getS().act("N");
		}
		
		if (nbTurn==3)
		{
			return act.getS().act("S");
		}
		
		if (nbTurn==4)
		{
			return act.getS().act("E");
		}
		
		if (nbTurn==5)
		{
			return act.getS().act("W");
		}
		
		if (nbTurn==6)
		{
			return act.getM().act("E");
		}
		
		if(nbTurn==7)
		{
			return act.getS1().act();
		}
		else {
			return act.getS1().act();
		}
	}
	
	public void simul2(String context){
		lastAct.read(context);
	}
	
	
	
	

}
