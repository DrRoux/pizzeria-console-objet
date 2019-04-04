/**
 * 
 */
package fr.pizzeria.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author BIRABEN-BIANCHI Hugo
 */
public abstract class JpaDao
{
	String driverName = null;
	String jdbcUrl = null;
	String userName = null;
	String password = null;
	EntityManagerFactory emf = null;
	EntityManager em = null;
	
	public void beginConnexionBdd ()
	{
		emf = Persistence.createEntityManagerFactory("pizzeriaProject");
    	em = emf.createEntityManager();
	}
	
	public void closeConnexionBdd ()
	{
		em.close ();
        emf.close ();
	}
}
