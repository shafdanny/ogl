package fr.unice.polytech.ogl.islac;

import eu.ace_design.island.bot.*;
import org.json.*;

public class Explorer implements IExplorerRaid {

	Methods m1=new Methods();
	
    @Override
	public void initialize(String context) {
    	Methods m1=new Methods();
    	m1.extraireInfo(context);
    	m1.updateTurn();
		
	}

    @Override
	public String takeDecision() {
    	m1.updateTurn();
    	return m1.chooseDecision();
    	
		
	}

    @Override
	public void acknowledgeResults(String results) {
		
    	// test commit
	}
}