package fr.unice.polytech.ogl.islac.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import fr.unice.polytech.ogl.islac.data.Tuils;

public class TuilsTest {

@Test
public void testTuils(){
	
	Tuils t=new Tuils();
	assertTrue(Tuils.oppose("N").equals("S"));
	assertTrue(Tuils.oppose("E").equals("W"));
	assertTrue(Tuils.oppose("S").equals("N"));
	assertTrue(Tuils.oppose("W").equals("E"));
	assertTrue(Tuils.oppose("")==null);
	t.setObj1(true);
	assertTrue(t.isObj(1));
	
	t.setObj2(true);
	assertTrue(t.isObj(2));
	
	t.setObj3(true);
	assertTrue(t.isObj(3));
	
	assertFalse(t.isScouted());
	t.setScouted(true);
	assertTrue(t.isScouted());
	assertTrue(t.getObj1()==0);
	t.setObj1(1);
	assertTrue(t.getObj1()==1);
	
	assertTrue(t.getObj2()==0);
	t.setObj2(1);
	assertTrue(t.getObj2()==1);
	
	assertTrue(t.getObj3()==0);
	t.setObj3(1);
	assertTrue(t.getObj3()==1);
	ArrayList<String> a=t.getObjectivesInTile();
	assertTrue(a.size()==0);
	t.setObjectivesInTile(new ArrayList<String>());
	System.out.println(t);
	assertFalse(t.isGlimpsed());
	t.setGlimpsed(true);
	assertTrue(t.isGlimpsed());
}


}
