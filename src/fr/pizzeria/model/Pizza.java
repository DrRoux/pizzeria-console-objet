package fr.pizzeria.model;

import java.util.Scanner;

/**
 * Cette classe représente une Pizza
 * @author BIRABEN-BIANCHI Hugo
 */
public class Pizza 
{
	/** nbPizza : static int */
	private static int nbPizza = 0;
	/** id : int */
	private int id;
	/** code : String */
	private String code;
	/** libelle : String */
	private String libelle;
	/** prix : double */
	private double prix;
	
	
	/**
	 * Default Constructor
	 */
	public Pizza () 
	{
		super ();
		this.id = nbPizza;
		nbPizza++;
	}
	
	/** 
	 * Constructor
	 * @param code : code en majuscule en maximum 4 lettres
	 * @param libelle : nom de la pizza
	 * @param prix : prix en €
	 */
	public Pizza (String code, String libelle, double prix) 
	{
		super();
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		
		this.id = nbPizza;
		nbPizza++;
	}
	
	/**
	 * Constructor
	 * @param id : id
	 * @param code : code en majuscule en maximum 4 lettres
	 * @param libelle : nom de la pizza
	 * @param prix : prix en €
	 */
	public Pizza (int id, String code, String libelle, double prix) 
	{
		super();
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
	}
	
	public void modifPizza ()
	{
		Scanner questionUser = new Scanner (System.in);
		
		System.out.println("Veuillez saisir le code :");
		String choiceString = questionUser.nextLine();
		setCode (choiceString.toUpperCase());
		
		System.out.println("Veuillez saisir le nom (sans espace):");
		choiceString = questionUser.nextLine();
		setLibelle (choiceString);
		
		System.out.println("Veuillez saisir le prix :");
		choiceString = questionUser.nextLine();
		double choicePrice = Double.parseDouble(choiceString);
		setPrix (choicePrice);
		
		questionUser.close ();
	}
	
	public String toString ()
	{
		return (code + " -> " + libelle + " (" + prix + " €) ");
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
	
	/*
	 * Suppression de la méthode affichage au profit de toString
	public void affichage ()
	{
		System.out.println(code + " -> " + libelle + " (" + prix + " €) ");
	}
	*/
}
