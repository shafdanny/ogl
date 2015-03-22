package fr.unice.polytech.ogl.islac.character;

import fr.unice.polytech.ogl.islac.data.*;
import java.util.*;

public class Character1 {
	
	private long pa;
	private long nbTotal;
	private long nbLand;
	private int[] pos;
	private Tuils CurrentTuil;
	private ArrayList<Ressources> obj=new ArrayList<Ressources>();
	
	
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
		return getNbLand()-getNbTotal();
	}

	public ArrayList<Ressources> getObj() {
		return obj;
	}

	public void setObj(ArrayList<Ressources> obj) {
		this.obj = obj;
	}
}
	