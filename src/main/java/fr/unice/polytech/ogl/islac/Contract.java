package fr.unice.polytech.ogl.islac;

import java.util.ArrayList;

import eu.ace_design.island.bot.*;
import org.json.*;
import fr.unice.polytech.ogl.islac.character.Character1;
import fr.unice.polytech.ogl.islac.data.Ressources;

public class Contract {
	
	private ArrayList<Ressources> allContract;
	
	private ArrayList<Ressources> firstSelectedContract;
	
	private ArrayList<Ressources> primaryRessources;
	
	
	public Contract(ArrayList<Ressources> c)
	{
		allContract=c;
	}
	
	
	public void chooseContract(int pa)
	{
		int budget=pa;
		for (int i=0;i<allContract.size();i++)
		{
			if(allContract.get(i).getName().equals("FLOWER"))
			{
				firstSelectedContract.add(allContract.get(i));
			}
			
			else
			{
				if (allContract.get(i).estimCost()<pa)
				{					
				
					firstSelectedContract.add(allContract.get(i));
					budget=budget-allContract.get(i).estimCost();
				}
				else
				{
					budget=compareContract(allContract.get(i),budget);
				}
					
			}
		}
		
	}
	
	
	public int compareContract(Ressources c1,int pa)
	{
		int budget=pa;
		for (int i=0;i<firstSelectedContract.size();i++)
		{
			if(firstSelectedContract.get(i).estimCost()>c1.estimCost() && !firstSelectedContract.get(i).getName().equals("FLOWER"))
			{
				firstSelectedContract.remove(i);
				firstSelectedContract.add(c1);
				budget=budget+firstSelectedContract.get(i).estimCost()-c1.estimCost();
			}
		}
		
		return budget;
	}

	public void choosePrimaryRessources()
	{
		
	}


	public ArrayList<Ressources> getAllContract() {
		return allContract;
	}


	public void setAllContract(ArrayList<Ressources> allContract) {
		this.allContract = allContract;
	}


	public ArrayList<Ressources> getFirstSelectedContract() {
		return firstSelectedContract;
	}


	public void setFirstSelectedContract(ArrayList<Ressources> firstSelectedContract) {
		this.firstSelectedContract = firstSelectedContract;
	}


	public ArrayList<Ressources> getPrimaryRessources() {
		return primaryRessources;
	}


	public void setPrimaryRessources(ArrayList<Ressources> primaryRessources) {
		this.primaryRessources = primaryRessources;
	}
	
}
