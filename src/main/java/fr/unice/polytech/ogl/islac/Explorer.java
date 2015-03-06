package fr.unice.polytech.ogl.islac;

import eu.ace_design.island.bot.*;

public class Explorer implements IExplorerRaid {

	Methods m1=new Methods();
	
    @Override
	public void initialize(String context) {

		
	}

    @Override
	public String takeDecision() {
    	
    	String decision = m1.stop();
    	return decision;
		
	}

    @Override
	public void acknowledgeResults(String results) {
		
    	// test commit
	}
}