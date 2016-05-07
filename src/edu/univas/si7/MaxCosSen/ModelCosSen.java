package edu.univas.si7.MaxCosSen;

import edu.univas.si7.ag.AGModel;
import edu.univas.si7.ag.Individual;

public class ModelCosSen extends AGModel {

	@Override
	public Individual createIndividual() {
		return new CosSenIndividual();
	}

}
