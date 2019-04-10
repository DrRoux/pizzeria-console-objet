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
import javax.persistence.Transient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author BIRABEN-BIANCHI Hugo
 */
@Entity
@Table(name = "commande")
@NamedEntityGraph(name = "graph.Commande.listComPiz", attributeNodes = @NamedAttributeNode("listComPiz"))
public class Commande
{
	@Transient
	static Logger logger = LoggerFactory.getLogger(Commande.class);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "numero_commande")
	private int numeroCommande;
	@Column
	private int status;
	@Column(name = "date_commande")
	private LocalDateTime dateCommande;
	@ManyToOne
	@JoinColumn(name = "livreur_id")
	private Livreur livreurId;
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client clientId;

	@ManyToMany
	@JoinTable(name = "commande_pizza", joinColumns = @JoinColumn(name = "commande_id", referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn(name = "pizza_id", referencedColumnName = "id"))
	private List<Pizza> listComPiz = new ArrayList<>();

	public Commande()
	{
		numeroCommande = id;
		status = 0;
		dateCommande = LocalDateTime.now();
	}

	public Commande(int numeroCommande, int statut, LocalDateTime dateCommande, Livreur livreurId, Client clientId)
	{
		super();
		this.numeroCommande = numeroCommande;
		this.status = statut;
		this.dateCommande = dateCommande;
		this.livreurId = livreurId;
		this.clientId = clientId;
	}

	public Commande(int id, int numeroCommande, int statut, LocalDateTime dateCommande, Livreur livreurId,
			Client clientId)
	{
		super();
		this.id = id;
		this.numeroCommande = numeroCommande;
		this.status = statut;
		this.dateCommande = dateCommande;
		this.livreurId = livreurId;
		this.clientId = clientId;
	}

	/**
	 * Affiche toutes les commandes d'un client avec le détail de sa commande
	 * (toutes les pizzas dans chaque commande)
	 */
	public void afficherCommandesClient()
	{
		StringBuilder stringBuilder = new StringBuilder ();
		for (Pizza p : listComPiz)
		{
			stringBuilder.append(dateCommande).append(" - ").append(clientId).append(" : ").append(p);
			String string = stringBuilder.toString();
			logger.info(string);
			stringBuilder.setLength(0);
		}
		logger.info("---------------------------------------------------------");
	}

	public void afficherListeAttente()
	{
		String livreur = livreurId == null ? "Pas de livreur associé" : livreurId.stringComplet();
		String inInfo = " " + id + " " + dateCommande + " - " + clientId.afficherClient() + " - " + livreur;
		logger.info(inInfo);
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
	public int getNumeroCommande()
	{
		return numeroCommande;
	}

	/**
	 * Setter
	 * 
	 * @param numero_commande the numero_commande to set
	 */
	public void setNumeroCommande(int numeroCommande)
	{
		this.numeroCommande = numeroCommande;
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
	public LocalDateTime getDateCommande()
	{
		return dateCommande;
	}

	/**
	 * Setter
	 * 
	 * @param date_commande the date_commande to set
	 */
	public void setDateCommande(LocalDateTime dateCommande)
	{
		this.dateCommande = dateCommande;
	}

	/**
	 * Getter
	 * 
	 * @return the livreur_id
	 */
	public Livreur getLivreurId()
	{
		return livreurId;
	}

	/**
	 * Setter
	 * 
	 * @param livreur_id the livreur_id to set
	 */
	public void setLivreurId(Livreur livreurId)
	{
		this.livreurId = livreurId;
	}

	/**
	 * Getter
	 * 
	 * @return the client_id
	 */
	public Client getClientId()
	{
		return clientId;
	}

	/**
	 * Setter
	 * 
	 * @param client_id the client_id to set
	 */
	public void setClientId(Client clientId)
	{
		this.clientId = clientId;
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
}
