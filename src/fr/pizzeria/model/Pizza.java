package fr.pizzeria.model;

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
		this.code = code.toUpperCase();
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
		this.code = code.toUpperCase();
		this.libelle = libelle;
		this.prix = prix;
	}
	
	/**
	 * Fonction permettant de modifier une pizza
	 * @param pizza
	 */
	public void modifPizza (Pizza pizza)
	{
		setCode (pizza.getCode());
		setLibelle (pizza.getLibelle());
		setPrix (pizza.getPrix());
	}
	
	
	/**
	 * Surcharge de la méthode toString de Object
	 * afin de pouvoir afficher l'objet Pizza normalement.
	 * @see java.lang.Object#toString()
	 */
	public String toString ()
	{
		return (code + " -> " + libelle + " (" + prix + " €) ");
	}
	
	/**
	 * Fonction permettant un formatage particulier afin de l'enregistrer
	 * dans un fichier .txt pour la persistance des données.
	 * @return
	 */
	public String toSave ()
	{
		return (id + "," + code + "," + libelle + "," + prix);
	}

	/**
	 * Getter
	 * @return the id
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * Setter
	 * @param id the id to set
	 */
	public void setId(int id)
	{
		this.id = id;
	}

	/**
	 * Getter
	 * @return the code
	 */
	public String getCode()
	{
		return code;
	}

	/**
	 * Setter
	 * @param code the code to set
	 */
	public void setCode(String code)
	{
		this.code = code;
	}

	/**
	 * Getter
	 * @return the libelle
	 */
	public String getLibelle()
	{
		return libelle;
	}

	/**
	 * Setter
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle)
	{
		this.libelle = libelle;
	}

	/**
	 * Getter
	 * @return the prix
	 */
	public double getPrix()
	{
		return prix;
	}

	/**
	 * Setter
	 * @param prix the prix to set
	 */
	public void setPrix(double prix)
	{
		this.prix = prix;
	}

	/**
	 * Getter
	 * @return the nbPizza
	 */
	public static int getNbPizza()
	{
		return nbPizza;
	}

	/**
	 * @param nbPizza2
	 */
	public static void setNbPizza(int nbPizza)
	{
		Pizza.nbPizza = nbPizza;
		
	}

}
