/**
 * 
 */
package fr.pizzeria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.pizzeria.exception.PersonnalSqlException;
import fr.pizzeria.model.Pizza;

/**
 *
 * @author BIRABEN-BIANCHI Hugo
 */
public class PizzaJpaDao implements IPizzaDao
{

	private String driverName = null;
	private String jdbcUrl = null;
	private String userName = null;
	private String password = null;
	private Connection connexionBDD = null;
	private PreparedStatement st = null;
	
	public PizzaJpaDao ()
	{
		GestionFichier file = new GestionFichier ("src/main/ressources/jdbc.properties");
		List <String> listString = file.lecture();
		
		driverName = listString.get(0).split(";")[1];
		jdbcUrl = listString.get(1).split(";")[1];
		userName = listString.get(2).split(";")[1];
		password = listString.get(3).split(";")[1];
	}
	
	public void beginConnexionBdd ()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pizzeriaProject");
    	EntityManager em = emf.createEntityManager();

    	TypedQuery <Pizza> requete = em.createQuery("select p from Pizza p", Pizza.class);
    	List <Pizza> listPizza = requete.getResultList();
    	
    	listPizza.forEach(t -> System.out.println(t));
        
        em.close ();
        emf.close ();
	}
	
	public void closeConnexionBdd ()
	{
	}
	
	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.IPizzaDao#findAllPizzas()
	 */
	@Override
	public List<Pizza> findAllPizzas()
	{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.IPizzaDao#saveNewPizza(fr.pizzeria.model.Pizza)
	 */
	@Override
	public void saveNewPizza(Pizza pizza)
	{
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.IPizzaDao#updatePizza(java.lang.String, fr.pizzeria.model.Pizza)
	 */
	@Override
	public void updatePizza(String codePizza, Pizza pizza)
	{
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.IPizzaDao#deletePizza(java.lang.String)
	 */
	@Override
	public void deletePizza(String codePizza)
	{
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.IPizzaDao#findPizzaByCode(java.lang.String)
	 */
	@Override
	public Pizza findPizzaByCode(String codePizza)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.IPizzaDao#pizzaExists(java.lang.String)
	 */
	@Override
	public boolean pizzaExists(String codePizza)
	{
		// TODO Auto-generated method stub
		return false;
	}

}
