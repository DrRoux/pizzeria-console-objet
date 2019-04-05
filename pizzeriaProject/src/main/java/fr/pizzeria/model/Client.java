/**
 * 
 */
package fr.pizzeria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author BIRABEN-BIANCHI Hugo
 */
@Entity
@Table (name="client")
public class Client
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String nom;
	@Column
	private String prenom;
	@Column
	private String email;
	@Column
	private String mot_de_passe;
	
	public String toString ()
	{
		return (id + " : " + nom + " : " + prenom + " - " + email + "");
	}
	
	public Client ()
	{
		
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
	
	public int getId()
	{
		System.out.println("ici");
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getNom()
	{
		return nom;
	}
	
	public void setNom(String nom)
	{
		this.nom = nom;
	}
	
	public String getPrenom()
	{
		return prenom;
	}
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
	
}
