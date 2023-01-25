package it.giococarteuno.model;

import java.util.ArrayList;

public class Mazzo {

	private ArrayList<Carta> mazzo = new ArrayList<Carta>(108);
	
	public Mazzo() {
		// TODO Auto-generated constructor stub
	}

	public Mazzo(ArrayList<Carta> mazzo) {
		super();
		this.setMazzo(mazzo);
	}

	public ArrayList<Carta> getMazzo() {
		return mazzo;
	}

	public void setMazzo(ArrayList<Carta> mazzo) {
		this.mazzo = mazzo;
	}
	
	
	
}
