package fr.unice.polytech.ogl.islac.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import fr.unice.polytech.ogl.islac.Contract;
import fr.unice.polytech.ogl.islac.data.Ressources;

public class TestContract {
	
	ArrayList<Ressources> obj;

	
@Before	public void init()
{
	obj.add(new Ressources("FUR",1000));
	obj.add(new Ressources("PLANK",500));
	obj.add(new Ressources("SUGAR_CANNE",1000));
	

}
	
	
@Ignore public void testChooseContract()
{
	//init();
	Contract c=new Contract(obj);
	c.chooseContract(5000);
//	assertEquals(c.getFirstSelectedContract().get(0).getName().equals("PLANK"));
	
}


private void assertEquals(boolean equals) {
	// TODO Auto-generated method stub
	
}


}
