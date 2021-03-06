package fr.pizzeria.dao.old;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.PersonnalSqlException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 *
 * @author BIRABEN-BIANCHI Hugo
 */
public class PizzaJDBCDao implements IPizzaDao
{
	static Logger logger = LoggerFactory.getLogger(PizzaJDBCDao.class);
	private String driverName = null;
	private String jdbcUrl = null;
	private String userName = null;
	private String password = null;
	private Connection connexionBDD = null;
	private PreparedStatement st = null;

	public PizzaJDBCDao()
	{
		GestionFichier file = new GestionFichier("src/main/resources/jdbc.properties");
		List<String> listString = file.lecture();

		driverName = listString.get(0).split(";")[1];
		jdbcUrl = listString.get(1).split(";")[1];
		userName = listString.get(2).split(";")[1];
		password = listString.get(3).split(";")[1];
	}

	private void beginConnexionBdd()
	{
		try
		{
			Class.forName(driverName);
			connexionBDD = DriverManager.getConnection(jdbcUrl, userName, password);
			connexionBDD.setAutoCommit(false);
		}
		catch (ClassNotFoundException e)
		{
			logger.info(e.getMessage());
		}
		catch (SQLException e)
		{
			throw new PersonnalSqlException("La connexion à la base de donnée ne s'est pas déroulé correctement", e);
		}
	}

	private void closeConnexionBdd()
	{
		try
		{
			st.close();
			connexionBDD.close();
		}
		catch (SQLException e)
		{
			throw new PersonnalSqlException(
					"La fermeture de la connexion à la base de donnée ne s'est pas déroulé correctement", e);
		}
	}

	@Override
	public List<Pizza> findAllPizzas()
	{
		List<Pizza> tabPizza = new ArrayList<>();

		beginConnexionBdd();

		try (ResultSet result = st.executeQuery())
		{
			st = connexionBDD.prepareStatement("SELECT * FROM pizza");

			while (result.next())
			{
				int id = result.getInt("id");
				String code = result.getString("code");
				String nomPizza = result.getString("nom_pizza");
				double prix = result.getDouble("prix");
				String categorie = result.getString("categorie");

				tabPizza.add(new Pizza(id, code, nomPizza, prix, CategoriePizza.valueOf(categorie.toUpperCase())));
			}
		}
		catch (SQLException e)
		{
			throw new PersonnalSqlException(
					"La récupération de la liste de pizza dans la base de donnée ne s'est pas déroulé correctement", e);
		}

		closeConnexionBdd();
		return tabPizza;
	}

	@Override
	public void saveNewPizza(Pizza pizza)
	{
		beginConnexionBdd();

		try
		{
			st = connexionBDD
					.prepareStatement("INSERT INTO pizza (code, nom_pizza, prix, categorie) values (?, ?, ?, ?);");
			st.setString(1, pizza.getCode());
			st.setString(2, pizza.getLibelle());
			st.setDouble(3, pizza.getPrix());
			st.setString(4, pizza.getcP().getNom());
			st.executeUpdate();

			connexionBDD.commit();
		}
		catch (SQLException e)
		{
			throw new PersonnalSqlException(
					"Votre ajout d'une pizza dans la base de donnée ne s'est pas déroulé correctement", e);
		}
		finally
		{
			closeConnexionBdd();
		}

		closeConnexionBdd();
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza)
	{
		if (pizzaExists(codePizza))
		{
			beginConnexionBdd();

			try
			{
				st = connexionBDD.prepareStatement(
						"UPDATE pizza SET code = ?, nom_pizza = ?, prix = ?, categorie = ? WHERE code = ?;");
				st.setString(1, pizza.getCode());
				st.setString(2, pizza.getLibelle());
				st.setDouble(3, pizza.getPrix());
				st.setString(4, pizza.getcP().getNom());
				st.setString(5, codePizza);
				st.executeUpdate();

				connexionBDD.commit();
			}
			catch (SQLException e)
			{
				throw new PersonnalSqlException(
						"Votre modification d'une pizza dans la base de donnée ne s'est pas déroulé correctement", e);
			}
			finally
			{
				closeConnexionBdd();
			}

			closeConnexionBdd();
		}
	}

	@Override
	public void deletePizza(String codePizza)
	{
		if (pizzaExists(codePizza))
		{
			beginConnexionBdd();

			try
			{
				st = connexionBDD.prepareStatement("DELETE FROM pizza WHERE code = ?;");
				st.setString(1, codePizza);
				st.executeUpdate();

				connexionBDD.commit();
			}
			catch (SQLException e)
			{
				throw new PersonnalSqlException(
						"Votre suppression d'une pizza dans la base de donnée ne s'est pas déroulé correctement", e);
			}
			finally
			{
				closeConnexionBdd();
			}

			closeConnexionBdd();
		}
	}

	@Override
	public Pizza findPizzaByCode(String codePizza)
	{
		Pizza pizza = null;

		beginConnexionBdd();

		try (ResultSet result = st.executeQuery())
		{
			st = connexionBDD.prepareStatement("SELECT * FROM pizza WHERE code = ?");
			st.setString(1, codePizza);

			result.next();
			int id = result.getInt("id");
			String code = result.getString("code");
			String nomPizza = result.getString("nom_pizza");
			double prix = result.getDouble("prix");
			String categorie = result.getString("categorie");

			pizza = new Pizza(id, code, nomPizza, prix, CategoriePizza.valueOf(categorie.toUpperCase()));
		}
		catch (SQLException e)
		{
			throw new PersonnalSqlException(
					"Votre recherche d'une pizza dans la base de donnée ne s'est pas déroulé correctement", e);
		}

		closeConnexionBdd();
		return pizza;
	}

	@Override
	public boolean pizzaExists(String codePizza)
	{
		boolean retour = false;

		beginConnexionBdd();

		try (ResultSet result = st.executeQuery())
		{
			st = connexionBDD.prepareStatement("SELECT * FROM pizza WHERE code = ?");
			st.setString(1, codePizza);

			int compteur = 0;

			while (result.next())
			{
				compteur++;
			}

			if (compteur == 1)
			{
				retour = true;
			}

			connexionBDD.commit();
		}
		catch (SQLException e)
		{
			throw new PersonnalSqlException(
					"Votre recherche d'une pizza dans la base de donnée ne s'est pas déroulé correctement", e);
		}

		closeConnexionBdd();
		return retour;
	}

}
