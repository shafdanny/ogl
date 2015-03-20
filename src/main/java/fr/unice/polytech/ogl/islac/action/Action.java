package fr.unice.polytech.ogl.islac.action;

import java.util.ArrayList;
import java.util.Map;

import fr.unice.*;
import java.util.List;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import fr.unice.polytech.ogl.islac.data.*;
import fr.unice.polytech.ogl.islac.character.*;

public class Action {
	
	private List<String> listCreek;
	Exploit exploit=new Exploit();
	Explore explore= new Explore();
	Land land=new Land();
	Move_to move=new Move_to();
	Scout scout=new Scout();
	Stop stop=new Stop();
	Arena map=new Arena();
	Character1 c=new Character1();
	
	
	public Action()
	{
		listCreek=new ArrayList<String>();
		
		
	}
//Méthodes
	
/**
 * appelle la méthode act() écrit dans les autres classes
 * @return null
 */
	
	public String act()
	{
		return null;
	}
	
	/**
	 * appelle la méthode act() écrit dans les autres classes
	 * @return null
	 */
	
	public String act(String info)
	{
		return null;
	}
	
	/**
	 * appelle la méthode act() écrit dans les autres classes
	 * @return null
	 */
	
	public String act(String info, int number)
	{
		return null;
	}
	
	/**
	 * méthode de lecture des résultats de l'initalize
	 * on écrit les résultats obtenus dans d'autres classes
	 * @return null
	 */
	
	public void read(String data)
	{
		 try {
	    	  JSONParser parser=new JSONParser();		  
		      JSONObject obj = (JSONObject)parser.parse(data);
		      String creek_id=(String)obj.get("creek");
		      int pa=(int)obj.get("budget");
		      int men =(int)obj.get("men");
		      map.getListCreek().add(creek_id);
		      c.setPa(pa);
		      
		      
		      //Ressources re=new Wood();
		      
		      
		      
		} catch (ParseException e) {
			e.printStackTrace();
	}
	
	}

	// Méthodes pour exploit

/**
* Permet de faire un exploit en entrant la ressource désirée
* Voir la méthode act dans la classe Exploit
* @param ressource
*/	
	public void exploit(String ressource) {
		exploit.act(ressource);
	}
	
/**
* Permet de récupérer les informations obtenus lors d'un exploit
* Voir la méthode read dans la classe Exploit
* @param data
*/
	public void readExploit(String data){
		exploit.read(data);
	}

	// Méthodes pour explore


/**
* Permet de faire un explore de l'endroit où on est
* Voir la méthode act dans la classe Explore
* @param /
*/	
	
	public void explore() {
		explore.act();
	}
	
/**
* Permet de récupérer les informations obtenus lors d'un exploit
* Voir la méthode read dans la classe Exploit
* @param data
*/
	public void readExplore(String data, Arena map){
		explore.read(data);
	}

	// Méthodes pour land


/**
* Permet de faire un land à partir du creek_id
* et de choisir le nombre d'hommes à débarquer avec number
* Voir la méthode act dans la classe Land
* @param creek_id, number
*/		
	
	public void land(String creek_id, int number) {
		land.act(creek_id, number);
	}
	
/**
* Permet de récupérer les informations obtenus lors d'un land
* Voir la méthode read dans la classe Land
* @param data
*/
		public void readLand(String data, Arena map){
			land.read(data);
		}
		
		// Méthodes pour move_to


/**
* Permet de faire un move_to vers la direction désirée
* Voir la méthode act dans la classe Move_to
* @param direction
*/		

	public void move_to(String direction) {
		move.act(direction);
	}
	
/**
* Permet de récupérer les informations obtenus lors d'un move_to
* Voir la méthode read dans la classe Move_to
* @param data
*/
	public void readMove_to(String data, Arena map){
				move.read(data);
			}

	// Méthodes pour scout
	
/**
 * Permet de faire scout en donnant la direction désirée
 * Voir la méthode act dans la classe Scout
 * @param direction
 */
	public void scout(String direction) {
		scout.act(direction);
	}
		
/**
 * Permet de récupérer les informations obtenus lors d'un scout
 * Voir la méthode readScout dans la classe Scout
 * @param data
 */
	public void readScout(String data, Arena map){
		scout.read(data);
	}

	// Méthodes pour stop
	
/**
 * Permet de faire stop
 * Voir la méthode act dans la classe Stop
 * @param /
 */	
	
	public void stop() {
		stop.act();
	}

	
	// A commenter
	
	public Arena getMap() {
		return map;
	}


	public void setMap(Arena map) {
		this.map = map;
	}


	public Character1 getC() {
		return c;
	}


	public void setC(Character1 c) {
		this.c = c;
	}
	
}
