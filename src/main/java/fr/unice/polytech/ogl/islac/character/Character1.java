package fr.unice.polytech.ogl.islac.character;

import fr.unice.polytech.ogl.islac.data.*;
import java.util.*;

public class Character1 {
	
	private long pa;	
	private long nbTotal; 
	private long nbLand;
	private Pos pos;
	private Tuils CurrentTuil;
	
	// Two distinct type of objectives. Secondary objectives can only be obtained by transforming the primary resources
	private ArrayList<Ressources> listPrimaryObjectives = new ArrayList<>();
	private ArrayList<SecondaryRessources> listSecondaryObjectives = new ArrayList<>();
	
	
	public Character1()
	{
		pos = new Pos(0,0);
		CurrentTuil = new Tuils();
	}

	public void setPa(long pa) {
		this.pa=pa;
	}
	
	public Pos getPos() {
		return pos;
	}

	public void setPos(Pos pos) {
		this.pos = pos;
	}

	public Tuils getCurrentTuil() {
		return CurrentTuil;
	}

	public void setCurrentTuil(Tuils currentTuil) {
		this.CurrentTuil = currentTuil;
	}

	public void addPa(long pa){
		this.pa=getPa()-pa;
	}
	
	public void setNbLand(int nb){
		this.nbLand=nb;
	}
	
	public void setNbTotal(long men){
		this.nbTotal=men;
	}
	
	public long getPa(){
		return pa;
	}
	
	public long getNbLand(){
		return nbLand;
	}
	
	public long getNbTotal(){
		return nbTotal;
	}
	
	public long getNbBoat(){
		return getNbTotal()-getNbLand();
	}

	/**
	 * Get the ArrayList of Ressources that corresponds to the objectives
	 * @return
	 */
	public ArrayList<Ressources> getPrimaryObjectives() {
		return listPrimaryObjectives;
	}

	public void setObj(ArrayList<Ressources> obj) {
		this.listPrimaryObjectives = obj;
	}
	
	public Ressources getRessource(String ressourceName) {
		for(int i=0; i<listPrimaryObjectives.size(); i++) {
			if(listPrimaryObjectives.get(i).getName().equals(ressourceName)) {
				return listPrimaryObjectives.get(i);
			}
		}
		
		for(int i=0; i<listSecondaryObjectives.size(); i++) {
			if(listSecondaryObjectives.get(i).getName().equals(ressourceName)) {
				return listSecondaryObjectives.get(i);
			}
		}
		
		return null;	
	}
	
	public ArrayList<SecondaryRessources> getSecondaryObjectives() {
		return listSecondaryObjectives;
	}

	public String getObjectivesAsString() {
		String objectives = "";
		
		objectives += "PRIMARY OBJECTIVES : \n";
		for(Ressources res:listPrimaryObjectives){			
			objectives += "\t" + res.getName() + " : " + "NEEDED-" + res.getQuantityNeeded() + " " +"COLLECTED-" + res.getAmountCollected() + "\n";
		} 
		
		objectives += "\nSECONDARY OBJECTIVES : \n";
		for(Ressources res:listSecondaryObjectives){
			objectives += "\t" + res.getName() + " : " + "NEEDED-" + res.getQuantityNeeded() + " " +"COLLECTED-" + res.getAmountCollected() + "\n";
		} 
		
		return objectives;
	}
	
	
	
}
	