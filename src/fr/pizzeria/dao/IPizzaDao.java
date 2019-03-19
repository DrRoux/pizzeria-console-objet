package fr.pizzeria.dao;

import fr.pizzeria.model.Pizza;

/**
 * @author BIRABEN-BIANCHI Hugo
 */
public interface IPizzaDao
{
	Pizza [] findAllPizzas ();
	void saveNewPizza(Pizza pizza);
	void updatePizza(String codePizza, Pizza pizza);
	void deletePizza(String codePizza);
	Pizza findPizzaByCode(String codePizza);
	boolean pizzaExists(String codePizza);
}
