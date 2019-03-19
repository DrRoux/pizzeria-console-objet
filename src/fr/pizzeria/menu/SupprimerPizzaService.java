/**
 * 
 */
package fr.pizzeria.menu;

import java.util.Scanner;

/**
 * @author hugo-
 *
 */
public class SupprimerPizzaService extends MenuService
{

	@Override
	public void executeUC(Scanner scanner)
	{
		String choice;
		
		do
		{
			System.out.println("Suppression d'une pizza : ");
			System.out.println("Veuillez choisir le code de la pizza à supprimer : ");
			choice = scanner.nextLine();
		}
		while (gestionnairePizza.pizzaExists(choice) == false);
		
		gestionnairePizza.deletePizza(choice);	
		
	}

}
