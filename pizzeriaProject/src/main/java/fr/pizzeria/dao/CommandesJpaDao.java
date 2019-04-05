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
		TypedQuery<Commande> query = em.createQuery("SELECT c FROM Commande c WHERE client_id=:id", Commande.class);
		query.setParameter("id", client);
		List<Commande> listClients = query.getResultList();
		listClients.forEach(t->System.out.println(t));
		closeConnexionBdd();
		
		return listClients;
	}
}
