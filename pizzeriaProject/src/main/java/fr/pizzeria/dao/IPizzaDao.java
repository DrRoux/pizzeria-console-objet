package fr.pizzeria.dao;

import java.util.List;
import fr.pizzeria.model.Pizza;

/**
 * Interface de gestion des données
 * @author BIRABEN-BIANCHI Hugo
 */
public interface IPizzaDao
{
	List <Pizza> findAllPizzas ();
	void saveNewPizza(Pizza pizza);
	void updatePizza(String codePizza, Pizza pizza);
	void deletePizza(String codePizza);
	Pizza findPizzaByCode(String codePizza);
	boolean pizzaExists(String codePizza);
}
