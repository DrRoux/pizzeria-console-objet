/**
 * 
 */
package fr.pizzeria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import fr.pizzeria.exception.PersonnalSqlException;
import fr.pizzeria.model.Client;

/**
 *
 * @author BIRABEN-BIANCHI Hugo
 */
public class ClientJpaDao
{
	private String driverName = null;
	private String jdbcUrl = null;
	private String userName = null;
	private String password = null;
	private Connection connexionBDD = null;
	private PreparedStatement st = null;
	
	public ClientJpaDao ()
	{
		GestionFichier file = new GestionFichier ("src/main/resources/jdbc.properties");
		List <String> listString = file.lecture();
		
		driverName = listString.get(0).split(";")[1];
		jdbcUrl = listString.get(1).split(";")[1];
		userName = listString.get(2).split(";")[1];
		password = listString.get(3).split(";")[1];
	}
	
	public void beginConnexionBdd ()
	{
		try
		{
			Class.forName(driverName);
			connexionBDD = DriverManager.getConnection(jdbcUrl, userName, password);
			connexionBDD.setAutoCommit(false);
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			throw new PersonnalSqlException ("La connexion à la base de donnée ne s'est pas déroulé correctement", e);
		}
	}
	
	public void closeConnexionBdd ()
	{
		try
		{
			st.close ();
			connexionBDD.close ();
		}
		catch (SQLException e)
		{
			throw new PersonnalSqlException ("La fermeture de la connexion à la base de donnée ne s'est pas déroulé correctement", e);
		}
	}
	
	public boolean clientExist (Client client)
	{
		boolean retour = false;
		
		
		
		return retour;
	}
}
