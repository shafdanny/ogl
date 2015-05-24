package fr.unice.polytech.ogl.islac;

import java.util.ArrayList;
import java.util.HashMap;

import fr.unice.polytech.ogl.islac.*;
import fr.unice.polytech.ogl.islac.action.Action;
import fr.unice.polytech.ogl.islac.action.Exploit;
import fr.unice.polytech.ogl.islac.action.Glimpse;
import fr.unice.polytech.ogl.islac.action.Land;
import fr.unice.polytech.ogl.islac.action.Move_to;
import fr.unice.polytech.ogl.islac.action.Scout;
import fr.unice.polytech.ogl.islac.action.Stop;
import fr.unice.polytech.ogl.islac.action.Transform;
import fr.unice.polytech.ogl.islac.character.Character1;
import fr.unice.polytech.ogl.islac.data.Pos;
import fr.unice.polytech.ogl.islac.data.Ressources;
import fr.unice.polytech.ogl.islac.data.SecondaryRessources;
import fr.unice.polytech.ogl.islac.data.Tuils;

public class Simulator {

	public Action act;
	private int nbTurn;
	private boolean stop=false;
	private long paMax;

	
	/**
	 * Initialization method.
	 * This method is only called one time during the Explorer initialization.
	 * The game engine will give the context of the game, and it is saved by the robot. 
	 *  
	 * @param context	The context given by the game engine
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
				
		paMax=act.getC().getPa();		
	}
	
	
	public String getNextDecision()
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
			if(act.getC().getNbTotal()>2)
			{
				//return l.act(act.getMap().getListCreek().get(0),act.getC().getNbTotal()/4);	
				return l.act(act.getMap().getListCreek().get(0),(long) 2);
				
			}
			else return l.act(act.getMap().getListCreek().get(0),(long) 1);
				
		}
	/*		if (act.getC().getNbTotal() == 2){
				return "1";
			}
			
			else return "2";
		} */
		
		if(act.getC().getPa()<paMax/20 || act.getC().getPa()<250){
			Action stop=new Stop();
			act.setLastAction(stop);
			return stop.act();
			
		}
	
		/**
		 * If we have secondary objectives...
		 */
		if(act.getC().getSecondaryObjectives() != null && act.getC().getSecondaryObjectives().size() > 0){
			SecondaryRessources secondaryObjective = act.getC().getSecondaryObjectives().get(0);			
			
			ArrayList<Ressources> resourceNeededToTransform = secondaryObjective.getResourceNeededToTransform();
			
			boolean sufficientResourceNeeded = true;
			
			/**
			 * Check if we have sufficient primary resource to transform into the secondary objectives
			 */
			for(Ressources res:resourceNeededToTransform){
				Ressources collectedResource = act.getC().getRessource(res.getName());
				
				if(collectedResource!=null && collectedResource.getQuantityNeeded()>collectedResource.getAmountCollected())
					sufficientResourceNeeded = false;
			}			
			
			/**
			 * If it is not enough, check if current tile have the primary resource needed
			 */
			if(!sufficientResourceNeeded){
				for(Ressources res:resourceNeededToTransform){
					Tuils currentTile = act.getC().getCurrentTuil();
					
					Ressources ressourceNeeded = act.getC().getRessource(res.getName());
					
					if(currentTile.getObjectivesInTile()!=null && ressourceNeeded != null && currentTile.getObjectivesInTile().contains(ressourceNeeded.getName()) &&  ressourceNeeded.getQuantityNeeded()>ressourceNeeded.getAmountCollected()){
						Action a=new Exploit(res.getName());
						act.setLastAction(a);
						return a.act();
					}
					
				}	
			}
			
			if(sufficientResourceNeeded && (secondaryObjective.getAmountCollected() < act.getC().getRessource(secondaryObjective.getName()).getQuantityNeeded())){
				Transform transform=new Transform();
				act.setLastAction(transform);
				
				HashMap<String, Integer> resource = new HashMap<>();
				
				for(Ressources res:resourceNeededToTransform){
					resource.put(res.getName(), (int) res.getQuantityNeeded());
					act.getC().getRessource(res.getName()).addAmountCollected(-(int) res.getQuantityNeeded());
				}			
				
				return transform.act(resource);
			}
			
			if(secondaryObjective.getAmountCollected() >= act.getC().getRessource(secondaryObjective.getName()).getQuantityNeeded()){
				ArrayList<Ressources> listResource = secondaryObjective.getResourceNeededToTransform();
				
				for(Ressources res:listResource){
					if(act.getC().getPrimaryObjectives().contains(res))
						act.getC().getPrimaryObjectives().remove(res);
				}
				
				act.getC().getSecondaryObjectives().remove(0);
				
			}
		}
		
		if (act.getC().getCurrentTuil().getObjectivesInTile()!=null && act.getC().getCurrentTuil().getObjectivesInTile().size()>0)
		{
			String objectives = act.getC().getCurrentTuil().getObjectivesInTile().get(0);
			//System.out.println("salut");
			//act.getC().getCurrentTuil().setObj1(0);
			//act.getC().getCurrentTuil().setObj1(false);
			if(act.getC().getPrimaryObjectives().contains(act.getC().getRessource(objectives)))
			{
				if(act.getC().getRessource(objectives).getAmountCollected() < act.getC().getRessource(objectives).getQuantityNeeded()){
					Action a=new Exploit(act.getC().getCurrentTuil().getObjectivesInTile().get(0));
					act.setLastAction(a);
					return a.act();
				}
			}
		}
		
		if (act.getC().getCurrentTuil().getObj2()>0 )
		{
		//	act.getC().getCurrentTuil().setObj2(0);
			//act.getC().getCurrentTuil().setObj2(false);
	
			Action a=new Exploit(act.getC().getPrimaryObjectives().get(1).getName());
			act.setLastAction(a);
			return a.act();
		}
		
		
		if (act.getC().getCurrentTuil().getObj3()>0 )
		{
		//	act.getC().getCurrentTuil().setObj2(0);
			//act.getC().getCurrentTuil().setObj2(false);
	
			Action a=new Exploit(act.getC().getPrimaryObjectives().get(2).getName());
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


	public void analyzeResponse(String context){
		act.getLastAction().read(context,act);

	}
	
	
	
	

}
