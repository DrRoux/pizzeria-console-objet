/**
 * 
 */
package fr.pizzeria.dao;

import java.util.List;
import javax.persistence.TypedQuery;
import fr.pizzeria.model.Pizza;

/**
 *
 * @author BIRABEN-BIANCHI Hugo
 */
public class PizzaJpaDao extends JpaDao implements IPizzaDao
{
	
	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.IPizzaDao#findAllPizzas()
	 */
	@Override
	public List<Pizza> findAllPizzas()
	{
		beginConnexionBdd();
		
		TypedQuery <Pizza> requete = em.createQuery("select p from Pizza p", Pizza.class);
    	List <Pizza> listPizza = requete.getResultList();
    	
    	closeConnexionBdd();
    	
		return listPizza;
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.IPizzaDao#saveNewPizza(fr.pizzeria.model.Pizza)
	 */
	@Override
	public void saveNewPizza(Pizza pizza)
	{
		beginConnexionBdd();
		ajout (pizza);
		closeConnexionBdd();
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.IPizzaDao#updatePizza(java.lang.String, fr.pizzeria.model.Pizza)
	 */
	@Override
	public void updatePizza(String codePizza, Pizza pizza)
	{
		if (pizzaExists (codePizza))
		{
			Pizza p = findPizzaByCode (codePizza);
			p.setCode(pizza.getCode ());
			p.setLibelle(pizza.getLibelle());
			p.setPrix(pizza.getPrix());
			p.setcP(pizza.getcP());
			
			beginConnexionBdd();
			modif (p);
			closeConnexionBdd();
		}
		
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.IPizzaDao#deletePizza(java.lang.String)
	 */
	@Override
	public void deletePizza(String codePizza)
	{
		if (pizzaExists (codePizza))
		{
			beginConnexionBdd();
			
			Pizza query = em.createQuery("SELECT p FROM Pizza p WHERE code=:codePizza", Pizza.class).setParameter("codePizza", codePizza).getSingleResult();
			suppr(query);
			
			closeConnexionBdd();
		}
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.IPizzaDao#findPizzaByCode(java.lang.String)
	 */
	@Override
	public Pizza findPizzaByCode(String codePizza)
	{
		Pizza p = null;
		beginConnexionBdd();

		TypedQuery<Pizza> query = em.createQuery("SELECT p FROM Pizza p WHERE code=:codePizza", Pizza.class);
		query.setParameter("codePizza", codePizza);
		p = query.getSingleResult();
		
		closeConnexionBdd();
		return p;
	}

	/* (non-Javadoc)
	 * @see fr.pizzeria.dao.IPizzaDao#pizzaExists(java.lang.String)
	 */
	@Override
	public boolean pizzaExists(String codePizza)
	{
		boolean retour = false;
		
		beginConnexionBdd();

		TypedQuery<Pizza> query = em.createQuery("SELECT p FROM Pizza p WHERE code=:codePizza", Pizza.class);
		query.setParameter("codePizza", codePizza);
		
		if (query.getResultList().size() == 1)
			retour = true;
		
		closeConnexionBdd();
		
		return retour;
	}

}
