package edu.univas.si7.prova.elevador;

public class Chromossome  implements Comparable<Chromossome>{
	
	private int andar;
	
	public Chromossome(int andar) {
		this.andar = andar;
	}

	public int getAndar() {
		return andar;
	}

	public void setAndar(int roth) {
		this.andar = roth;
	}

	@Override
	public int compareTo(Chromossome o) {
		if(andar == o.andar) {
			return 0;
		} else if(andar < o.andar){
			return -1;
		} else {
			return 1;
		}
	}
	
	@Override
	public String toString() {
		return "" + andar;
	}
	
}
