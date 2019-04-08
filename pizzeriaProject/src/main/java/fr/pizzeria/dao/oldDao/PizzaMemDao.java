package fr.pizzeria.dao.oldDao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

/**
 * @author BIRABEN-BIANCHI Hugo
 *
 */
public class PizzaMemDao implements IPizzaDao
{
	// private Pizza [] tabPizza;
	private List<Pizza> tabPizza;

	public PizzaMemDao()
	{
		tabPizza = new ArrayList<Pizza>();
		initialisation();
	}

	public void initialisation()
	{
		if (tabPizza.size() < 8)
		{
			tabPizza.add(new Pizza("PEP", "Pépéroni", 12.50));
			tabPizza.add(new Pizza("MAR", "Margherita", 14.00));
			tabPizza.add(new Pizza("REIN", "La Reine", 11.50));
			tabPizza.add(new Pizza("FRO", "La 4 Fromage", 12.00));
			tabPizza.add(new Pizza("CAN", "La cannibale", 12.50));
			tabPizza.add(new Pizza("SAV", "La savoyarde", 13.00));
			tabPizza.add(new Pizza("ORI", "L’orientale", 13.50));
			tabPizza.add(new Pizza("IND", "L’indienne", 14.00));
		}
		else
		{
			System.out.println("Taille du tableau insuffisante pour l'initialisation !");
		}
	}

	@Override
	public List<Pizza> findAllPizzas()
	{
		return tabPizza;
	}

	@Override
	public void saveNewPizza(Pizza pizza)
	{
		if (pizzaExists(pizza.getCode()) == false)
		{
			tabPizza.add(pizza);
		}

	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza)
	{
		for (Pizza p : tabPizza)
		{
			if (p.getCode().equals(codePizza))
			{
				p.modifPizza(pizza);
			}
		}
	}

	@Override
	public void deletePizza(String codePizza)
	{
		Iterator<Pizza> it = tabPizza.iterator();

		while (it.hasNext())
		{
			Pizza p = it.next();
			if (p.getCode().equals(codePizza))
			{
				it.remove();
			}
		}
	}

	@Override
	public Pizza findPizzaByCode(String codePizza)
	{
		for (Pizza pizza : tabPizza)
		{
			if (pizza.getCode().equals(codePizza.toUpperCase()))
			{
				return pizza;
			}
		}

		return null;
	}

	@Override
	public boolean pizzaExists(String codePizza)
	{
		boolean exist = false;

		for (Pizza pizza : tabPizza)
		{
			if (pizza.getCode().equals(codePizza))
			{
				exist = true;
				break;
			}
		}

		return exist;
	}
}
