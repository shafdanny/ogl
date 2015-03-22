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
	quantity += n;
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


}
