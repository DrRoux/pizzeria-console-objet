package fr.pizzeria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.exception.MySqlException;
import fr.pizzeria.exception.SavePizzaException;
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
			
			GestionFichier file = new GestionFichier ("jdbc.properties");

			List <String> listString = file.lecture();
			
			jdbcUrl = listString.get(0).split(";")[1];
			userName = listString.get(1).split(";")[1];
			password = listString.get(2).split(";")[1];
			
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
				
				Pizza.setNbPizza(id);
			}
			
			closeConnexionBdd ();
		}
		catch (SQLException e)
		{
			throw new MySqlException (e.getMessage());
		}
		
		return tabPizza;
	}

	public void saveNewPizza(Pizza pizza)
	{
		try
		{
			beginConnexionBdd ();
			
			String requete = "\"" + pizza.getCode() + "\", \""  + pizza.getLibelle() + "\", "  + pizza.getPrix() + ", \""  + pizza.getcP().getNom() + "\"";
			statement.executeUpdate("INSERT INTO pizza (code, nom_pizza, prix, categorie) values ("+requete+");");
			
			connexionBDD.commit();
			
			closeConnexionBdd ();
		}
		catch (SQLException e)
		{
			throw new MySqlException (e.getMessage());
		}
	}

	public void updatePizza(String codePizza, Pizza pizza)
	{
		if (pizzaExists (codePizza))
		{
			try
			{
				beginConnexionBdd ();
				
				statement.executeUpdate(	"UPDATE pizza SET code = \"" + pizza.getCode()  + 
											"\", nom_pizza = \"" + pizza.getLibelle() + 
											"\", prix = " + pizza.getPrix() +
											", categorie = \"" + pizza.getcP().getNom() + 
											"\" WHERE code = \"" + codePizza + "\";");
				
				connexionBDD.commit();
				
				closeConnexionBdd ();
			}
			catch (SQLException e)
			{
				throw new MySqlException (e.getMessage());
			}
		}
	}

	public void deletePizza(String codePizza)
	{
		if (pizzaExists (codePizza))
		{
			try
			{
				beginConnexionBdd ();
				
				statement.executeUpdate("DELETE FROM pizza WHERE code = \"" + codePizza + "\";");
				
				connexionBDD.commit();
				
				closeConnexionBdd ();
			}
			catch (SQLException e)
			{
				throw new MySqlException (e.getMessage());
			}
		}
	}

	public Pizza findPizzaByCode(String codePizza)
	{
		Pizza pizza = null;
		
		try
		{
			beginConnexionBdd ();
			
			ResultSet result = statement.executeQuery("SELECT * FROM pizza WHERE code = \"" + codePizza + "\";");
			
			while(result.next()) 
			{		
				int id = result.getInt("id");
				String code = result.getString("code");
				String nom_pizza = result.getString("nom_pizza");
				double prix = result.getDouble("prix");
				String categorie = result.getString("categorie");
				
				pizza = new Pizza (id, code, nom_pizza, prix, CategoriePizza.valueOf(categorie.toUpperCase()));	
				
				Pizza.setNbPizza(id);
			}
			
			closeConnexionBdd ();
		}
		catch (SQLException e)
		{
			throw new MySqlException (e.getMessage());
		}
		
		return pizza;
	}

	public boolean pizzaExists(String codePizza)
	{
		boolean retour = false;
		
		try
		{
			beginConnexionBdd ();
			
			ResultSet result = statement.executeQuery("SELECT * FROM pizza WHERE code = \"" + codePizza + "\";");
			int compteur = 0;
			
			while(result.next()) 
			{
				compteur++;
			}
			
			if (compteur == 1)
			{
				retour = true;
			}
			
			connexionBDD.commit();
			
			closeConnexionBdd ();
		}
		catch (SQLException e)
		{
			throw new MySqlException (e.getMessage());
		}
		
		return retour;
	}

}
