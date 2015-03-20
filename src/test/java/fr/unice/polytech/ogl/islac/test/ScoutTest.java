package fr.unice.polytech.ogl.islac.test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.unice.polytech.ogl.islac.action.Action;
import fr.unice.polytech.ogl.islac.action.Scout;

public class ScoutTest {

	@Test public void readScout(){
		
		String s = "{\"status\":\"OK\", \"cost\": 8,\"extras\": {\"resources\": [\"WOOD\", \"FUR\", \"FLOWER\"], \"altitude\" : -23}}";
		Action test= new Action();
		test.readScout(s);
	}
}
