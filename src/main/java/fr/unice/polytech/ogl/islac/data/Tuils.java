package fr.unice.polytech.ogl.islac.data;
import java.util.*;

public class Tuils {
	
	
private boolean isWood;
private boolean isFish;
private boolean isFur;
private boolean isFlower;



private boolean isOnlyFish;
private int attiltude;

private int [] pos;



private boolean isScooted;
private boolean isExplored;

public void addAltitude(int a,Tuils t)
{
	this.setAttiltude(a+t.getAttiltude());
}

public Tuils()
{
	isWood=false;
	isOnlyFish=false;
	attiltude=0;
	pos=new int[2];
	
		
}

public Tuils(int[] pos)
{
	isWood=false;
	isOnlyFish=false;
	attiltude=0;
	this.pos=pos;
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


public boolean isFur() {
	return isFur;
}

public void setFur(boolean isFur) {
	this.isFur = isFur;
}

public boolean isFlower() {
	return isFlower;
}

public void setFlower(boolean isFlower) {
	this.isFlower = isFlower;
}

public boolean isFish() {
	return isFish;
}

public void setOnlyFish(boolean isOnlyFish) {
	this.isOnlyFish = isOnlyFish;
}

public Tuils(int x,int y)
{
	pos=new int [2];
	pos[0]=x;
	pos[1]=y;
	isWood=false;
	isOnlyFish=true;
	
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

public boolean isOnlyFish() {
	return isOnlyFish;
}

public void setFish(boolean isOnlyFish) {
	this.isOnlyFish = isOnlyFish;
}

public int getAttiltude() {
	return attiltude;
}

public void setAttiltude(int attiltude) {
	this.attiltude = attiltude;
}

public static String oppose(String d)
{
	if (d=="N")
	{
		return "S";
	}
	
	if (d=="S")
	{
		return "N";
	}
	if (d=="W")
	{
		return "W";
	}
	if (d=="E")
	{
		return "W";
	}
	
	return null;
}


public int[] getPos() {
	return pos;
}



}



























































































































































































































































































































































































































































































































































































































































































































































































































