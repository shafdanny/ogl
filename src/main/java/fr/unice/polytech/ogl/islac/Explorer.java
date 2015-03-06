package fr.unice.polytech.ogl.islac;

import eu.ace_design.island.bot.*;

public class Explorer implements IExplorerRaid {

    @Override
	public void initialize(String context) {

		
	}

    @Override
	public String takeDecision() {
    	Methods m1= new Methods();
    	String decision = m1.stop();
    	return decision;
		
	}

    @Override
	public void acknowledgeResults(String results) {
		
    	// test commit
	}
}