package fr.unice.polytech.ogl.islac;

import static org.junit.Assert.assertEquals;

import fr.unice.polytech.ogl.islac.action.Action;
import fr.unice.polytech.ogl.islac.action.Scout;
import fr.unice.polytech.ogl.islac.character.*;
import fr.unice.polytech.ogl.islac.data.Arena;
import fr.unice.polytech.ogl.islac.data.Tuils;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

import fr.unice.polytech.ogl.islac.action.Action;
import fr.unice.polytech.ogl.islac.data.Arena;
import fr.unice.polytech.ogl.islac.data.Tuils;

import java.lang.*;
import java.util.ArrayList;

public class Test {

	
	public String a()
	{
		return "hhhh";
	}
	public String b()
	{
		return this.a();
		
	}


	public static void main(String[] args) {

	   
	
	String s = "{\"status\":\"OK\", \"cost\": 8,\"extras\": {\"resources\": [\"WOOD\", \"FUR\", \"FLOWER\"], \"altitude\" : -23}}";
	Action test= new Action();
	Tuils t1=new Tuils(0,0);
	test.getC().setCurrentTuil(t1);	
	Arena map = test.getMap();
	test.setLastAction(test.getScout());
	test.setLastDirection("N");
>>>>>>> a8555e5cd0cdac83ccf001480f548e296d830e71
	
	test.readScout(s);
	long k= test.getC().getPa();
	//assertEquals(k, -8);
	assert(map.getD(test.getC().getCurrentTuil(),"N").isWood());
	assert(map.getD(test.getC().getCurrentTuil(),"N").isFur());
	assert(map.getD(test.getC().getCurrentTuil(),"N").isFlower());
	assert(!map.getD(test.getC().getCurrentTuil(),"N").isFish());
	assert(!map.getD(test.getC().getCurrentTuil(),"N").isOnlyFish());
	
	}
}

		



	


