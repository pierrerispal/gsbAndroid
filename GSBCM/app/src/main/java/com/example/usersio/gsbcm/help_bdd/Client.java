package com.example.usersio.gsbcm.help_bdd;

public class Client {

	private long id = 0;
	private String nom;
	private String tel;
	
	public Client(String nom, String tel) {
		this.nom = nom;
		this.tel = tel;
	}
	public String getNom() {
		return nom;
	}
	public String getTel(){
		return tel;
	}
	public long getId() {
		return id;
	}
	public String toString(){
		return nom+" "+tel;
	}
}
