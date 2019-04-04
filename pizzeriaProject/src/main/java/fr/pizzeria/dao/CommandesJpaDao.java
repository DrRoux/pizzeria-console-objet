package fr.pizzeria.dao;

import java.util.List;
import javax.persistence.TypedQuery;

import fr.pizzeria.model.Client;
import fr.pizzeria.model.Commande;

public class CommandesJpaDao extends JpaDao
{
	public List <Commande> listerCommandes (Client client)
	{
		System.out.println(client + " " + client.getId ());
		beginConnexionBdd();
		TypedQuery<Commande> query = em.createQuery("SELECT c FROM Commande c WHERE client_id =:id", Commande.class);
		query.setParameter("id", client.getId());
		List<Commande> listClients = query.getResultList();
		closeConnexionBdd();
		
		return listClients;
	}
}
