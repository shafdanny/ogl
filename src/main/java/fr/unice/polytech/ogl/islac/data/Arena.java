package fr.unice.polytech.ogl.islac.data;

import java.util.*;

public class Arena{
	
	private List<String> listCreek;
	private HashMap<int[],Tuils> map;
	private String obj1;
	private String obj2;
	
	public Arena()
	{
		listCreek=new ArrayList<String>();
		map =new HashMap<int[], Tuils>();
		
		
	}
	
	
	public void addTuils(Tuils t)
	{
		map.put(t.getPos(),t);
	}

	public int[] getNewPos(Tuils t,String d)
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
				return pos2;
	}
	public Tuils getD(Tuils t,String d)
	{
		int[] pos2=getNewPos(t,d);
		
		return map.get(pos2);
	}
	public void scout(Tuils t,String d,ArrayList<String> ressources,long altitude)
	{
		System.out.println(1);
		int[] newPos=getNewPos(t,d);
		if(map.get(newPos)==null)
		{
			System.out.println(2);
			map.put(newPos,new Tuils(newPos));
			map.get(newPos).addAltitude((int) altitude,t);
			
		}
		
		if (ressources.contains(obj1))
		{
			map.get(newPos).setObj1(true);
			map.get(newPos).setObj1(1);
			
		}
		
		if (ressources.contains(obj2))
		{
			map.get(newPos).setObj2(true);
			map.get(newPos).setObj2(1);
		}
		
		if (ressources.contains("FLOWER"))
		{
			map.get(newPos).setFlower(true);
		}
		else{
			
			map.get(newPos).setFlower(false);
		}
		
		if (ressources.contains("WOOD"))
		{
			
			map.get(newPos).setWood(true);
		}
		else 
		{
			
			map.get(newPos).setWood(false);
		}
		if (ressources.contains("FUR"))
		{
			
			map.get(newPos).setFur(true);
		}
		else 
		{
			
			map.get(newPos).setFur(false);
		}
		
		if(ressources.contains("Fish"))
		{
			
			map.get(newPos).setFish(true);
		}
		if (!map.get(newPos).isFur() && !map.get(newPos).isFlower() && !map.get(newPos).isWood() && map.get(newPos).isFish() )  
		{
			
			map.get(newPos).setOnlyFish(true);
		}
		else
		{
			
			map.get(newPos).setOnlyFish(false);
		}
	}
	
	public List<String> getListCreek() {
		return listCreek;
	}

	public void setListCreek(List<String> listCreek) {
		this.listCreek = listCreek;
	}


	public String getObj1() {
		return obj1;
	}


	public void setObj1(String obj1) {
		this.obj1 = obj1;
	}


	public String getObj2() {
		return obj2;
	}


	public void setObj2(String obj2) {
		this.obj2 = obj2;
	}
	
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	
	public String[] bestD(Tuils t)
	{
		String[] actionFinal=new String[2];
		ArrayList<String> direction=new ArrayList<String>();
		direction.add("N");
		direction.add("S");
		direction.add("E");
		direction.add("W");
		//// obj1
		for (int i=0;i<direction.size();i++)
		{
			if(getD(t,direction.get(i)).isObj1())
			{
				actionFinal[1]=direction.get(i);
				actionFinal[0]="Move_to";
				return actionFinal;
			}
		}
		
	
		
		//// obj2
		for (int i=0;i<direction.size();i++)
		{
			if(getD(t,direction.get(i)).isObj2())
			{
				actionFinal[1]=direction.get(i);
				actionFinal[0]="Move_to";
				return actionFinal;
				
			}
		}
	
		//// isScouted
		ArrayList<String> newDir=new ArrayList<String>();
		for (int i=0;i<direction.size();i++)
		{
			if(! getD(t,direction.get(i)).isScouted())
			{
				newDir.add(direction.get(i));
			}
			
			if(newDir.size()>0)
			{
				actionFinal[0]="Scout";
				actionFinal[1]=newDir.get(0);
				return actionFinal;
			}
				
		}
		
		/// isOnlyFish
		
		for (int i=0;i<direction.size();i++)
		{
			if(! getD(t,direction.get(i)).isOnlyFish())
			{
				actionFinal[0]="Move_to";
				actionFinal[1]=direction.get(i);
				return actionFinal;
			}
		}
		
		actionFinal[0]="Stop";
		actionFinal[1]="Stop";
		return actionFinal;
	}
	
	                                                                                
}
