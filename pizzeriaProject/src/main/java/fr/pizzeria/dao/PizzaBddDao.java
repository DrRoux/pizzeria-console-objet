package fr.pizzeria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	PreparedStatement st = null;
	
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
			st.close ();
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
			
			st = connexionBDD.prepareStatement("SELECT * FROM pizza");
			ResultSet result = st.executeQuery();
			
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
			throw new MySqlException ("La récupération de la liste de pizza dans la base de donnée ne s'est pas déroulé correctement", e);
		}
		
		return tabPizza;
	}

	public void saveNewPizza(Pizza pizza)
	{
		try
		{
			beginConnexionBdd ();
			
			st = connexionBDD.prepareStatement("INSERT INTO pizza (code, nom_pizza, prix, categorie) values (?, ?, ?, ?);");
			st.setString(1, pizza.getCode());
			st.setString(2, pizza.getLibelle());
			st.setDouble(3, pizza.getPrix());
			st.setString(4, pizza.getcP().getNom());
			st.executeUpdate();
			
			connexionBDD.commit();
			
			closeConnexionBdd ();
		}
		catch (SQLException e)
		{
			throw new MySqlException ("Votre ajout d'une pizza dans la base de donnée ne s'est pas déroulé correctement", e);
		}
	}

	public void updatePizza(String codePizza, Pizza pizza)
	{
		if (pizzaExists (codePizza))
		{
			try
			{
				beginConnexionBdd ();
				
				st = connexionBDD.prepareStatement("UPDATE pizza SET code = ?, nom_pizza = ?, prix = ?, categorie = ? WHERE ?;");
				st.setString(1, pizza.getCode());
				st.setString(2, pizza.getLibelle());
				st.setDouble(3, pizza.getPrix());
				st.setString(4, pizza.getcP().getNom());
				st.setString(5, codePizza);
				st.executeUpdate();
				
				connexionBDD.commit();
				
				closeConnexionBdd ();
			}
			catch (SQLException e)
			{
				throw new MySqlException ("Votre modification d'une pizza dans la base de donnée ne s'est pas déroulé correctement", e);
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
				
				st = connexionBDD.prepareStatement("DELETE FROM pizza WHERE code = ?;");
				st.setString(1, codePizza);
				st.executeUpdate();
				
				connexionBDD.commit();
				
				closeConnexionBdd ();
			}
			catch (SQLException e)
			{
				throw new MySqlException ("Votre suppression d'une pizza dans la base de donnée ne s'est pas déroulé correctement", e);
			}
		}
	}

	public Pizza findPizzaByCode(String codePizza)
	{
		Pizza pizza = null;
		
		try
		{
			beginConnexionBdd ();
			
			st = connexionBDD.prepareStatement("SELECT * FROM pizza WHERE code = ?");
			st.setString(1, codePizza);
			ResultSet result = st.executeQuery();
			
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
			throw new MySqlException ("Votre recherche d'une pizza dans la base de donnée ne s'est pas déroulé correctement", e);
		}
		
		return pizza;
	}

	public boolean pizzaExists(String codePizza)
	{
		boolean retour = false;
		
		try
		{
			beginConnexionBdd ();
			
			st = connexionBDD.prepareStatement("SELECT * FROM pizza WHERE code = ?");
			st.setString(1, codePizza);
			ResultSet result = st.executeQuery();
			
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
			throw new MySqlException ("Votre recherche d'une pizza dans la base de donnée ne s'est pas déroulé correctement", e);
		}
		
		return retour;
	}

}
