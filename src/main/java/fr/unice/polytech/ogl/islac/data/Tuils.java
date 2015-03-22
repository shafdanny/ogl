package fr.unice.polytech.ogl.islac.data;
import java.util.*;

public class Tuils {
	
	
private boolean isWood;
private boolean isFish;
private boolean isFur;
private boolean isFlower;
private boolean isObj1;
private boolean isObj2;
private boolean isScouted;
private int Obj1;
private int Obj2;

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
	if(this==null) return false;
	return isScooted;
}

public void setScooted(boolean isScooted) {
	this.isScooted = isScooted;
}

public boolean isExplored() {
	if(this==null) return false;
	return isExplored;
}

public void setExplored(boolean isExplored) {
	this.isExplored = isExplored;
}


public void setPos(int[] pos) {
	this.pos = pos;
}


public boolean isFur() {
	if(this==null) return false;
	return isFur;
}

public void setFur(boolean isFur) {
	
	this.isFur = isFur;
}

public boolean isFlower() {
	if(this==null) return false;
	return isFlower;
}

public void setFlower(boolean isFlower) {
	
	this.isFlower = isFlower;
}

public boolean isFish() {
	if(this==null) return false;
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
	if(this==null) return false;
	return isWood;
}

public void setWood(boolean isWood) {
	this.isWood = isWood;
}

public boolean isOnlyFish() {
	if(this==null) return false;
	return isOnlyFish;
}

public void setFish(boolean isOnlyFish) {
	this.isOnlyFish = isOnlyFish;
}

public int getAttiltude() {
	if(this==null) return 0;
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
	if(this==null) return null;
	return pos;
}

public boolean isObj1() {
	if(this==null) return false;
	return isObj1;
}

public void setObj1(boolean isObj1) {
	
	this.isObj1 = isObj1;
}

public boolean isObj2() {
	if(this==null) return false;
	return isObj2;
}

public void setObj2(boolean isObj2) {
	this.isObj2 = isObj2;
}

public boolean isScouted() {
	if(this==null) return false;
	return isScouted;
}

public void setScouted(boolean isScouted) {
	this.isScouted = isScouted;
}

public int getObj1() {
	if(this==null) return 0;
	return Obj1;
}

public void setObj1(int obj1) {
	
	Obj1 = obj1;
}

public int getObj2() {
	if(this==null) return 0;
	return Obj2;
}

public void setObj2(int obj2) {
	Obj2 = obj2;
}




}
