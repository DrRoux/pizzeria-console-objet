/**
 * 
 */
package fr.pizzeria.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author BIRABEN-BIANCHI Hugo
 */
public abstract class JpaDao
{

	protected static Logger LOGGER = LoggerFactory.getLogger(JpaDao.class);

	String driverName = null;
	String jdbcUrl = null;
	String userName = null;
	String password = null;
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pizzeriaProject");
	EntityManager em = null;

	JpaDao()
	{
		LOGGER.info("Démarrage de JPA");
	}

	public void beginConnexionBdd()
	{
		em = emf.createEntityManager();
	}

	public void closeConnexionBdd()
	{
		em.close();
	}

	public <T> void ajout(T object)
	{
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(object);
		et.commit();
	}

	public <T> void modif(T object)
	{
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(object);
		et.commit();
	}

	public <T> void suppr(T object)
	{
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(object);
		et.commit();
	}
}
