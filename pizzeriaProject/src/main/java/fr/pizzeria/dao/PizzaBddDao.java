/**
 * 
 */
package fr.pizzeria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.model.CategoriePizza;
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
	Statement statement = null;
	
	private void beginConnexionBdd ()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			jdbcUrl = "jdbc:mysql://bxnieqyqjpcgwd3f2wwb-mysql.services.clever-cloud.com:3306/bxnieqyqjpcgwd3f2wwb?useSSL=false";
			userName = "u23oixvvtlomobsc";
			password = "lwW5IiUfLRDdIsxsqY7G";
			
			connexionBDD = DriverManager.getConnection(jdbcUrl, userName, password);
			connexionBDD.setAutoCommit(false);
			
			statement = connexionBDD.createStatement();
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
	
	private void closeConnexionBdd ()
	{
		try
		{
			statement.close ();
			connexionBDD.close ();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public List<Pizza> findAllPizzas()
	{
		List <Pizza> tabPizza = new ArrayList <> ();
		
		try
		{
			beginConnexionBdd ();
			
			ResultSet result = statement.executeQuery("SELECT * FROM pizza");
			
			while(result.next()) 
			{		
				int id = result.getInt("id");
				String code = result.getString("code");
				String nom_pizza = result.getString("nom_pizza");
				double prix = result.getDouble("prix");
				String categorie = result.getString("categorie");
				
				tabPizza.add(new Pizza (id, code, nom_pizza, prix, CategoriePizza.valueOf(categorie.toUpperCase())));	
			}
			
			closeConnexionBdd ();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return tabPizza;
	}

	public void saveNewPizza(Pizza pizza)
	{
		try
		{
			beginConnexionBdd ();
			
			String requete = "" + pizza.getId () + ", \"" + pizza.getCode() + "\", \""  + pizza.getLibelle() + "\", \""  + pizza.getPrix() + ", \""  + pizza.getcP() + "\"";
			int nbLigne = statement.executeUpdate("INSERT INTO pizza values ("+requete+");");
			
			closeConnexionBdd ();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public void updatePizza(String codePizza, Pizza pizza)
	{
		// TODO Auto-generated method stub

	}

	public void deletePizza(String codePizza)
	{
		// TODO Auto-generated method stub

	}

	public Pizza findPizzaByCode(String codePizza)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public boolean pizzaExists(String codePizza)
	{
		// TODO Auto-generated method stub
		return false;
	}

}
