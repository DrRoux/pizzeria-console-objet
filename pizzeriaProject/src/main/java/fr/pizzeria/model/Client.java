/**
 * 
 */
package fr.pizzeria.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author BIRABEN-BIANCHI Hugo
 */
@Entity
@Table (name="client")
public class Client extends Personne
{
	@Column
	private String email;
	@Column
	private String mot_de_passe;
	
	@OneToMany (mappedBy = "client_id")
	private List<Commande> commandesClient;
	
	@Override
	public String toString ()
	{
		return (nom + " " + prenom + " - " + email);
	}
	
	public Client ()
	{
		commandesClient = new ArrayList <Commande> ();
	}
	
	public Client(String nom, String prenom, String email, String mot_de_passe)
	{
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mot_de_passe = mot_de_passe;
	}
	
	public Client(int id, String nom, String prenom, String email, String mot_de_passe)
	{
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mot_de_passe = mot_de_passe;
	}
	
	@Override
	public int getId()
	{
		return id;
	}
	
	@Override
	public void setId(int id)
	{
		this.id = id;
	}
	
	@Override
	public String getNom()
	{
		return nom;
	}
	
	@Override
	public void setNom(String nom)
	{
		this.nom = nom;
	}
	
	@Override
	public String getPrenom()
	{
		return prenom;
	}
	@Override
	public void setPrenom(String prenom)
	{
		this.prenom = prenom;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getMot_de_passe()
	{
		return mot_de_passe;
	}
	
	public void setMot_de_passe(String mot_de_passe)
	{
		this.mot_de_passe = mot_de_passe;
	}

	public String afficherClient()
	{
		return (nom + " " + prenom);
	}
	
}
