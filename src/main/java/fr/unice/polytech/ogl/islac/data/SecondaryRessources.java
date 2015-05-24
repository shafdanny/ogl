package fr.unice.polytech.ogl.islac.data;

import java.util.ArrayList;

public class SecondaryRessources extends Ressources {

	public SecondaryRessources(String name, long quantity) {
		super(name, quantity);
	}
	
	public ArrayList<Ressources> getResourceNeededToTransform(){
		ArrayList<Ressources> primaryResourceNeeded = new ArrayList<>();
		
		if(this.getName().equals("GLASS")){
			primaryResourceNeeded.add(new Ressources("QUARTZ", 10));
			primaryResourceNeeded.add(new Ressources("WOOD", 5));
		}
		
		if(this.getName().equals("INGOT")){
			primaryResourceNeeded.add(new Ressources("ORE", 5));
			primaryResourceNeeded.add(new Ressources("WOOD", 5));
		}
		
		if(this.getName().equals("PLANK")){
			primaryResourceNeeded.add(new Ressources("WOOD", 1));
		}
		
		if(this.getName().equals("LEATHER")){
			primaryResourceNeeded.add(new Ressources("FUR", 3));
		}
		
		if(this.getName().equals("RUM")){
			primaryResourceNeeded.add(new Ressources("SUGAR_CANE", 10));
			primaryResourceNeeded.add(new Ressources("FRUITS", 1));
		}
		
		return primaryResourceNeeded;
	}

}
