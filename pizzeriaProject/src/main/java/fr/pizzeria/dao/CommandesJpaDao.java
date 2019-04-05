package fr.pizzeria.dao;

import java.util.List;

import javax.persistence.EntityGraph;
import javax.persistence.TypedQuery;

import fr.pizzeria.model.Client;
import fr.pizzeria.model.Commande;

public class CommandesJpaDao extends JpaDao
{
	public List <Commande> listerCommandes (Client client, boolean chargePizza)
	{
		beginConnexionBdd();
		
		EntityGraph<?> graph = this.em.getEntityGraph("graph.Commande.listComPiz");
		
		TypedQuery<Commande> query = em.createQuery("SELECT c FROM Commande c WHERE client_id = ?1", Commande.class);
		
		if (chargePizza == true)
		{			
			query.setHint("javax.persistence.fetchgraph", graph);
		}
		query.setParameter(1, client);
		
		List<Commande> listClients = query.getResultList();

		closeConnexionBdd();
		
		return listClients;
	}
	
	public List <Commande> listerCommandesAttente ()
	{
		beginConnexionBdd();
		TypedQuery<Commande> query = em.createQuery("SELECT c FROM Commande c WHERE status = 0", Commande.class);
		List<Commande> listClients = query.getResultList();

		closeConnexionBdd();
		
		return listClients;
	}
	
	public void ajoutCommande (Client client, Commande commande)
	{
		beginConnexionBdd();
		commande.setClient_id(client);
		commande.setLivreur_id(null);
		ajout(commande);
		closeConnexionBdd();
	}
}
