/**
 * 
 */
package fr.pizzeria.menu;

import java.util.Scanner;

/**
 * @author hugo-
 *
 */
public class ListerPizzaService extends MenuService
{

	@Override
	public void executeUC(Scanner scanner)
	{
		System.out.println("Liste des pizzas : ");
		gestionnairePizza.displayList ();
		System.out.println(" ");	
	}

}
