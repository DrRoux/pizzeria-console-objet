/**
 * 
 */
package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.model.Client;

/**
 *
 * @author BIRABEN-BIANCHI Hugo
 */
public class ClientJpaDao extends JpaDao
{
	public ClientJpaDao ()
	{
		GestionFichier file = new GestionFichier ("src/main/resources/jdbc.properties");
		List <String> listString = file.lecture();
		
		driverName = listString.get(0).split(";")[1];
		jdbcUrl = listString.get(1).split(";")[1];
		userName = listString.get(2).split(";")[1];
		password = listString.get(3).split(";")[1];
	}
	
	public boolean clientExist (Client client)
	{
		boolean retour = false;
		
		
		
		return retour;
	}
}
