package com.example.usersio.gsbcm.help_bdd;

public class Achat {
	private double montant=0;
	private long idClient;
	
	public Achat(long idClient, double montant) {
		super();
		this.montant = montant;
		this.idClient = idClient;
	}
	public double getMontant() {
		return montant;
	}
	public long getIdClient() {
		return idClient;
	}
}
