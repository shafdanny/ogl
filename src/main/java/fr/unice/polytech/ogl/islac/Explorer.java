package fr.unice.polytech.ogl.islac;

import eu.ace_design.island.bot.*;
import org.json.*;

public class Explorer implements IExplorerRaid {

	public Simulator sim1;

	
    @Override
	public void initialize(String context) {
    	sim1=new Simulator();
    	sim1.init(context);
    	
		
	}

 @Override
	public String takeDecision() {
    	return sim1.simul();
    	
    	
		
	}

    @Override
	public void acknowledgeResults(String results) {
		
    	sim1.simul2(results);
	}

}