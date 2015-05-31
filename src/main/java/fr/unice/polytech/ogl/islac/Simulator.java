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
		
		/**
		 * First move by the robot, always LAND
		 */
		if (nbTurn==1)
		{
			act.getMap().update(act.getC());
			Land l=new Land();
			act.setLastAction(l);
			
			return l.act(act.getMap().getListCreek().get(0),(long) 1);
				
		}
		
		//System.out.println(act.getLastAction().toString());
		
		/**
		 * Update the status of secondary objectives.
		 */
		if(act.getC().getSecondaryObjectives()!=null){
			ArrayList<SecondaryRessources> secondaryObjectives = act.getC().getSecondaryObjectives();
			ArrayList<Ressources> primaryObjectives = act.getC().getPrimaryObjectives();
			
			/**
			 * Iterate through all the secondary objectives
			 */
			for(int i=0;i<secondaryObjectives.size();i++){
				
				ArrayList<Ressources> getPrim = secondaryObjectives.get(i).getResourceNeededToTransform();
				ArrayList<Ressources> resourceAssociated = new ArrayList<>();
				
				/**
				 * Store the primary resources that exist in the objective and associated
				 * with a secondary resources in a new ArrayList
				 */
				for(Ressources prim:getPrim){
					for(Ressources obj:primaryObjectives){
						if(prim.equals(obj))
							resourceAssociated.add(obj);
							//System.out.println(obj);
					}
				}
				
				/**
				 * If a secondary objective is completed (amount collected >= quantity needed)
				 * then delete it from our secondary objective list.
				 * Also, delete the primary resource objective associated with it.
				 */
				if(secondaryObjectives.get(i).getAmountCollected()>=secondaryObjectives.get(i).getQuantityNeeded()){
						act.getC().getSecondaryObjectives().remove(secondaryObjectives.get(i));
						for(Ressources primObj:resourceAssociated){
							primaryObjectives.remove(primObj);
						}
				}
			}
			
			act.getMap().update(act.getC());
		}
		
		
		/**
		 * Update the status of primary objectives.
		 */
		if(act.getC().getPrimaryObjectives()!=null){
			ArrayList<Ressources> primaryObjectives = act.getC().getPrimaryObjectives();
			
			for(int i=0;i<primaryObjectives.size();i++){
				if(!primaryObjectives.get(i).isForSecondary()){
					if(primaryObjectives.get(i).getAmountCollected()>=primaryObjectives.get(i).getQuantityNeeded())
						act.getC().getPrimaryObjectives().remove(primaryObjectives.get(i));
				}
			}
			act.getMap().update(act.getC());
		}
				
		/**
		 * If there is no more objective, stop
		 */
		if(act.getC().getPrimaryObjectives().size()==0 && act.getC().getSecondaryObjectives().size()==0){
			Stop stop=new Stop();
			act.setLastAction(stop);
			return new Stop().act();
		}
		
		/**
		 * Highest priority : is the energy sufficient for more exploration
		 * Set a minimum energy level so that if the energy falls below it, stop immediately		
		 */
		if(act.getC().getPa() < 50){
			Stop stop=new Stop();
			act.setLastAction(stop);
			return stop.act();
			
		}
		//System.out.println(act.getC().getObjectivesAsString());
		/**
		 * If we have secondary objectives...
		 */
		if(act.getC().getSecondaryObjectives() != null && act.getC().getSecondaryObjectives().size() > 0){
			ArrayList<SecondaryRessources> secondaryObjectives = act.getC().getSecondaryObjectives();
			ArrayList<Ressources> primaryObjectives = act.getC().getPrimaryObjectives();
			

			// Check the primary objectives that is used for secondary
			for(Ressources primObj : primaryObjectives){
				//System.out.println(primObj);
				if(primObj.isForSecondary() && (primObj.getAmountCollected()>=primObj.getQuantityNeeded()))
					primObj.setTransformable(true);
				else
					primObj.setTransformable(false);
			}
			
			// Check for each secondary objectives...
			for(SecondaryRessources secRes:secondaryObjectives){
				// Get the resources needed to transform
				ArrayList<Ressources> resourceNeededToTransform = secRes.getResourceNeededToTransform();
				ArrayList<Ressources> resPrimInObjAndNeeded = new ArrayList<>();
				
				boolean transformable = true;
				
				/**
				 * for each of the primary resource associated to a secondary
				 * search for the resource in primary objective.
				 * If we have the minimum for all the primary resource needed,
				 * we can proceed to transform
				 */				
				for(Ressources primRes : resourceNeededToTransform){				
					for(Ressources primObj:primaryObjectives){
						if(primRes.equals(primObj)){
							//System.out.println(primObj);
							resPrimInObjAndNeeded.add(primObj);
							if(!primObj.isTransformable())
								transformable = false;
						}
					}
				}
				
				/**
				 * After exhaustive checking, we are sure that we can transform the primary resources
				 */
				if(transformable){
					HashMap<String, Integer> ressourceNeeded = new HashMap<>();
					
					for(Ressources res:resPrimInObjAndNeeded){
						System.out.println(res);
						ressourceNeeded.put(res.getName(), (int) res.getQuantityNeeded());
						res.addAmountCollected(-(int)res.getQuantityNeeded());
						
					}
					
					Transform transform = new Transform();
					act.setLastAction(transform);
					return transform.act(ressourceNeeded);
				}

			}
			
			// Get a secondary objective
			//SecondaryRessources secondaryObjective = act.getC().getSecondaryObjectives().get(0);			
			// Get the primary resources needed for this secondary objective
			//ArrayList<Ressources> resourceNeededToTransform = secondaryObjective.getResourceNeededToTransform();
			// Get all the primary objectives
			
			
						
			//System.out.println(transformable);
			
						
		}
		
		// check for primary objectives in current tile
		if (act.getC().getCurrentTuil().getObjectivesInTile()!=null && act.getC().getCurrentTuil().getObjectivesInTile().size()>0)
		{
			for(String objective : act.getC().getCurrentTuil().getObjectivesInTile()){
				System.out.println("objectiveInTIle: " + objective);
				
				ArrayList<Ressources> primaryObjectives = act.getC().getPrimaryObjectives();
				
				for(Ressources res:primaryObjectives){
					if(res.getName().equals(objective) && res.getAmountCollected()<res.getQuantityNeeded())
					{
						System.out.println(res);
						Exploit exploit=new Exploit(act.getC().getCurrentTuil().getObjectivesInTile().get(0));
						act.setLastAction(exploit);
						return exploit.act();
					}
				}
			}
					
		}
		
		/*
		if(act.getLastAction().toString()!=null && act.getLastAction().toString().equals("Move_to")){
			ArrayList<String> dir = new ArrayList<>();
			dir.add("N");
			dir.add("E");
			dir.add("S");
			dir.add("W");
			
		
			//Check surrounding for unscouted tiles
			for(String direction:dir){
				if(act.getMap().getD(act.getC().getCurrentTuil(), direction)==null){
					Scout scout=new Scout();
					act.setLastAction(scout);
					act.setLastDirection(direction);
					return scout.act(direction,act);
				}					
			}		
			
			
			//  Check surrounding for unexplored tiles
			 
			for(String direction:dir){
				if(!act.getMap().getD(act.getC().getCurrentTuil(), direction).isExplored()){
					Move_to move_to=new Move_to();
					act.setLastAction(move_to);
					act.setLastDirection(direction);
					return move_to.act(direction,act);
				}					
			}	
			
		}*/
		
		
		String[] actionFinal= act.getMap().bestD(act.getC().getCurrentTuil());
		
		if (actionFinal[0].equals("Stop"))
		{
			Stop stop=new Stop();
			act.setLastAction(stop);
			return stop.act();
		}
				
		if (actionFinal[0].equals("Scout"))
		{
			Scout scout=new Scout();
			act.setLastAction(scout);
			act.setLastDirection(actionFinal[1]);
			return scout.act(actionFinal[1],act);
		}
		
		if (actionFinal[0].equals("Move_to"))
		{
			Move_to move=new Move_to();
			act.setLastAction(move);
			act.setLastDirection(actionFinal[1]);
			return move.act(actionFinal[1],act);
		}
		
		if(actionFinal[0].equals("Glimpse"))
		{
			Glimpse glimpse = new Glimpse();
			act.setLastAction(glimpse);
			act.setLastDirection(actionFinal[1]);
			return glimpse.act(actionFinal[1],act);
		}
		
		Stop stop=new Stop();
		act.setLastAction(stop);
		return stop.act(); 
		
		
	
	}


	public void analyzeResponse(String context){
		act.getLastAction().read(context,act);

	}
	
	
	
	

}
