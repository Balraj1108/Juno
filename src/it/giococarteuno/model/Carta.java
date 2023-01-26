package it.giococarteuno.model;

public class Carta {
	
	
	private Colore colore;
	private Valore valore;
	
	public Carta() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Carta(Colore colore, Valore valore) {
		super();
		this.colore = colore;
		this.valore = valore;
	}
	


	public Carta(Colore colore) {
		super();
		this.colore = colore;
	}


	public Carta(Valore valore) {
		super();
		this.valore = valore;
	}


	public Colore getColore() {
		return colore;
	}
	public void setColore(Colore colore) {
		this.colore = colore;
	}
	
	public Valore getValore() {
		return valore;
	}
	public void setValore(Valore valore) {
		this.valore = valore;
	}


	@Override
	public String toString() {
		return ""+valore + colore;
	}
	
	

}
