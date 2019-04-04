/**
 * 
 */
package fr.pizzeria.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
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
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pizzeriaProject");
	EntityManager em = null;
	
	public void beginConnexionBdd ()
	{
    	em = emf.createEntityManager();
	}
	
	public void closeConnexionBdd ()
	{
		em.close ();
	}
	
	public <T> void ajout (T object)
	{
		EntityTransaction et = em.getTransaction();
		et.begin ();
		em.persist(object);
		et.commit ();
	}
}
