/**
 * 
 */
package fr.pizzeria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author BIRABEN-BIANCHI Hugo
 */
@Entity
@Table (name="livreur")
public class Livreur
{
	@Id
	private int id;
	@Column
	private String nom;
	@Column
	private String prenom;
	
	public Livreur ()
	{
	}
	
	public Livreur(String nom, String prenom)
	{
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public Livreur(int id, String nom, String prenom)
	{
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
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
	 * @return the nom
	 */
	public String getNom()
	{
		return nom;
	}

	/**
	 * Setter
	 * @param nom the nom to set
	 */
	public void setNom(String nom)
	{
		this.nom = nom;
	}

	/**
	 * Getter
	 * @return the prenom
	 */
	public String getPrenom()
	{
		return prenom;
	}

	/**
	 * Setter
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom)
	{
		this.prenom = prenom;
	}
	
	
}
