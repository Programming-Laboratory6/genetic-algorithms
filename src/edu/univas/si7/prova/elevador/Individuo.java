package edu.univas.si7.prova.elevador;

import java.util.ArrayList;
import java.util.Collections;

public class Individuo{
	
	ArrayList<Chromossome> chromossome;
	ArrayList<Chromossome> chrPar;
	ArrayList<Chromossome> chrImpares;
	int totalTimePar = 0;
	int totalTimeimpar = 0;
	
	public Individuo() {
		chromossome = new ArrayList<Chromossome>();
		
		chromossome.add(new Chromossome(43));
		chromossome.add(new Chromossome(46));
		chromossome.add(new Chromossome(48));
		chromossome.add(new Chromossome(21));
		chromossome.add(new Chromossome(15));
		chromossome.add(new Chromossome(24));
		chromossome.add(new Chromossome(23));
		chromossome.add(new Chromossome(45));
		chromossome.add(new Chromossome(19));
		chromossome.add(new Chromossome(40));
		chromossome.add(new Chromossome(44));
		chromossome.add(new Chromossome(16));
		chromossome.add(new Chromossome(2));
		chromossome.add(new Chromossome(39));
		chromossome.add(new Chromossome(22));
		chromossome.add(new Chromossome(7));
		
		Collections.shuffle(chromossome);
		getPares();
		getImpares();
		Collections.sort(chrImpares);
		Collections.sort(chrPar);
		
		calculeTotalTime();
	}
	
	public ArrayList<Chromossome> getPares(){
		chrPar = new ArrayList<Chromossome>();
		for(int i=0; i<chromossome.size(); i++){
			if(chromossome.get(i).getAndar() % 2 == 0)
				chrPar.add(chromossome.get(i));
		}
		return chrPar;
	}
	
	public ArrayList<Chromossome> getImpares(){
		chrImpares = new ArrayList<Chromossome>();
		for(int i=0; i<chromossome.size(); i++){
			if(chromossome.get(i).getAndar() % 2 == 1)
				chrImpares.add(chromossome.get(i));
		}
		return chrImpares;
	}
	
	public void calculeTotalTime(){
		
		for(int i = 0; i<chrImpares.size(); i++){
			totalTimeimpar+=3;
			if(chrImpares.get(i).getAndar() == i){
				totalTimeimpar+=10;
			}
		}
		
		for(int i = 0; i<chrPar.size(); i++){
			totalTimePar+=3;
			if(chrPar.get(i).getAndar() == i){
				totalTimePar+=10;
			}
		}
	}
	
	@Override
	public String toString() {
		return "Andares impares: " + chrImpares + " Total de tempo Impar: " + totalTimeimpar + "\n" + 
			   "Andares pares: " + chrPar + " Total de tempo par: " + totalTimePar;
	}

	
}
