/**
 * 
 */
package fr.pizzeria.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.slf4j.LoggerFactory;

import fr.pizzeria.model.Pizza;

/**
 *
 * @author BIRABEN-BIANCHI Hugo
 */
public class PizzaJpaDao extends JpaDao implements IPizzaDao
{
	public PizzaJpaDao()
	{
		LOGGER = LoggerFactory.getLogger(PizzaJpaDao.class);
	}

	@Override
	public List<Pizza> findAllPizzas()
	{
		beginConnexionBdd();

		TypedQuery<Pizza> requete = em.createQuery("select p from Pizza p", Pizza.class);
		List<Pizza> listPizza = requete.getResultList();

		closeConnexionBdd();

		return listPizza;
	}

	@Override
	public void saveNewPizza(Pizza pizza)
	{
		beginConnexionBdd();
		ajout(pizza);
		closeConnexionBdd();
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza)
	{
		if (pizzaExists(codePizza))
		{
			Pizza p = findPizzaByCode(codePizza);
			p.setCode(pizza.getCode());
			p.setLibelle(pizza.getLibelle());
			p.setPrix(pizza.getPrix());
			p.setcP(pizza.getcP());

			beginConnexionBdd();
			modif(p);
			closeConnexionBdd();
		}

	}

	@Override
	public void deletePizza(String codePizza)
	{
		if (pizzaExists(codePizza))
		{
			beginConnexionBdd();

			Pizza query = em.createQuery("SELECT p FROM Pizza p WHERE code= ?1", Pizza.class).setParameter(1, codePizza)
					.getSingleResult();
			suppr(query);

			closeConnexionBdd();
		}
	}

	@Override
	public Pizza findPizzaByCode(String codePizza)
	{
		Pizza p = null;
		if (codePizza != null)
		{
			beginConnexionBdd();

			TypedQuery<Pizza> query = em.createQuery("SELECT p FROM Pizza p WHERE code= ?1", Pizza.class);
			query.setParameter(1, codePizza);
			p = query.getSingleResult();

			closeConnexionBdd();
		}
		return p;
	}

	@Override
	public boolean pizzaExists(String codePizza)
	{
		boolean retour = false;

		beginConnexionBdd();

		TypedQuery<Pizza> query = em.createQuery("SELECT p FROM Pizza p WHERE code= ?1", Pizza.class);
		query.setParameter(1, codePizza);

		if (query.getResultList().size() == 1)
			retour = true;

		closeConnexionBdd();

		return retour;
	}

}
