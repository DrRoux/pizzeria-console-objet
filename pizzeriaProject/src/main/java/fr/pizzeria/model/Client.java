/**
 * 
 */
package fr.pizzeria.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author BIRABEN-BIANCHI Hugo
 */
@Entity
@Table(name = "client")
public class Client extends Personne
{
	@Column
	private String email;
	@Column(name = "mot_de_passe")
	private String motDePasse;

	@OneToMany(mappedBy = "client_id")
	private List<Commande> commandesClient;

	public String afficherClient()
	{
		return ("Nom : " + nom + " Prénom : " + prenom);
	}

	@Override
	public String toString()
	{
		return (nom + " " + prenom + " - " + email);
	}

	public Client()
	{
		commandesClient = new ArrayList<>();
	}

	public Client(String nom, String prenom, String email, String mot_de_passe)
	{
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motDePasse = mot_de_passe;
	}

	public Client(int id, String nom, String prenom, String email, String mot_de_passe)
	{
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motDePasse = mot_de_passe;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getMotDePasse()
	{
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse)
	{
		this.motDePasse = motDePasse;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		return Objects.hash(commandesClient, email, motDePasse);
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
		Client other = (Client) obj;
		return Objects.equals(commandesClient, other.commandesClient) && Objects.equals(email, other.email)
				&& Objects.equals(motDePasse, other.motDePasse);
	}
}
