package fr.pizzeria.dao;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.slf4j.LoggerFactory;

import fr.pizzeria.model.Client;

/**
 *
 * @author BIRABEN-BIANCHI Hugo
 */
public class ClientJpaDao extends JpaDao
{
	public ClientJpaDao()
	{
		logger = LoggerFactory.getLogger(ClientJpaDao.class);
	}

	public void addNewClient(Client client)
	{
		beginConnexionBdd();
		ajout(client);
		closeConnexionBdd();
	}

	public Client getClient(String login, String password)
	{
		beginConnexionBdd();
		TypedQuery<Client> query = em.createQuery("SELECT c FROM Client c WHERE email= ?1 AND mot_de_passe= ?2",
				Client.class);
		query.setParameter(1, login);
		query.setParameter(2, password);

		Client client = null;

		try
		{
			client = query.getSingleResult();
		}
		catch (NoResultException e)
		{
			client = null;
		}

		closeConnexionBdd();

		return client;
	}
}
