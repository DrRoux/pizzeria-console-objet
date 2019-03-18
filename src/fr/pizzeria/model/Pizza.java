package fr.pizzeria.model;

import java.util.Scanner;

public class Pizza 
{
	static int nbPizza = 0;
	int id;
	String code;
	String libelle;
	double prix;
	
	public Pizza () 
	{
		super ();
		this.id = nbPizza;
		nbPizza++;
	}
	
	public Pizza (String code, String libelle, double prix) 
	{
		super();
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		
		this.id = nbPizza;
		nbPizza++;
	}
	
	public Pizza (int id, String code, String libelle, double prix) 
	{
		super();
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
	}
	
	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getCode() 
	{
		return code;
	}

	public void setCode(String code) 
	{
		this.code = code;
	}

	public String getLibelle() 
	{
		return libelle;
	}

	public void setLibelle(String libelle) 
	{
		this.libelle = libelle;
	}

	public double getPrix() 
	{
		return prix;
	}

	public void setPrix(double prix) 
	{
		this.prix = prix;
	}
	
	public void affichage ()
	{
		System.out.println(code + " -> " + libelle + " (" + prix + " €) ");
	}
	
	public void modifPizza ()
	{
		Scanner questionUser = new Scanner (System.in);
		
		System.out.println("Veuillez saisir le code :");
		String choiceString = questionUser.nextLine();
		setCode (choiceString);
		
		System.out.println("Veuillez saisir le nom (sans espace):");
		choiceString = questionUser.nextLine();
		setLibelle (choiceString);
		
		System.out.println("Veuillez saisir le prix :");
		double choicePrice = questionUser.nextDouble();
		setPrix (choicePrice);
		
	}
}
