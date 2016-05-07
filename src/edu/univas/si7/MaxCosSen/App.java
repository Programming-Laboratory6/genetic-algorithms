package edu.univas.si7.MaxCosSen;

import edu.univas.si7.ag.AGFramework;
import edu.univas.si7.ag.AGModel.CrossType;
import edu.univas.si7.ag.AGModel.MutationType;

public class App {

	public static void main(String[] args) {
		
		ModelCosSen model = new ModelCosSen();
		model.setPopulationSize(25);
		model.setGenerationQuantity(5000);
		model.setCrossType(CrossType.Binary);
		model.setMutationType(MutationType.Binary);
		
		AGFramework framework = new AGFramework(model);
		
		framework.execute();
	}
}
