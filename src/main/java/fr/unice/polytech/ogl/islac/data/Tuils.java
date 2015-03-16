package fr.unice.polytech.ogl.islac.data;

public class Tuils {
	
private boolean isWood;
private boolean isFish;
private int attiltude;

private int [] pos;

// 0 : N , 1 : E , 2: S, 3: O
private Tuils[] adjacent;

private boolean isScooted;
private boolean isExplored;


public Tuils()
{
	isWood=false;
	isFish=false;
	attiltude=0;
	pos=new int[2];
	
		
}

public Tuils(String d)
{
	
}


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



public int[] getPos() {
	return pos;
}



}
