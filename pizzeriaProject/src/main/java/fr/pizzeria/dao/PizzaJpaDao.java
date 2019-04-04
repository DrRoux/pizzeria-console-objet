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
