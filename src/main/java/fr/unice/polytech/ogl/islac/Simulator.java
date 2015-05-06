package fr.unice.polytech.ogl.islac;

import fr.unice.polytech.ogl.islac.*;
import fr.unice.polytech.ogl.islac.action.Action;
import fr.unice.polytech.ogl.islac.action.Exploit;
import fr.unice.polytech.ogl.islac.action.Glimpse;
import fr.unice.polytech.ogl.islac.action.Land;
import fr.unice.polytech.ogl.islac.action.Move_to;
import fr.unice.polytech.ogl.islac.action.Scout;
import fr.unice.polytech.ogl.islac.action.Stop;
import fr.unice.polytech.ogl.islac.character.Character1;
import fr.unice.polytech.ogl.islac.data.Pos;
import fr.unice.polytech.ogl.islac.data.Tuils;

public class Simulator {

	public Action act;
	private int nbTurn;
	private boolean stop=false;
	private long paMax;

	
	/**
	 * Initialisation methode. 
	 * @param context
	 */
	public void init(String context)
	{
		
		act=new Action();
		
		// Créer notre caractère 
		act.setC(new Character1());
		// Initialiser leurs coordonnées à (0,0)
		act.getC().setCurrentTuil(new Tuils(0,0));  // à déplacer dans caractère
		
		nbTurn=0;
		// Sauvegarde de toutes les parametres des objectives
		act.read(context,act);
		act.getC().getObj().size();
		
		
		if(act.getC().getObj().size()>0)
		{
			act.getMap().setObj1(act.getC().getObj().get(0).getName());
		}
		
		if(act.getC().getObj().size()>1)
		{
			act.getMap().setObj1(act.getC().getObj().get(1).getName());
		}
		
		paMax=act.getC().getPa();
	

		
	}
	public String simul()
	{
		nbTurn++;
		
		if (stop)
		{
			return new Stop().act();
		}
		
		if (nbTurn==1)
		{
			act.getMap().update(act.getC());
			Land l=new Land();
			act.setLastAction(l);
			if(act.getC().getNbTotal()/4>0)
			{
				return l.act(act.getMap().getListCreek().get(0),act.getC().getNbTotal()/4);	
				
			}
			else return l.act(act.getMap().getListCreek().get(0),act.getC().getNbTotal()-1);
				
		}
	/*		if (act.getC().getNbTotal() == 2){
				return "1";
			}
			
			else return "2";
		} */
		
		if(act.getC().getPa()<paMax/5){
			Action stop=new Stop();
			act.setLastAction(stop);
			return stop.act();
			
		}
		
		if (act.getC().getCurrentTuil().getObj1()>0)
		{
			System.out.println("salut");
			//act.getC().getCurrentTuil().setObj1(0);
			//act.getC().getCurrentTuil().setObj1(false);
			Action a=new Exploit(act.getC().getObj().get(0).getName());
			act.setLastAction(a);
			return a.act();
		}
		
		if (act.getC().getCurrentTuil().getObj2()>0 )
		{
		//	act.getC().getCurrentTuil().setObj2(0);
			//act.getC().getCurrentTuil().setObj2(false);
	
			Action a=new Exploit(act.getC().getObj().get(1).getName());
			act.setLastAction(a);
			return a.act();
		}
		
		
		if (act.getC().getCurrentTuil().getObj3()>0 )
		{
		//	act.getC().getCurrentTuil().setObj2(0);
			//act.getC().getCurrentTuil().setObj2(false);
	
			Action a=new Exploit(act.getC().getObj().get(2).getName());
			act.setLastAction(a);
			return a.act();
		}
		
		String[] actionFinal= act.getMap().bestD(act.getC().getCurrentTuil());
		
		if (actionFinal[0].equals("Stop"))
		{
			Action stop=new Stop();
			act.setLastAction(stop);
			return stop.act();
		}
		
		if (actionFinal[0].equals("Scout"))
		{
			Action scout=new Scout();
			act.setLastAction(scout);
			act.setLastDirection(actionFinal[1]);
			return scout.act(actionFinal[1],act);
		}
		
		if (actionFinal[0].equals("Move_to"))
		{
			Action move=new Move_to();
			act.setLastAction(move);
			act.setLastDirection(actionFinal[1]);
			return move.act(actionFinal[1],act);
		}
		
		if(actionFinal[0].equals("Glimpse"))
		{
			Action glimpse = new Glimpse();
			act.setLastAction(glimpse);
			act.setLastDirection(actionFinal[1]);
			return glimpse.act(actionFinal[1],act);
		}
		
		Action stop=new Stop();
		act.setLastAction(stop);
		return stop.act(); 
		
		
	
	}
	
	public void simul2(String context){
		act.getLastAction().read(context,act);

	}
	
	
	
	

}
