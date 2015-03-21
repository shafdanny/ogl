package fr.unice.polytech.ogl.islac.character;

import fr.unice.polytech.ogl.islac.data.*;

public class Character1 {
	
	private long pa;
	private int nbTotal;
	private int nbLand;
	private int[] pos;
	private Tuils CurrentTuil;
	
	
	//public Character
	
	

	public void setPa(long pa) {
		this.pa=pa;
	}
	
	public int[] getPos() {
		return pos;
	}

	public void setPos(int[] pos) {
		this.pos = pos;
	}

	public Tuils getCurrentTuil() {
		return CurrentTuil;
	}

	public void setCurrentTuil(Tuils currentTuil) {
		CurrentTuil = currentTuil;
	}

	public void addPa(long pa){
		this.pa=getPa()-pa;
	}
	
	public void setNbLand(int nb){
		this.nbLand=nb;
	}
	
	public void setNbTotal(int nb){
		this.nbTotal=nb;
	}
	
	public long getPa(){
		return pa;
	}
	
	public int getNbLand(){
		return nbLand;
	}
	
	public int getNbTotal(){
		return nbTotal;
	}
	
	public int getNbBoat(){
		return getNbLand()-getNbTotal();
	}
}
	