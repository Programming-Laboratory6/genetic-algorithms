package edu.univas.si7.MaxCosSen;

import java.util.ArrayList;

import edu.univas.si7.ag.Chromossome;
import edu.univas.si7.ag.Individual;

public class CosSenIndividual extends Individual {

	private float senX = 0;
	private float cosY = 0;	
	
	private static final int BITS = 40; 
	private static final float MIN = 0; 
	private static final float MAX = (float) (Math.PI * 2);
	
	private ArrayList<Chromossome> chromossomesCosY = null;
	private ArrayList<Chromossome> chromossomesSenX = null;
	

	public CosSenIndividual() {
		chromossomes = 
				new ArrayList<Chromossome>();

		for(int i = 0; i < BITS; i++) {
			chromossomes.add(new CosSenChromossome((int) Math.round(Math.random())));
		}
		
		breakChromossomes();
	}
	
	private void breakChromossomes() {
		chromossomesCosY = new ArrayList<Chromossome>();
		chromossomesSenX = new ArrayList<Chromossome>();
		
		for(int i=0; i < BITS; i++){
			if(i < BITS/2 )
				chromossomesCosY.add(chromossomes.get(i));
			
			else
				chromossomesSenX.add(chromossomes.get(i));
		}
	}

	@Override
	public int compareTo(Individual obj) {
		if(value == obj.getValue()) {
			return 0;
		} else if(value < obj.getValue()){
			return 1;
		} else {
			return -1;
		}
	}

	@Override
	public float calculateValue() {
		float valueCosY = 0;
		float valueSenX = 0;
		
		StringBuilder srtCosY = new StringBuilder();
		StringBuilder srtSenX = new StringBuilder();
		
		//COS
		for(int i = 0; i < (BITS/2); i++) {
			CosSenChromossome c = (CosSenChromossome) chromossomes.get(i);
			srtCosY.append(c.getBit());
		}
			
		//SEN
		for(int i = BITS/2; i < BITS; i++) {
			CosSenChromossome s = (CosSenChromossome) chromossomes.get(i);
			srtSenX.append(s.getBit());
		}
		
		int xBits = Integer.parseInt(srtSenX.toString(), 2);
		int yBits = Integer.parseInt(srtCosY.toString(), 2);
		
		senX = (float) ((xBits * (MAX - MIN)) / 
				(Math.pow(2, (BITS/2)) - 1) + MIN);
		
		cosY = (float) ((yBits * (MAX - MIN)) / 
				(Math.pow(2, (BITS/2)) - 1) + MIN);
		
		valueSenX = (float) Math.sin(senX);
		valueCosY = (float) Math.cos(cosY);
		
		value = valueSenX + valueCosY;
		
		return valueCosY + valueSenX;
		
	}

	@Override
	public String toString() {
		return super.toString() + " ValorX: " + senX + " ValorY: " + cosY;
	}
}
