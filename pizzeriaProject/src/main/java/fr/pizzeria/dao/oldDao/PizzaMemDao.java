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
	private List<Pizza> listPizzas;

	public PizzaMemDao()
	{
		listPizzas = new ArrayList<Pizza>();
		initialisation();
	}

	public void initialisation()
	{
		if (listPizzas.size() < 8)
		{
			listPizzas.add(new Pizza("PEP", "Pépéroni", 12.50));
			listPizzas.add(new Pizza("MAR", "Margherita", 14.00));
			listPizzas.add(new Pizza("REIN", "La Reine", 11.50));
			listPizzas.add(new Pizza("FRO", "La 4 Fromage", 12.00));
			listPizzas.add(new Pizza("CAN", "La cannibale", 12.50));
			listPizzas.add(new Pizza("SAV", "La savoyarde", 13.00));
			listPizzas.add(new Pizza("ORI", "L’orientale", 13.50));
			listPizzas.add(new Pizza("IND", "L’indienne", 14.00));
		}
		else
		{
			System.out.println("Taille du tableau insuffisante pour l'initialisation !");
		}
	}

	@Override
	public List<Pizza> findAllPizzas()
	{
		return listPizzas;
	}

	@Override
	public void saveNewPizza(Pizza pizza)
	{
		if (pizzaExists(pizza.getCode()) == false)
		{
			listPizzas.add(pizza);
		}

	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza)
	{
		for (Pizza p : listPizzas)
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
		Iterator<Pizza> it = listPizzas.iterator();

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
		Pizza p = null;
		for (Pizza pizza : listPizzas)
		{
			if (pizza.getCode().equals(codePizza.toUpperCase()))
			{
				p = pizza;
			}
		}

		return p;
	}

	@Override
	public boolean pizzaExists(String codePizza)
	{
		boolean exist = false;

		for (Pizza pizza : listPizzas)
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
