/**
 * 
 */
package fr.pizzeria.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.Table;

import fr.pizzeria.logger.ILogger;

/**
 *
 * @author BIRABEN-BIANCHI Hugo
 */
@Entity
@Table(name = "commande")
@NamedEntityGraph(name = "graph.Commande.listComPiz", attributeNodes = @NamedAttributeNode("listComPiz"))
public class Commande implements ILogger
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private int numero_commande;
	@Column
	private int status;
	@Column
	private LocalDateTime date_commande;
	@ManyToOne
	@JoinColumn(name = "livreur_id")
	private Livreur livreur_id;
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client_id;

	@ManyToMany
	@JoinTable(name = "commande_pizza", joinColumns = @JoinColumn(name = "commande_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "pizza_id", referencedColumnName = "id"))
	private List<Pizza> listComPiz = new ArrayList<>();

	public Commande()
	{
		numero_commande = id;
		status = 0;
		date_commande = LocalDateTime.now();
	}

	public Commande(int numero_commande, int statut, LocalDateTime date_commande, Livreur livreur_id, Client client_id)
	{
		super();
		this.numero_commande = numero_commande;
		this.status = statut;
		this.date_commande = date_commande;
		this.livreur_id = livreur_id;
		this.client_id = client_id;
	}

	public Commande(int id, int numero_commande, int statut, LocalDateTime date_commande, Livreur livreur_id,
			Client client_id)
	{
		super();
		this.id = id;
		this.numero_commande = numero_commande;
		this.status = statut;
		this.date_commande = date_commande;
		this.livreur_id = livreur_id;
		this.client_id = client_id;
	}

	/**
	 * Affiche toutes les commandes d'un client avec le détail de sa commande
	 * (toutes les pizzas dans chaque commande)
	 */
	public void afficherCommandesClient()
	{
		for (Pizza p : listComPiz)
		{
			System.out.println(date_commande + " - " + client_id + " : " + p);
		}
		System.out.println("---------------------------------------------------------");
	}

	public void afficherListeAttente()
	{
		String livreur = livreur_id == null ? "Pas de livreur associé" : livreur_id.stringComplet();
		System.out.println(id + " " + date_commande + " - " + client_id.afficherClient() + " - " + livreur);
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
	 * @return the numero_commande
	 */
	public int getNumero_commande()
	{
		return numero_commande;
	}

	/**
	 * Setter
	 * 
	 * @param numero_commande the numero_commande to set
	 */
	public void setNumero_commande(int numero_commande)
	{
		this.numero_commande = numero_commande;
	}

	/**
	 * Getter
	 * 
	 * @return the statut
	 */
	public int getStatut()
	{
		return status;
	}

	/**
	 * Setter
	 * 
	 * @param statut the statut to set
	 */
	public void setStatut(int statut)
	{
		this.status = statut;
	}

	/**
	 * Getter
	 * 
	 * @return the date_commande
	 */
	public LocalDateTime getDate_commande()
	{
		return date_commande;
	}

	/**
	 * Setter
	 * 
	 * @param date_commande the date_commande to set
	 */
	public void setDate_commande(LocalDateTime date_commande)
	{
		this.date_commande = date_commande;
	}

	/**
	 * Getter
	 * 
	 * @return the livreur_id
	 */
	public Livreur getLivreur_id()
	{
		return livreur_id;
	}

	/**
	 * Setter
	 * 
	 * @param livreur_id the livreur_id to set
	 */
	public void setLivreur_id(Livreur livreur_id)
	{
		this.livreur_id = livreur_id;
	}

	/**
	 * Getter
	 * 
	 * @return the client_id
	 */
	public Client getClient_id()
	{
		return client_id;
	}

	/**
	 * Setter
	 * 
	 * @param client_id the client_id to set
	 */
	public void setClient_id(Client client_id)
	{
		this.client_id = client_id;
	}

	/**
	 * Getter
	 * 
	 * @return the status
	 */
	public int getStatus()
	{
		return status;
	}

	/**
	 * Setter
	 * 
	 * @param status the status to set
	 */
	public void setStatus(int status)
	{
		this.status = status;
	}

	/**
	 * Getter
	 * 
	 * @return the listComPiz
	 */
	public List<Pizza> getListComPiz()
	{
		return listComPiz;
	}

	public void setListComPiz(List<Pizza> pizza)
	{
		this.listComPiz = pizza;
	}

	public void setListComPiz(Pizza pizza)
	{
		this.listComPiz.add(pizza);
	}

	/**
	 * @param l
	 */
	public void setLivreur(Livreur l)
	{
		this.livreur_id = l;
	}
}
