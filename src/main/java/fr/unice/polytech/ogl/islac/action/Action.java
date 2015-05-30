package fr.unice.polytech.ogl.islac.action;

import java.util.ArrayList;

import fr.unice.polytech.ogl.islac.data.*;

import java.util.Map;

import fr.unice.*;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import fr.unice.polytech.ogl.islac.data.*;
import fr.unice.polytech.ogl.islac.character.*;

public class Action {
	
	String name;
	protected Action lastAction;
	Arena map;
	Character1 c;
	private List<String> listCreek;
	private String lastDirection;
		
	public Action()
	{
		map=new Arena();
		
	}
	
	public void initAction()
	{
		listCreek=new ArrayList<String>();		
		setMap(new Arena());
		setC(new Character1());
	}
//Méthodes_
	

	/**
	 * méthode qui est héritée dans le package action
	 * @return null
	 */
	
	public String act()
	{
		return null;
	}
	/**
	 * méthode qui est héritée dans le package action
	 * @return null
	 */
	
	public String act(String info)
	{
		return null;
	}
	/**
	 * méthode qui est héritée dans le package action
	 * @return null
	 */

	public String act(String info, int number)
	{
		return null;
	}
	
	/**
	 * Méthode read utilisée pour l'initialisation (on récupère le budget, les objectifs,
	 * la creek_id et le nombre de personnes).
	 * 
	 * @param data
	 * @param a
	 */
	
	public void read(String data,Action a)
	{
		{
			 try {
		    	  JSONParser parser=new JSONParser();		  
			      JSONObject obj = (JSONObject)parser.parse(data);
			      String creek_id=(String)obj.get("creek");
			      long pa=(long)obj.get("budget");
			      long men =(long)obj.get("men");
			      a.getMap().getListCreek().add(creek_id);
			      a.getC().setPa(pa);
			      a.getC().setNbTotal(men);
			      JSONArray array=(JSONArray) obj.get("objective");
			      
			      ArrayList<Ressources> objective = new ArrayList<Ressources>();
			      for (int k=0; k<array.size(); k++)
			      {
			    	 // System.out.println(k);
			    	  JSONObject objN= (JSONObject) array.get(k);
			    	  String nom=(String)objN.get("resource");
			    	  long quantity=(long)objN.get("amount");
			    	  if(!(nom.equals("GLASS")) && !(nom.equals("PLANK")) && !nom .equals("INGOT") 
			    			  && !nom.equals("LEATHER") && !nom.equals("RUM"))
			    	  {
			    		  
			    		  if(nom.equals("WOOD"))
			    		  {
			    			  if(quantity*2<pa)
			    			  {
			    				  pa=pa-quantity*2;
			    				  a.getC().getPrimaryObjectives().add(new Ressources(nom,quantity));
			    			  }
			    		  }
			    		  if(nom.equals("FISH"))
			    		  {
			    			  if(quantity<pa)
			    			  {
			    				  pa=pa-quantity;
			    				  a.getC().getPrimaryObjectives().add(new Ressources(nom,quantity));
			    			  }
			    		  }
			    		  
			    		  if(nom.equals("SUGAR_CANE"))
			    		  {
			    			  if(quantity*4<pa)
			    			  {
			    				  pa=pa-quantity*4;
			    				  a.getC().getPrimaryObjectives().add(new Ressources(nom,quantity));
			    			  }
			    		  }
			    		  if(nom.equals("QUARTZ"))
			    		  {
			    			  if(quantity*8<pa)
			    			  {
			    				  pa=pa-quantity*8;
			    				  a.getC().getPrimaryObjectives().add(new Ressources(nom,quantity));
			    			  }
			    		  }
			    		  if(nom.equals("FLOWER"))
			    		  {
			    			 
			    				  
			    				  a.getC().getPrimaryObjectives().add(new Ressources(nom,quantity));
			    			  
			    		  }
			    		  if(nom.equals("ORE"))
			    		  {
			    			  if(quantity*4<pa)
			    			  {
			    				  pa=pa-quantity*4;
			    				  a.getC().getPrimaryObjectives().add(new Ressources(nom,quantity));
			    			  }
			    		  }
			    		  if(nom.equals("FRUITS"))
			    		  {
			    			  if(quantity*1<pa)
			    			  {
			    				  pa=pa-quantity;
			    				  a.getC().getPrimaryObjectives().add(new Ressources(nom,quantity));
			    			  }
			    		  }
			    		  
			    		  if(nom.equals("FUR"))
			    		  {
			    			  if(quantity*8<pa)
			    			  {
			    				  
			    				  pa=pa-quantity*8;
			    				  a.getC().getPrimaryObjectives().add(new Ressources(nom,quantity));
			    			  }
			    		  }
			    	  }
			    	  
			    	  
			    	  if(nom.equals("PLANK") && quantity<pa){
			    		  pa=pa-quantity;
			    		  SecondaryRessources plank = new SecondaryRessources(nom, quantity);			    		  
			    		  a.getC().getSecondaryObjectives().add(plank);
			    		  a.getC().getPrimaryObjectives().addAll(plank.getResourceNeededToTransform());			    		  
			    	  }
			    	  
			    	  if(nom.equals("GLASS") && quantity*180<pa){
			    		//  pa=pa-quantity*115;
			    		//  SecondaryRessources glass = new SecondaryRessources(nom, quantity);			    		  
			    		 // a.getC().getSecondaryObjectives().add(glass);
			    		//  a.getC().getPrimaryObjectives().addAll(glass.getResourceNeededToTransform());
			    	  }
			    	  
			    	  if(nom.equals("INGOT") && quantity*55<pa){
			    		//  pa=pa-quantity*55;
			    		 // SecondaryRessources ingot = new SecondaryRessources(nom, quantity);			    		  
			    		 // a.getC().getSecondaryObjectives().add(ingot);
			    		 // a.getC().getPrimaryObjectives().addAll(ingot.getResourceNeededToTransform());
			    	  }
			    	  
			    	  if(nom.equals("LEATHER") && quantity*30<pa){
			    		 // pa=pa-quantity*30;
			    		//  SecondaryRessources leather = new SecondaryRessources(nom, quantity);			    		  
			    		 // a.getC().getSecondaryObjectives().add(leather);
			    		 // a.getC().getPrimaryObjectives().addAll(leather.getResourceNeededToTransform());
			    	  }
			    	  
			    	  if(nom.equals("RUM") && quantity*60<pa){
			    		//  pa=pa-quantity*50;
			    		//  SecondaryRessources rum = new SecondaryRessources(nom, quantity);			    		  
			    		//  a.getC().getSecondaryObjectives().add(rum);
			    		//  a.getC().getPrimaryObjectives().addAll(rum.getResourceNeededToTransform());
			    	  }			    	  	  
			      }			      
			      
			} catch (ParseException e) {
				e.printStackTrace();
		}
		
		}
	}
	public void read(String data)
	{
		/* try {
	    	  JSONParser parser=new JSONParser();		  
		      JSONObject obj = (JSONObject)parser.parse(data);
		      String creek_id=(String)obj.get("creek");
		      int pa=(int)obj.get("budget");
		      int men =(int)obj.get("men");
		      map.getListCreek().add(creek_id);
		      //a.getC().setPa(pa);
		      c.setNbTotal(men);
		      JSONArray array=(JSONArray) obj.get("objective");
		      
		      ArrayList<Ressources> objective = new ArrayList<Ressources>();
		      for (int k=0; k<array.size(); k++)
		      {
		    	  
		    	  JSONObject objN= (JSONObject) array.get(k);
		    	  String nom=(String)objN.get("resource");
		    	  int quantity=(int)objN.get("amount");
		    	  objective.add(new Ressources(nom,quantity));
		    	  	  
		      }
		      
		      
		      
		    
		      
		      
		      
		} catch (ParseException e) {
			e.printStackTrace();
	}
	*/
	}

	// Méthodes pour exploit


	
	public Arena getMap() {
		return map;
	}


	public void setMap(Arena map) {
		this.map = map;
	}




	public String getLastDirection() {
		return lastDirection;
	}

	public void setLastDirection(String lastDirection) {
		this.lastDirection = lastDirection;
	}

	public Character1 getC() {
		return c;
	}


	public void setC(Character1 c) {
		this.c = c;
	}



	public List<String> getListCreek() {
		return listCreek;
	}

	public void setListCreek(ArrayList<String> listCreek) {
		this.listCreek = listCreek;
	}
	
	public boolean equals(Action a){
		if (this.name.equals(a.name))
		{
			return true;
		}
		else return false;
	}

	public String act(String direction, Action a) {
		// TODO Auto-generated method stub
		return null;
	}

	public Action getLastAction() {
		return lastAction;
	}

	public void setLastAction(Action lastAction) {
		this.lastAction = lastAction;
	}

	public String getRessourceName() {
		// TODO Auto-generated method stub
		return null;
		
	}
	
	public String toString(){
		return name;
	}

}
