package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * Classe permettant la gestion des Pizza comme une véritable
 * BDD avec écriture dans un fichier pour la persistance des données
 * @author BIRABEN-BIANCHI Hugo
 */
public class PizzaFileDao implements IPizzaDao
{
	private List <Pizza> tabPizza;
	private GestionFichier gestionFichier;
	
	public PizzaFileDao ()
	{
		tabPizza = new ArrayList <Pizza> ();
		gestionFichier = new GestionFichier ("src/main/ressources/save.txt");
		
		if (gestionFichier.isEmpty())
		{
			initialisation ();
			ecriture ();
		}
		else
		{
			lecture ();
		}
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

	public List <Pizza> findAllPizzas()
	{
		return tabPizza;
	}

	public void saveNewPizza(Pizza pizza)
	{
		tabPizza.add(pizza);
		this.ecriture ();
	}
	
	public void updatePizza(String codePizza, Pizza pizza)
	{
		for (Pizza p : tabPizza)
		{
			if (p.getCode().equals(codePizza))
			{
				p.modifPizza (pizza);
			}
		}
		
		this.ecriture ();
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
		
		this.ecriture ();
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
	
	public void ecriture () 
	{
		List <String> listString = new ArrayList<String> ();
		
		for (Pizza pizza : tabPizza)
		{
				listString.add(pizza.toSave());
		}
		
		gestionFichier.ecriture(listString);
	}
	
	public void lecture ()
	{
		List <String> listString = gestionFichier.lecture();
			
		for (String s : listString)
		{
			String [] pizza = s.split(",");
			tabPizza.add(new Pizza (Integer.parseInt(pizza[0]), pizza[1], pizza[2], Double.parseDouble(pizza[3]), CategoriePizza.valueOf(pizza[4].toUpperCase())));
		}
	}
}
