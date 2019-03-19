package fr.pizzeria.dao;

import fr.pizzeria.model.Pizza;

/**
 * @author BIRABEN-BIANCHI Hugo
 *
 */
public class PizzaMemDao implements IPizzaDao
{
	private Pizza [] tabPizza;
	
	public PizzaMemDao ()
	{
		tabPizza = new Pizza [100];
		initialisation ();
	}
	
	public void initialisation ()
	{
		if (tabPizza.length > 8)
		{
			tabPizza[0] = new Pizza ("PEP",  "Pépéroni", 	 12.50);
			tabPizza[1] = new Pizza ("MAR",  "Margherita", 	 14.00);
			tabPizza[2] = new Pizza ("REIN", "La Reine", 	 11.50);
			tabPizza[3] = new Pizza ("FRO",  "La 4 Fromage", 12.00);
			tabPizza[4] = new Pizza ("CAN",  "La cannibale", 12.50);
			tabPizza[5] = new Pizza ("SAV",  "La savoyarde", 13.00);
			tabPizza[6] = new Pizza ("ORI",  "L’orientale",  13.50);
			tabPizza[7] = new Pizza ("IND",  "L’indienne", 	 14.00);
		}
		else
			System.out.println("Taille du tableau insuffisante pour l'initialisation !");
	}

	@Override
	public Pizza[] findAllPizzas()
	{
		return tabPizza;
	}

	@Override
	public void saveNewPizza(Pizza pizza)
	{
		for (int i = 0; i < tabPizza.length; i++)
			if (tabPizza[i] == null)
			{
				tabPizza[i] = new Pizza ();
				tabPizza[i].modifPizza (pizza);
				break;
			}
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza)
	{
		for (Pizza p : tabPizza)
			if (p != null)
				if (p.getCode().equals(pizza.getCode()))
					pizza.modifPizza (pizza);
	}

	@Override
	public void deletePizza(String codePizza)
	{
		for (int i = 0; i < tabPizza.length; i++)
		{
			if (tabPizza[i] != null)	
				if (tabPizza[i].getCode().equals(codePizza.toUpperCase()))
					tabPizza[i] = null;
			
			if (tabPizza[i] == null && i < tabPizza.length-1 && tabPizza[i+1] != null)
			{
				tabPizza[i] = tabPizza[i+1];
				// tabPizza[i].setId(i); Modification ou non de l'ID ? Permet de garder une trace du nombre de Pizza créées même si supprimées.
				tabPizza[i+1] = null;
			}
		}
	}

	@Override
	public Pizza findPizzaByCode(String codePizza)
	{
		for (Pizza pizza : tabPizza)
			if (pizza.getCode().equals(codePizza.toUpperCase()))
				return pizza;
		
		return null;
	}

	@Override
	public boolean pizzaExists(String codePizza)
	{
		boolean exist = false;
		
		for (Pizza pizza : tabPizza)
			if (pizza.getCode().equals(codePizza))
			{
				exist = true;
				break;
			}
		
		return exist;
	}
	
	public void displayList ()
	{
		for (Pizza pizza : tabPizza)
			if (pizza != null)
				System.out.println(pizza);
	}
	
}
