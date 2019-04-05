package fr.pizzeria.dao;

import java.util.List;
import javax.persistence.TypedQuery;

import fr.pizzeria.model.Client;
import fr.pizzeria.model.Commande;

public class CommandesJpaDao extends JpaDao
{
	public List <Commande> listerCommandes (Client client)
	{
		beginConnexionBdd();
		TypedQuery<Commande> query = em.createQuery("SELECT c FROM Commande c WHERE client_id = ?1", Commande.class);
		query.setParameter(1, client);
		List<Commande> listClients = query.getResultList();
		closeConnexionBdd();
		
		return listClients;
	}
}
