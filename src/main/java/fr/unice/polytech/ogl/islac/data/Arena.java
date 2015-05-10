package fr.unice.polytech.ogl.islac.data;

import java.util.*;

import fr.unice.polytech.ogl.islac.character.Character1;

public class Arena{
	
	private List<String> listCreek;
	private HashMap<Pos,Tuils> map;
	private String obj1;
	private String obj2;
	private String obj3;
	
	public Arena()
	
	{
		listCreek=new ArrayList<String>();
		map =new HashMap<Pos, Tuils>();
		
		
		
	}
	public Arena(Character1 c)
	
	{
		listCreek=new ArrayList<String>();
		map =new HashMap<Pos, Tuils>();
			
	}
	
	public void update(Character1 c)
	{
		if(c.getObj().size()>0)
		{
			this.obj1=c.getObj().get(0).getName();
		}
		if(c.getObj().size()>1)
		{
			this.obj2=c.getObj().get(1).getName();
		}
		if(c.getObj().size()>2)
		{
			this.obj3=c.getObj().get(2).getName();
		}
	}
	
	
	public void addTuils(Tuils t)
	{
		map.put(t.getPos(),t);
	}

	public Pos getNewPos(Tuils t,String d)
	{
		//int[] pos2=new int[2];
		//pos2[0]=t.getPos2()[0];
		//pos2[1]=t.getPos2()[0];
	
				Pos pos2=new Pos(t.getPos());
						
				
				if(d=="N")
				{
					pos2.y+=1;
				}
				if(d=="S")
				{
					pos2.y+=-1;
				}
				if(d=="W")
				{
					pos2.x+=-1;
				}
				if(d=="E")
				{
					pos2.x+=1;
				}
				return pos2;
	}
	public Tuils getD(Tuils t,String d)
	{
		Pos pos2=new Pos(getNewPos(t,d));
	//	int[] pos2=getNewPos(t,d);
		if (map.containsKey(pos2))
		{
			return map.get(pos2);
		}
		else return null;
		
	}
	public void scout(Tuils t,String d,ArrayList<String> ressources,long altitude)
	{
		
		
		Pos newPos=getNewPos(t,d);
		
		
				
		if(map.get(newPos)==null)
		{
		
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
		
		if (ressources.contains(obj3))
		{
			map.get(newPos).setObj3(true);
			map.get(newPos).setObj3(1);
			
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
		
		
		if(ressources.contains("FISH"))
		{
			
			map.get(newPos).setFish(true);
		}
		if (ressources.size()==1)  
		{
			{
				if (ressources.get(0).equals("FISH"))
				{
					map.get(newPos).setOnlyFish(true);
				}
				
			}
	
		}
		if ((ressources.size()>0  && !(ressources.get(0).equals("FISH"))) || ressources.size()==0)
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
			
			if(getD(t,direction.get(i))!=null){
			if(getD(t,direction.get(i)).isObj1() && !(getD(t,direction.get(i)).isOnlyFish()))
			{
				
				actionFinal[1]=direction.get(i);
				actionFinal[0]="Move_to";
				return actionFinal;
			}
			}
		}
		
	
		
		//// obj2
		for (int i=0;i<direction.size();i++)
		{
			if(getD(t,direction.get(i))!=null)
			{
			if(getD(t,direction.get(i)).isObj2() && !(getD(t,direction.get(i)).isOnlyFish()))
			{
				
				actionFinal[1]=direction.get(i);
				actionFinal[0]="Move_to";
				return actionFinal;
				
			}
			}
		}	
		// obj3
		for (int i=0;i<direction.size();i++)
		{
			if(getD(t,direction.get(i))!=null)
			{
			if(getD(t,direction.get(i)).isObj3() && !(getD(t,direction.get(i)).isOnlyFish()))
			{
				
				actionFinal[1]=direction.get(i);
				actionFinal[0]="Move_to";
				return actionFinal;
				
			}
			}
		}	
		
	
		//// isScouted
		ArrayList<String> newDir=new ArrayList<String>();
		
		Tuils a=getD(t,direction.get(0));
	
		
		
		for (int i=0;i<direction.size();i++)
		{
			
			if(getD(t,direction.get(i))==null)
			{
				
				
				newDir.add(direction.get(i));
			}
		}
			
			if(newDir.size()>0)
			{
				
				actionFinal[0]="Scout";
				actionFinal[1]=newDir.get(0);
				return actionFinal;
			}
				
		
		/// lessExplored
			
			/*String dir2=lessExplored(t);
			if (! dir2.equals(""))
			{
				actionFinal[0]="Move_to";
				actionFinal[1]=dir2;
				return actionFinal;
			}*/
		
		/// isOnlyFish et pas exploré
			
		ArrayList<String> newDir2=new ArrayList();
			
		for (int i=0;i<direction.size();i++)
		{
			if(getD(t,direction.get(i))!=null)
			{
				
				
				if(! getD(t,direction.get(i)).isOnlyFish())
				{
					if(! getD(t,direction.get(i)).isExplored())
					{
					newDir2.add(direction.get(i));
					actionFinal[0]="Move_to";
					}
					
					
				}
			}
		}
		
		int s=newDir2.size();
		if (newDir2.size()>0)
		{
			
			Random rd=new Random();
		
			actionFinal[1]=newDir2.get(rd.nextInt(s));
			return actionFinal;
		}
		
		// isOnlyFish
		ArrayList<String> newDir3=new ArrayList();
		for (int i=0;i<direction.size();i++)
		{
			if(getD(t,direction.get(i))!=null)
			{
				
				
				if(! getD(t,direction.get(i)).isOnlyFish())
				{
					
					newDir3.add(direction.get(i));
					actionFinal[0]="Move_to";
					
					
					
				}
			}
		}
		
		s=newDir3.size();
		if (newDir3.size()>0)
		{
			
			Random rd=new Random();
		
			actionFinal[1]=newDir3.get(rd.nextInt(s));
			return actionFinal;
		}
		
		//glimps
		
		
		
		s=direction.size();
		if(s>0)
		{
			Random rd=new Random();
			actionFinal[1]=direction.get(rd.nextInt(s));
			actionFinal[0]="Glimpse";
			return actionFinal;
		}
		actionFinal[0]="Stop";
		actionFinal[1]="Stop";
		return actionFinal;
	}


	public HashMap<Pos, Tuils> getMap() {
		return map;
	}


	public void setMap(HashMap<Pos, Tuils> map) {
		this.map = map;
	}
	
	public void match(){
		
	}


	public String getObj3() {
		return obj3;
	}


	public void setObj3(String obj3) {
		this.obj3 = obj3;
	}
	
	/*public String lessExplored(Tuils current)
	{
		String newDir="";
		
		ArrayList<String> direction=new ArrayList<String>();
		direction.add("N");
		direction.add("S");
		direction.add("E");
		direction.add("W");
		
		double comptmax=0;
		
		for (int k=0;k<4;k++)
		{
			if (! getD(current,direction.get(k)).isOnlyFish())
			{
				Tuils tuiltest=getD(current,direction.get(k));
				double compt=0;
			
				for (int i=0;i<4;i++)
				{
					if(getD(current,direction.get(k))==null)
					{
						compt=compt+1;
					}
					if(getD(current,direction.get(k)).isOnlyFish())
					{
						compt=compt-0.5;
					}
				}
				
				if (compt>=comptmax)
				{
				
					comptmax=compt;
					newDir=direction.get(k);
				}
			}
		}
		
		
		return newDir;
	}*/
	                                                                              
}
