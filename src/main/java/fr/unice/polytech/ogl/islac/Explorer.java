package fr.unice.polytech.ogl.islac;

import eu.ace_design.island.bot.*;

public class Explorer implements IExplorerRaid {

    @Override
	public void initialize(String context) {
		
	}

    @Override
	public String takeDecision() {
    	
    	String decision;
    	decision ="{ \"action\": \"stop\" }";
    	return decision;
		
	}

    @Override
	public void acknowledgeResults(String results) {
		
    	// test commit
	}
}