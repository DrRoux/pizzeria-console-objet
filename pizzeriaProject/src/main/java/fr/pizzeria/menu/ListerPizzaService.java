/**
 * 
 */
package fr.pizzeria.menu;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.model.Pizza;

/**
 * @author BIRABEN-BIANCHI Hugo
 *
 */
public class ListerPizzaService extends MenuService
{

	@Override
	public void executeUC(Scanner scanner)
	{
		System.out.println("Liste des pizzas : ");

		List<Pizza> pizzas = getGestionnairePizza().findAllPizzas();
		
		for (Pizza pi : pizzas)
		{
			System.out.println(pi);
		}
		
		/*
		// Affichage grâce aux annotations 
		StringUtils s = new StringUtils ();
		for (Pizza pi : pizzas)
		{
			s.setAttribut(pi);
			System.out.println(s);
		}
		
		System.out.println( " ---------------- ");
		//*/
		
		/* Affichage du menu grâce à la méthode toString () 
		   rédéfinie dans la classe Pizza. */
		
		System.out.println(" ");	
	}

}
