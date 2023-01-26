package it.giococarteuno.model;

import java.util.ArrayList;

public class Utente {
	
	private Long id;
	private String nickname;
	private Integer partiteGiocate;
	private Integer partiteVinte;
	private Integer partitePerse;
	private Integer livello;
	private ArrayList<Carta> carteMano = new ArrayList<Carta>();
	
	public Utente() {
		// TODO Auto-generated constructor stub
	}

	public Utente(Long id, String nickname, Integer partiteGiocate, Integer partiteVinte, Integer partitePerse,
			Integer livello) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.partiteGiocate = partiteGiocate;
		this.partiteVinte = partiteVinte;
		this.partitePerse = partitePerse;
		this.livello = livello;
	}
	
	

	public Utente(String nickname, Integer partiteGiocate, Integer partiteVinte, Integer partitePerse,
			Integer livello) {
		super();
		this.nickname = nickname;
		this.partiteGiocate = partiteGiocate;
		this.partiteVinte = partiteVinte;
		this.partitePerse = partitePerse;
		this.livello = livello;
	}
	
	

	public Utente(Long id, String nickname, Integer partiteGiocate, Integer partiteVinte, Integer partitePerse,
			Integer livello, ArrayList<Carta> carteMano) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.partiteGiocate = partiteGiocate;
		this.partiteVinte = partiteVinte;
		this.partitePerse = partitePerse;
		this.livello = livello;
		this.carteMano = carteMano;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getPartiteGiocate() {
		return partiteGiocate;
	}

	public void setPartiteGiocate(Integer partiteGiocate) {
		this.partiteGiocate = partiteGiocate;
	}

	public Integer getPartiteVinte() {
		return partiteVinte;
	}

	public void setPartiteVinte(Integer partiteVinte) {
		this.partiteVinte = partiteVinte;
	}

	public Integer getPartitePerse() {
		return partitePerse;
	}

	public void setPartitePerse(Integer partitePerse) {
		this.partitePerse = partitePerse;
	}

	public Integer getLivello() {
		return livello;
	}

	public void setLivello(Integer livello) {
		this.livello = livello;
	}
	
	

	public ArrayList<Carta> getCarteMano() {
		return carteMano;
	}

	public void setCarteMano(ArrayList<Carta> carteMano) {
		this.carteMano = carteMano;
	}

	@Override
	public String toString() {
		return "Utente [id=" + id + ", nickname=" + nickname + ", partiteGiocate=" + partiteGiocate + ", partiteVinte="
				+ partiteVinte + ", partitePerse=" + partitePerse + ", livello=" + livello + "]";
	}
	
	
	
	

}
