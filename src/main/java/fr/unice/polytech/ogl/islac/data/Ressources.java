package fr.unice.polytech.ogl.islac.data;

public class Ressources {
	

private long amount;
private String name;
private long quantity;


public Ressources()
{
	
}




public Ressources(String name, long quantity)
{
	setQuantity(quantity);
	setName(name);
}

public Ressources (String name, long quantity, long amount)
{
	setQuantity(quantity);
	setName(name);
	setAmount(amount);
}

public void addQuantity(int n)
{
	quantity -= n;
}

public long getAmount() {
	return amount;
}

public void setAmount(long amount) {
	this.amount = amount;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public long getQuantity() {
	return quantity;
}

public void setQuantity(long quantity) {
	this.quantity = quantity;
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
	
	return (int) (k*quantity+500);
}


}
