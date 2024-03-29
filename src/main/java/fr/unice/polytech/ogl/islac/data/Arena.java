package fr.unice.polytech.ogl.islac.data;

import java.util.*;

import fr.unice.polytech.ogl.islac.character.Character1;

/**
 * Arena represents the island that is explored by the robot.
 * The robot registers each tiles as a HashMap of Position and the Tiles.
 * 
 * @author user
 *
 */
public class Arena{
	
	private List<String> listCreek;
	private HashMap<Pos,Tuils> map;
	private String obj1;
	private String obj2;
	private String obj3;
	private ArrayList<String> objectives;
	private ArrayList<Ressources> resourceToBeTransformed;
	
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
	
	public String objectivesAsString(){
		String objectivesConsideredByArena = "ARENA OBJECTIVES : ";
		
		for(String res:objectives)
			objectivesConsideredByArena += res + " ";
		
		return objectivesConsideredByArena;
	}
	
	/**
	 * Get objectives from Character so that Arena can set if a tile contain some resources from objectives
	 * Note that the tiles only need to know if a certain resource exist and not the exact amount.
	 * The relative amount can also be implemented later.
	 * 
	 * @param c The character that have the objectives needed
	 */
	public void update(Character1 c)
	{
		objectives = new ArrayList<>();
		
		if(c.getPrimaryObjectives().size()>0){
		
			for(Ressources res:c.getPrimaryObjectives()){
				objectives.add(res.getName());
			}
		}
		
		if(c.getSecondaryObjectives().size()>0){
			
			for(SecondaryRessources res:c.getSecondaryObjectives()){
				ArrayList<Ressources> primaryResourcesNeeded = res.getResourceNeededToTransform();
				resourceToBeTransformed = new ArrayList<>();
				
				for (Ressources primRes : primaryResourcesNeeded){
					resourceToBeTransformed.add(primRes);
					objectives.add(primRes.getName());
				}
			}
		}
	}
	
	/**
	 * Méthode addTuils, permet d'ajouter un ensemble 
	 * (coordonée de ma tuille, tuille) à une hashmap 
	 * @param t
	 *
	 */
	
	public void addTuils(Tuils t)
	{
		map.put(t.getPos(),t);
	}
	
	/**
	 * Méthode getNewPos, permet d'obtenir la nouvelle position 
	 * après avoir choisi une tuille et une direction
	 * @param t, d 
	 *
	 */
	
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
	
	/**
	 * Méthode getD, renvoie la tuille qui correspond à la destination  
	 * en partant d'une tuille de réference à condition que celle ci soit
	 * ajouter dans la hashmap à partir de addTuils ou de scout
	 * @param t, d
	 *
	 */
	
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
	
	/**
	 * Méthode scout, permet d'ajouter les tuils dans la hashmap 
	 * ainsi que de mettre à jour les objectifs liées a ces tuils
	 * @param t, d, ressource, altitude
	 *
	 */
	
	public void scout(Tuils t,String d,ArrayList<String> ressources,long altitude)
	{
		
		Pos newPos=getNewPos(t,d);	
		
		// Initialize the new scouted tile		 
		if(map.get(newPos)==null)
		{		
			map.put(newPos,new Tuils(newPos));
			map.get(newPos).addAltitude((int) altitude,t);	
			map.get(newPos).setScouted(true);
		}
		
		/**
		 * The action Scout gives a list of resources in the scouted tile.
		 * This method check if the resources is in the objective.
		 * If yes, then set the list of resources in the tile that we save in our map.
		 */
		if(ressources.size()>0 && objectives != null){
			ArrayList<String> resourceNeeded = new ArrayList<>();
			
			for(String resource:ressources){
				if(objectives.contains(resource))
					resourceNeeded.add(resource);
			}
			
			map.get(newPos).setObjectivesInTile(resourceNeeded);
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
	
	/**
	 * Determine the best course of action to be taken.
	 * 
	 * @param currentTile	The current tile 
	 * @return
	 */
	
	public String[] bestD(Tuils currentTile)
	{
		String[] actionFinal=new String[2];
		ArrayList<String> direction=new ArrayList<String>();
		direction.add("N");
		direction.add("S");
		direction.add("E");
		direction.add("W"); 
		
		// si un objectif est sur un case adjacente on s'y déplace
		for(String dir:direction){
			
			Tuils tileToAnalyse = getD(currentTile,dir);
			
			if(tileToAnalyse != null)
			{
				if(tileToAnalyse.getObjectivesInTile() != null && tileToAnalyse.getObjectivesInTile().size()>0){
					actionFinal[1] = dir;
					actionFinal[0] = "Move_to";
					return actionFinal;
				}
			}
		}
		/*
		// si on a une case avec que du poisson est près de nous
		// et qu'on ne l'a jamais glimpsé on la glimps pour vérifier que 
		// c'est bien de l'eau
		
		for(int i=0;i<direction.size();i++)
		{
			if(getD(currentTile,direction.get(i))!=null)
			{
				if(getD(currentTile,direction.get(i)).isOnlyFish() && !getD(currentTile,direction.get(i)).isGlimpsed())
				{
					getD(currentTile,direction.get(i)).setGlimpsed(true);
					actionFinal[1]=direction.get(i);
					actionFinal[0]="Glimpse";
					return actionFinal;
				}
			}
		}*/
		
		//// isScouted on scout les éventuelles tiles adjacentes qui ne l'ont jamais été
		ArrayList<String> newDir=new ArrayList<String>();
		
		Tuils a=getD(currentTile,direction.get(0));
	
		for (int i=0;i<direction.size();i++)
		{
			if(getD(currentTile,direction.get(i))==null)
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
				
		
		/// lessExplored servait à choisir la direction vers laquelle 
		// on avait globalement le moins exploré
			
			/*String dir2=lessExplored(t);
			if (! dir2.equals(""))
			{
				actionFinal[0]="Move_to";
				actionFinal[1]=dir2;
				return actionFinal;
			}*/
		
			
		/// Choix de la destination une fois que les 4 cases autour de nous sont scouté
		//( évitement des cases d'eau / favorisation des cases non explorées 
			
		ArrayList<String> newDir2=new ArrayList();
			
		for (int i=0;i<direction.size();i++)
		{
			if(getD(currentTile,direction.get(i))!=null)
			{
				
				
				if(! getD(currentTile,direction.get(i)).isOnlyFish())
				{
					if(! getD(currentTile,direction.get(i)).isExplored())
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
		
			if(! getD(currentTile,newDir2.get(rd.nextInt(s))).isExplored()){
				actionFinal[1]=newDir2.get(rd.nextInt(s));
				return actionFinal;
			}
		}
		
		// si toutes les cases étaaient déjà exploré direction aléatoire sauf l'eau qu'on évite
		ArrayList<String> newDir3=new ArrayList();
		for (int i=0;i<direction.size();i++)
		{
			if(getD(currentTile,direction.get(i))!=null)
			{
				
				
				if(! getD(currentTile,direction.get(i)).isOnlyFish())
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
		
		//glimps si on est entouré de 4 cases "d'eau" ne peut arrivé que sur la case de départ si le glimps est désactivé par défault
		// sert à se débloquer si on a 4 case avec que du poisson autour de nous
		// sert uniquement si on a désactivé le glimps qui vérifie si les cases qu'on scout
		// et qui ne contiennent que du poisson sont vrraiment de l'eau
		
		
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

	public String[] objectiveChoice(Tuils t, ArrayList<String> direction, int k) {
		String[] actionFinal=new String[2];
		
		for (int i=0;i<direction.size();i++)
		{
			
			if(getD(t,direction.get(i))!=null){
			if(getD(t,direction.get(i)).isObj(k) && !(getD(t,direction.get(i)).isOnlyFish()) && !getD(t,direction.get(i)).isExplored())
			{
				
				actionFinal[1]=direction.get(i);
				actionFinal[0]="Move_to";
				return actionFinal;
			}
			}
		}
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
