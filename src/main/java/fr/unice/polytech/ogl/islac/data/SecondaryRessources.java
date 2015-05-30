package fr.unice.polytech.ogl.islac.data;

import java.util.ArrayList;

public class SecondaryRessources extends Ressources {

	public SecondaryRessources(String name, long quantity) {
		super(name, quantity);
	}
	
	public ArrayList<Ressources> getResourceNeededToTransform(){
		ArrayList<Ressources> primaryResourceNeeded = new ArrayList<>();
		
		if(this.getName().equals("GLASS")){
			Ressources quartz = new Ressources("QUARTZ", 10*this.getQuantityNeeded());
			quartz.setForSecondary(true);
			Ressources wood = new Ressources("WOOD", 5*this.getQuantityNeeded());
			wood.setForSecondary(true);
			primaryResourceNeeded.add(wood);
			primaryResourceNeeded.add(quartz);
		}
		
		if(this.getName().equals("INGOT")){
			Ressources ore = new Ressources("ORE", 5*this.getQuantityNeeded());
			ore.setForSecondary(true);
			Ressources wood = new Ressources("WOOD", 5*this.getQuantityNeeded());
			wood.setForSecondary(true);
			primaryResourceNeeded.add(ore);
			primaryResourceNeeded.add(wood);
		}
		
		if(this.getName().equals("PLANK")){
			Ressources wood = new Ressources("WOOD", 1*(this.getQuantityNeeded()/3)+1);
			wood.setForSecondary(true);
			primaryResourceNeeded.add(wood);
		}
		
		if(this.getName().equals("LEATHER")){
			Ressources fur = new Ressources("FUR", 3*this.getQuantityNeeded());
			fur.setForSecondary(true);
			primaryResourceNeeded.add(fur);
		}
		
		if(this.getName().equals("RUM")){
			Ressources sugar_cane = new Ressources("SUGAR_CANE", 10*this.getQuantityNeeded());
			sugar_cane.setForSecondary(true);
			Ressources fruits = new Ressources("FRUITS", 1*this.getQuantityNeeded());
			fruits.setForSecondary(true);
			primaryResourceNeeded.add(sugar_cane);
			primaryResourceNeeded.add(fruits);
		}
		
		return primaryResourceNeeded;
	}

}
