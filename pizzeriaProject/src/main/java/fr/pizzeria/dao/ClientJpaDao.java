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
		TypedQuery<Client> query = em.createQuery("SELECT c FROM Client c WHERE email= ?1 AND mot_de_passe= ?2", Client.class);
		query.setParameter(1, login);
		query.setParameter(2, password);
		Client client = query.getSingleResult();
		closeConnexionBdd();
		
		return client;
	}
}
