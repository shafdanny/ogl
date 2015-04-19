package fr.unice.polytech.ogl.islac.action;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import fr.unice.polytech.ogl.islac.data.Pos;

public class Move_to extends Action {

	
	public Move_to()
	{
		this.name="Move_to";
	}
	@Override
	// Méthodes move_to
	
	public String act(String direction,Action a){
		
		Pos newPos=a.getMap().getNewPos(a.getC().getCurrentTuil(),direction);
		a.getC().setCurrentTuil(a.getMap().getD(a.getC().getCurrentTuil(), direction));
		a.getC().getCurrentTuil().setPos(newPos);
		a.getC().setPos(newPos);
		a.getC().getCurrentTuil().setExplored(true);
		a.setLastAction(this);
		return "{ \"action\": \"move_to\", \"parameters\": {\"direction\": " +"\""+ direction+"\" " +"} }";
	}
	
	public void read(String info,Action act)
	{
		try {
	    	  JSONParser parser=new JSONParser();		  
		      JSONObject obj = (JSONObject)parser.parse(info);
		  		
		      
		      long pa=(long)obj.get("cost");    
		      	act.getC().addPa(pa);
	
	} catch (ParseException e) {
		e.printStackTrace();
		}
		
	}
}
