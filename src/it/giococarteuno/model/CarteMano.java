package it.giococarteuno.model;

import java.util.ArrayList;

public class CarteMano {
	
	private ArrayList<Carta> carteMano = new ArrayList<Carta>();
	private Utente giocatore;
	
	
	public CarteMano() {
		// TODO Auto-generated constructor stub
	}

	public CarteMano(ArrayList<Carta> carteMano) {
		super();
		this.carteMano = carteMano;
	}

	public ArrayList<Carta> getCarteMano() {
		return carteMano;
	}

	public void setCarteMano(ArrayList<Carta> carteMano) {
		this.carteMano = carteMano;
	}
	
	

}
