package fr.unice.polytech.ogl.islac.data;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Representation of the resources in the game.
 * Each resource is defined by its name, quantity needed, and quantity collected by the robot.
 * @author user
 *
 */
public class Ressources {
	

	private long amountCollected;
	private String name;
	private long quantityNeeded;
	
	
	public Ressources()
	{
		
	}
	
	public Ressources(String name, long quantity)
	{
		setQuantity(quantity);
		setName(name);
		setAmountCollected(0);
	}
	
	public Ressources (String name, long quantity, long amount)
	{
		setQuantity(quantity);
		setName(name);
		setAmountCollected(amount);
	}
	
	public void addAmountCollected(int n)
	{
		amountCollected += n;
	}
	
	public long getAmountCollected() {
		return amountCollected;
	}
	
	public void setAmountCollected(long amount) {
		this.amountCollected = amount;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public long getQuantityNeeded() {
		return quantityNeeded;
	}
	
	public void setQuantity(long quantity) {
		this.quantityNeeded = quantity;
	}
	
	public int estimCost()
	{
		int k=1;
		
		if(this.name.equals("WOOD"))
				k=2;
		
		if(this.name.equals("SUGAR_CANE"))
				k=5;
			
		if(this.name.equals("FUR"))
				k=10;
				
		if(this.name.equals("QUARTZ"))
				k=2;
					
		if(this.name.equals("FLOWER"))
				k=0;
						
		if(this.name.equals("FISH"))
				k=1;
		
		if(this.name.equals("FRUITS"))
				k=10;
		
		if(this.name.equals("ORE"))
				k=8;
		
		if(this.name.equals("GLASS"))
			k=150;
		
		if(this.name.equals("INGOT"))
			k=55;
		
		if(this.name.equals("PLANK"))
			k=2;
		
		if(this.name.equals("LEATHER"))
			k=3;
		
		if(this.name.equals("RUM"))
			k=110;
		
		return (int) (k*quantityNeeded+500);
	}
	
	public ArrayList<Ressources> resourceNeededToTransform(){
		ArrayList<Ressources> primaryResourceNeeded = new ArrayList<>();
		
		if(this.name.equals("GLASS")){
			primaryResourceNeeded.add(new Ressources("QUARTZ", 10));
			primaryResourceNeeded.add(new Ressources("WOOD", 5));
		}
		
		if(this.name.equals("INGOT")){
			primaryResourceNeeded.add(new Ressources("ORE", 5));
			primaryResourceNeeded.add(new Ressources("WOOD", 5));
		}
		
		if(this.name.equals("PLANK")){
			primaryResourceNeeded.add(new Ressources("WOOD", 1));
		}
		
		if(this.name.equals("LEATHER")){
			primaryResourceNeeded.add(new Ressources("FUR", 3));
		}
		
		if(this.name.equals("RUM")){
			primaryResourceNeeded.add(new Ressources("SUGAR_CANE", 10));
			primaryResourceNeeded.add(new Ressources("FRUITS", 1));
		}
		
		return primaryResourceNeeded;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj==null)
			return false;
		
		if(getClass() != obj.getClass())
			return false;
		
		Ressources res = (Ressources)obj;
		
		if(this.name.equals(res.getName()) && this.quantityNeeded == res.quantityNeeded)
			return true;
		else
			return false;
	}


}
