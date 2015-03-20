package fr.unice.polytech.ogl.islac.data;

import java.util.*;

public class Map {
	
	private List<String> listCreek;
	private HashMap<int[],Tuils> map;
	
	public Map()
	{
		listCreek=new ArrayList<String>();
		map =new HashMap<int[], Tuils>();
		
		
	}
	
	
	public void addTuils(Tuils t)
	{
		map.put(t.getPos(),t);
	}

	public Tuils getD(Tuils t,String d)
	{
		int[] pos2=t.getPos();
		
		if(d=="N")
		{
			pos2[1]+=1;
		}
		if(d=="S")
		{
			pos2[1]+=-1;
		}
		if(d=="W")
		{
			pos2[0]+=-1;
		}
		if(d=="E")
		{
			pos2[0]+=1;
		}
		
		return map.get(pos2);
	}
	
	
	public List<String> getListCreek() {
		return listCreek;
	}

	public void setListCreek(List<String> listCreek) {
		this.listCreek = listCreek;
	}
	
	
	


	


	
	
	
}
