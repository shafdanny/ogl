package fr.unice.polytech.ogl.islac.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import fr.unice.polytech.ogl.islac.action.Action;

public class ActionTest {


	@Test
	
	public void testAction()
	{
		Action act=new Action();
		act.initAction();
		assertTrue(act.act()==null);
		assertTrue(act.act("assaz")==null);
		assertTrue(act.act("assaz",1)==null);
		act.read("az");
		
		act.setListCreek(new ArrayList<String>());
		act.getListCreek();
		Action act2=new Action();
		act2.setName("aa");
		act.setName("aa");
		assertTrue(act.equals(act2));
		assertTrue(act.getRessourceName()==null);
		act.act("aa",act);
		System.out.println(act);
	}

}
