package fr.pizzeria.dao;

import java.util.*;
import fr.pizzeria.model.Pizza;

/**
 * @author BIRABEN-BIANCHI Hugo
 *
 */
public class PizzaMemDao implements IPizzaDao
{
	//private Pizza [] tabPizza;
	private List <Pizza> tabPizza;
	
	public PizzaMemDao ()
	{
		tabPizza = new ArrayList <Pizza> ();
		initialisation ();
	}
	
	public void initialisation ()
	{
		if (tabPizza.size () > 8)
		{
			tabPizza.add(new Pizza ("PEP",  "Pépéroni", 	 12.50));
			tabPizza.add(new Pizza ("MAR",  "Margherita", 	 14.00));
			tabPizza.add(new Pizza ("REIN", "La Reine", 	 11.50));
			tabPizza.add(new Pizza ("FRO",  "La 4 Fromage",  12.00));
			tabPizza.add(new Pizza ("CAN",  "La cannibale",  12.50));
			tabPizza.add(new Pizza ("SAV",  "La savoyarde",  13.00));
			tabPizza.add(new Pizza ("ORI",  "L’orientale",   13.50));
			tabPizza.add(new Pizza ("IND",  "L’indienne", 	 14.00));
		}
		else
		{
			System.out.println("Taille du tableau insuffisante pour l'initialisation !");
		}
	}
	
	public List <Pizza> findAllPizzas()
	{
		return tabPizza;
	}

	public void saveNewPizza(Pizza pizza)
	{
		for (int i = 0; i < tabPizza.size (); i++)
		{
			if (tabPizza.get(i) == null)
			{
				tabPizza.add(new Pizza ());
				tabPizza.get(i).modifPizza (pizza);
				break;
			}
		}
	}

	public void updatePizza(String codePizza, Pizza pizza)
	{
		for (Pizza p : tabPizza)
		{
			if (p != null)
			{
				if (p.getCode().equals(codePizza))
				{
					p.modifPizza (pizza);
				}
			}
		}
	}

	public void deletePizza(String codePizza)
	{
		for (Pizza p : tabPizza)
		{
			if (p.getCode().equals(codePizza))
			{
				System.out.println(p.getId());
				tabPizza.remove (p);
				break;
			}
		}
		
		for (int i = 0; i < tabPizza.size (); i++)
		{
			if (tabPizza.get(i).getId() != i)
			{
				tabPizza.get(i).setId(i);
			}
		}
	}

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
