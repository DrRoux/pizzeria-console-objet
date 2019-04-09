/**
 * 
 */
package fr.pizzeria.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author BIRABEN-BIANCHI Hugo
 */
@Entity
@Table(name = "livreur")
public class Livreur extends Personne
{
	@OneToMany(mappedBy = "livreur_id")
	private List<Commande> commandesLivreur;

	public Livreur()
	{
		commandesLivreur = new ArrayList<>();
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		return Objects.hash(commandesLivreur);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (!super.equals(obj))
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		Livreur other = (Livreur) obj;
		return Objects.equals(commandesLivreur, other.commandesLivreur);
	}
}
