package fr.unice.polytech.ogl.islac.data;

public class Tuils {
	
private boolean isWood;
private boolean isFish;
private int attiltude;
private int cost;
private int [] pos;
private boolean isScooted;
private boolean isExplored;

public boolean isScooted() {
	return isScooted;
}

public void setScooted(boolean isScooted) {
	this.isScooted = isScooted;
}

public boolean isExplored() {
	return isExplored;
}

public void setExplored(boolean isExplored) {
	this.isExplored = isExplored;
}

public void setPos(int[] pos) {
	this.pos = pos;
}

public Tuils(int x,int y)
{
	pos=new int [2];
	pos[0]=x;
	pos[1]=y;
	isWood=false;
	isFish=true;
	
}



public void setX(int x)
{
	pos[0]=x;
}

public void setY(int y)
{
	pos[1]=y;
}
public boolean isWood() {
	return isWood;
}

public void setWood(boolean isWood) {
	this.isWood = isWood;
}

public boolean isFish() {
	return isFish;
}

public void setFish(boolean isFish) {
	this.isFish = isFish;
}

public int getAttiltude() {
	return attiltude;
}

public void setAttiltude(int attiltude) {
	this.attiltude = attiltude;
}

public int getCost() {
	return cost;
}

public void setCost(int cost) {
	this.cost = cost;
}

public int[] getPos() {
	return pos;
}



}
