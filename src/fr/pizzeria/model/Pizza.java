package fr.pizzeria.model;

public class Pizza 
{
	static int id = 0;
	String code;
	String libelle;
	double prix;
	
	public Pizza (String code, String libelle, double prix) {
		super();
		Pizza.id++;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
	}
	
	public Pizza (int id, String code, String libelle, double prix) {
		super();
		Pizza.id = id;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
	}
}
