package fr.unice.polytech.ogl.islac.character;

public class Character1 {
	
	private int pa;
	private int nbTotal;
	private int nbLand;
	private int[] pos;
	
	

	public void setPa(int pa) {
		this.pa=pa;
	}
	
	public void setNbLand(int nb){
		this.nbLand=nb;
	}
	
	public void setNbTotal(int nb){
		this.nbTotal=nb;
	}
	
	public int getPa(){
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
	