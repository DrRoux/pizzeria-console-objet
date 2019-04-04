/**
 * 
 */
package fr.pizzeria.dao;

import javax.persistence.TypedQuery;
import fr.pizzeria.model.Client;

/**
 *
 * @author BIRABEN-BIANCHI Hugo
 */
public class ClientJpaDao extends JpaDao
{
	public void addNewClient (Client client)
	{
		beginConnexionBdd();
		ajout (client);
		closeConnexionBdd();
	}
	
	public Client getClient (String login, String password)
	{
		beginConnexionBdd();
		TypedQuery<Client> query = em.createQuery("SELECT c FROM Client c WHERE email=:login AND password=:pswd", Client.class);
		query.setParameter("login", login);
		query.setParameter("pswd", password);
		Client client = query.getSingleResult();
		closeConnexionBdd();
		
		return client;
	}
}
