/**
 * 
 */
package fr.pizzeria.dao;

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
	
	public boolean clientExist (Client client)
	{
		boolean retour = false;
		
		
		
		return retour;
	}
}
