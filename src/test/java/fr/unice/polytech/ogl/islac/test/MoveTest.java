package fr.unice.polytech.ogl.islac.test;
import static org.junit.Assert.*;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import fr.unice.polytech.ogl.islac.action.Action;
import fr.unice.polytech.ogl.islac.action.Move_to;
import fr.unice.polytech.ogl.islac.action.Scout;
import fr.unice.polytech.ogl.islac.character.Character1;
import fr.unice.polytech.ogl.islac.data.Arena;
import fr.unice.polytech.ogl.islac.data.Pos;
import fr.unice.polytech.ogl.islac.data.Tuils;

public class MoveTest {
	
	Character1 c;
	Action a;
	Tuils t1,t2;
	
	@Before public void init(){
		a= new Action();
		a.initAction();
		t1 = new Tuils();
	}
	
	@Test public void actTest(){
		
	//	t2 = new Tuils(5, 11);
	//	Pos pos2 = new Pos(5, 11);
		String s = "{\"status\":\"OK\", \"cost\": 8,\"extras\": {\"resources\": [\"WOOD\", \"FUR\", \"FLOWER\"], \"altitude\" : -23}}";


		Pos pos1 = new Pos(5, 10);
		t1.setPos(pos1);
		
		a.getC().setPos(pos1);
		a.getC().setCurrentTuil(t1);
		
		a.setLastAction(new Scout());
		a.setLastDirection("N");
		new Scout().read(s,a);

		
		Pos newPos = new Pos (a.getMap().getNewPos(a.getC().getCurrentTuil(),"N"));
		new Move_to().act("N",a);
		
		assertEquals(newPos.getX(), 5);
		assertEquals(newPos.getY(), 11);
		
		assertEquals(a.getC().getCurrentTuil().getPos().getX(), 5);
		assertEquals(a.getC().getCurrentTuil().getPos().getY(), 11);
		
		assertEquals(a.getC().getPos().getX(), 5);
		assertEquals(a.getC().getPos().getY(), 11);

	}
	
	@Ignore public void readTest()
	{
		
	}
	
	
}
