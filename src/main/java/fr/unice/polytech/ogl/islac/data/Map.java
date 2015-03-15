package fr.unice.polytech.ogl.islac.data;

import java.util.*;

public class Map {
	
	private List<String> listCreek;
	private Tuils[][] map;
	
	public Map()
	{
		listCreek=new ArrayList<String>();
		map =new Tuils[250][250];
		
		for (int k=0;k<250;k++)
		{
			for (int i=0;i<250;i++)
			{
				map[k][i]=new Tuils(k,i);
			}
		}
	}
	
	
	

	public List<String> getListCreek() {
		return listCreek;
	}

	

	public Tuils[][] getMap() {
		return map;
	}

	public void setMap(Tuils[][] map) {
		this.map = map;
	}

	
	
}
