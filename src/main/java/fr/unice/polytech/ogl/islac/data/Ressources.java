package fr.unice.polytech.ogl.islac.data;

public abstract class Ressources {
	

private int amount;
private String name;
private int quantity;


public Ressources()
{
	
}

public Ressources(String name, int quantity)
{
	setQuantity(quantity);
	setName(name);
}

public Ressources (String name, int quantity, int amount)
{
	setQuantity(quantity);
	setName(name);
	setAmount(amount);
}

public void addQuantity(int n)
{
	quantity += n;
}

public int getAmount() {
	return amount;
}

public void setAmount(int amount) {
	this.amount = amount;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}


}
