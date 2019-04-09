package fr.pizzeria.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.utils.ToString;

/**
 * Cette classe représente une Pizza
 * 
 * @author BIRABEN-BIANCHI Hugo
 */
@Entity
@Table(name = "pizza")
@NamedEntityGraph(name = "graph.Pizza.listComPiz", attributeNodes = @NamedAttributeNode("listComPiz"))
public class Pizza
{
	@Transient
	static Logger logger = LoggerFactory.getLogger(Pizza.class);

	/** id : int */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/** code : String */
	@ToString(upperCase = true, separateurAp = " - ")
	@Column
	private String code;

	/** libelle : String */
	@ToString(upperCase = true)
	@Column(name = "nom_pizza")
	private String libelle;

	/** prix : double */
	@ToString(separateurAv = " -> (", separateurAp = " €)", upperCase = true)
	@Column
	private double prix;

	/** cP : CategoriePizza */
	@Column(name = "categorie")
	@Enumerated(EnumType.STRING)
	private CategoriePizza cP;

	@ManyToMany(mappedBy = "listComPiz")
	private List<Commande> listComPiz = new ArrayList<>();

	public void afficherPizza()
	{
		String affichePizza = code + " -> " + libelle + " (" + prix + " €) - " + cP.getNom().toUpperCase();
		logger.info(affichePizza);
	}

	/**
	 * Default Constructor
	 */
	public Pizza()
	{
		super();
		cP = CategoriePizza.INCONNU;
	}

	/**
	 * Constructor
	 * 
	 * @param code    : code en majuscule en maximum 4 lettres
	 * @param libelle : nom de la pizza
	 * @param prix    : prix en €
	 */
	public Pizza(String code, String libelle, double prix)
	{
		super();
		this.code = code.toUpperCase();
		this.libelle = libelle;
		this.prix = prix;
		cP = CategoriePizza.INCONNU;
	}

	public Pizza(String code, String libelle, double prix, CategoriePizza cP)
	{
		super();
		this.code = code.toUpperCase();
		this.libelle = libelle;
		this.prix = prix;
		this.cP = cP;
	}

	public Pizza(String code, String libelle, double prix, String cP)
	{
		super();
		this.code = code.toUpperCase();
		this.libelle = libelle;
		this.prix = prix;
		this.cP = CategoriePizza.valueOf(cP.toUpperCase());
	}

	/**
	 * Constructor
	 * 
	 * @param id      : id
	 * @param code    : code en majuscule en maximum 4 lettres
	 * @param libelle : nom de la pizza
	 * @param prix    : prix en €
	 */
	public Pizza(int id, String code, String libelle, double prix)
	{
		super();
		this.id = id;
		this.code = code.toUpperCase();
		this.libelle = libelle;
		this.prix = prix;
		cP = CategoriePizza.INCONNU;
	}

	/**
	 * Constructor
	 * 
	 * @param id      : id
	 * @param code    : code en majuscule en maximum 4 lettres
	 * @param libelle : nom de la pizza
	 * @param prix    : prix en €
	 */
	public Pizza(int id, String code, String libelle, double prix, CategoriePizza cP)
	{
		super();
		this.id = id;
		this.code = code.toUpperCase();
		this.libelle = libelle;
		this.prix = prix;
		this.cP = cP;
	}

	public Pizza(int id, String code, String libelle, double prix, String cP)
	{
		super();
		this.id = id;
		this.code = code.toUpperCase();
		this.libelle = libelle;
		this.prix = prix;
		this.cP = CategoriePizza.valueOf(cP.toUpperCase());
	}

	/**
	 * Fonction permettant de modifier une pizza
	 * 
	 * @param pizza
	 */
	public void modifPizza(Pizza pizza)
	{
		setCode(pizza.getCode());
		setLibelle(pizza.getLibelle());
		setPrix(pizza.getPrix());
		setcP(pizza.getcP());
	}

	/**
	 * Surcharge de la méthode toString de Object afin de pouvoir afficher l'objet
	 * Pizza normalement.
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return (code + " -> " + libelle + " (" + prix + " €) - " + cP.getNom().toUpperCase());
	}

	/**
	 * Fonction permettant un formatage particulier afin de l'enregistrer dans un
	 * fichier .txt pour la persistance des données.
	 * 
	 * @return
	 */
	public String toSave()
	{
		return (id + "," + code + "," + libelle + "," + prix + "," + cP.getNom().toUpperCase());
	}

	/**
	 * Getter
	 * 
	 * @return the id
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * Setter
	 * 
	 * @param id the id to set
	 */
	public void setId(int id)
	{
		this.id = id;
	}

	/**
	 * Getter
	 * 
	 * @return the code
	 */
	public String getCode()
	{
		return code;
	}

	/**
	 * Setter
	 * 
	 * @param code the code to set
	 */
	public void setCode(String code)
	{
		this.code = code;
	}

	/**
	 * Getter
	 * 
	 * @return the libelle
	 */
	public String getLibelle()
	{
		return libelle;
	}

	/**
	 * Setter
	 * 
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle)
	{
		this.libelle = libelle;
	}

	/**
	 * Getter
	 * 
	 * @return the prix
	 */
	public double getPrix()
	{
		return prix;
	}

	/**
	 * Setter
	 * 
	 * @param prix the prix to set
	 */
	public void setPrix(double prix)
	{
		this.prix = prix;
	}

	public CategoriePizza getcP()
	{
		return cP;
	}

	public void setcP(CategoriePizza cP)
	{
		this.cP = cP;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(cP, code, libelle, listComPiz, prix);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		Pizza other = (Pizza) obj;
		return cP == other.cP && Objects.equals(code, other.code) && Objects.equals(libelle, other.libelle)
				&& Objects.equals(listComPiz, other.listComPiz)
				&& Double.doubleToLongBits(prix) == Double.doubleToLongBits(other.prix);
	}

}
