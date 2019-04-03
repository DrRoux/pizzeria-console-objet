/**
 * 
 */
package fr.pizzeria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import fr.pizzeria.model.Pizza;

/**
 *
 * @author BIRABEN-BIANCHI Hugo
 */
public class PizzaBddDao implements IPizzaDao
{
	
	String jdbcUrl = null;
	String userName = null;
	String password = null;
	Connection connexionBDD = null;
	
	PizzaBddDao ()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			jdbcUrl = "jdbc:mysql://bxnieqyqjpcgwd3f2wwb-mysql.services.clever-cloud.com:3306/bxnieqyqjpcgwd3f2wwb?useSSL=false";
			userName = "u23oixvvtlomobsc";
			password = "lwW5IiUfLRDdIsxsqY7G";
			connexionBDD = DriverManager.getConnection(jdbcUrl, userName, password);
			connexionBDD.setAutoCommit(false);
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.IPizzaDao#findAllPizzas()
	 */
	public List<Pizza> findAllPizzas()
	{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.IPizzaDao#saveNewPizza(fr.pizzeria.model.Pizza)
	 */
	public void saveNewPizza(Pizza pizza)
	{
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.IPizzaDao#updatePizza(java.lang.String, fr.pizzeria.model.Pizza)
	 */
	public void updatePizza(String codePizza, Pizza pizza)
	{
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.IPizzaDao#deletePizza(java.lang.String)
	 */
	public void deletePizza(String codePizza)
	{
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.IPizzaDao#findPizzaByCode(java.lang.String)
	 */
	public Pizza findPizzaByCode(String codePizza)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.IPizzaDao#pizzaExists(java.lang.String)
	 */
	public boolean pizzaExists(String codePizza)
	{
		// TODO Auto-generated method stub
		return false;
	}

}
