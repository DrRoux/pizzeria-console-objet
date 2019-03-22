package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.dao.gestionFichier;

/**
 * Classe permettant la gestion des Pizza comme une véritable
 * BDD avec écriture dans un fichier pour la persistance des données
 * @author BIRABEN-BIANCHI Hugo
 */
public class PizzaFileDao implements IPizzaDao
{
	private List <Pizza> tabPizza;
	private gestionFichier gestionFichier;
	
	public PizzaFileDao ()
	{
		tabPizza = new ArrayList <Pizza> ();
		gestionFichier = new gestionFichier ();
		
		/*
		initialisation ();
		ecriture ();
		//*/
		
		lecture ();
	}
	
	public void initialisation ()
	{
		tabPizza.add(new Pizza ("PEP",  "Pépéroni", 	 12.50, CategoriePizza.INCONNU));
		tabPizza.add(new Pizza ("MAR",  "Margherita", 	 14.00, CategoriePizza.SANS_VIANDE));
		tabPizza.add(new Pizza ("REIN", "La Reine", 	 11.50, CategoriePizza.VIANDE));
		tabPizza.add(new Pizza ("FRO",  "La 4 Fromage",  12.00, CategoriePizza.SANS_VIANDE));
		tabPizza.add(new Pizza ("CAN",  "La cannibale",  12.50, CategoriePizza.VIANDE));
		tabPizza.add(new Pizza ("SAV",  "La savoyarde",  13.00, CategoriePizza.INCONNU));
		tabPizza.add(new Pizza ("ORI",  "L’orientale",   13.50, CategoriePizza.INCONNU));
		tabPizza.add(new Pizza ("IND",  "L’indienne", 	 14.00, CategoriePizza.INCONNU));
	}

	@Override
	public List <Pizza> findAllPizzas()
	{
		return tabPizza;
	}

	@Override
	public void saveNewPizza(Pizza pizza)
	{
		tabPizza.add(pizza);
		ecriture ();
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza)
	{
		for (Pizza p : tabPizza)
			if (p.getCode().equals(codePizza))
				p.modifPizza (pizza);
		
		ecriture ();
	}

	@Override
	public void deletePizza(String codePizza)
	{
		for (int i = 0; i < tabPizza.size (); i++)
		{
			if (tabPizza.get(i) != null)	
				if (tabPizza.get(i).getCode().equals(codePizza.toUpperCase()))
					tabPizza.set(i, null);
			
			if (tabPizza.get(i) == null && (i < tabPizza.size ()-1) && tabPizza.get(i+1) != null)
			{
				tabPizza.set(i, tabPizza.get(i+1));
				tabPizza.set(i+1, null);
			}
		}
		ecriture ();
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
	
	public void ecriture () 
	{
		List <String> listString = new ArrayList<String> ();
		
		for (Pizza pizza : tabPizza)
			if (pizza != null)
				listString.add(pizza.toSave());
		
		gestionFichier.ecriture(listString);
	}
	
	public void lecture ()
	{
		List <String> listString = gestionFichier.lecture();
		
		int maxNbPizza = 0;		
		for (String s : listString)
		{
			String [] pizza = s.split(",");
			tabPizza.add(new Pizza (Integer.parseInt(pizza[0]), pizza[1], pizza[2], Double.parseDouble(pizza[3]), CategoriePizza.valueOf(pizza[4].toUpperCase())));
			maxNbPizza = Integer.parseInt(pizza[0]);
		}
		
		Pizza.setNbPizza(maxNbPizza+1);
	}
}
