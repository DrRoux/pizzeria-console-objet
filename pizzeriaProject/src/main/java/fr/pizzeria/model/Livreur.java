/**
 * 
 */
package fr.pizzeria.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author BIRABEN-BIANCHI Hugo
 */
@Entity
@Table (name="livreur")
public class Livreur extends Personne
{
	@OneToMany (mappedBy = "livreur_id")
	private List<Commande> commandesLivreur;
	
	public Livreur ()
	{
		commandesLivreur = new ArrayList <Commande> ();
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

	public String stringComplet()
	{
		return ("Id : " + id + " - " + nom + " " + prenom + "\n");
	}
}
