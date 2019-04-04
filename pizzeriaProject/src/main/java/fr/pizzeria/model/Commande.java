/**
 * 
 */
package fr.pizzeria.model;

import java.time.LocalDateTime;

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
@Table (name="commande")
public class Commande
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private int numero_commande;
	@Column
	private int statut;
	@Column
	private LocalDateTime date_commande;
	@Column
	private int livreur_id;
	@Column
	private int client_id;
	
	public Commande ()
	{
	}
	
	public Commande(int numero_commande, int statut, LocalDateTime date_commande, int livreur_id, int client_id)
	{
		super();
		this.numero_commande = numero_commande;
		this.statut = statut;
		this.date_commande = date_commande;
		this.livreur_id = livreur_id;
		this.client_id = client_id;
	}
	
	public Commande(int id, int numero_commande, int statut, LocalDateTime date_commande, int livreur_id, int client_id)
	{
		super();
		this.id = id;
		this.numero_commande = numero_commande;
		this.statut = statut;
		this.date_commande = date_commande;
		this.livreur_id = livreur_id;
		this.client_id = client_id;
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
	 * @return the numero_commande
	 */
	public int getNumero_commande()
	{
		return numero_commande;
	}
	
	/**
	 * Setter
	 * @param numero_commande the numero_commande to set
	 */
	public void setNumero_commande(int numero_commande)
	{
		this.numero_commande = numero_commande;
	}
	
	/**
	 * Getter
	 * @return the statut
	 */
	public int getStatut()
	{
		return statut;
	}
	
	/**
	 * Setter
	 * @param statut the statut to set
	 */
	public void setStatut(int statut)
	{
		this.statut = statut;
	}
	
	/**
	 * Getter
	 * @return the date_commande
	 */
	public LocalDateTime getDate_commande()
	{
		return date_commande;
	}
	
	/**
	 * Setter
	 * @param date_commande the date_commande to set
	 */
	public void setDate_commande(LocalDateTime date_commande)
	{
		this.date_commande = date_commande;
	}
	
	/**
	 * Getter
	 * @return the livreur_id
	 */
	public int getLivreur_id()
	{
		return livreur_id;
	}
	
	/**
	 * Setter
	 * @param livreur_id the livreur_id to set
	 */
	public void setLivreur_id(int livreur_id)
	{
		this.livreur_id = livreur_id;
	}
	
	/**
	 * Getter
	 * @return the client_id
	 */
	public int getClient_id()
	{
		return client_id;
	}
	
	/**
	 * Setter
	 * @param client_id the client_id to set
	 */
	public void setClient_id(int client_id)
	{
		this.client_id = client_id;
	}
}
