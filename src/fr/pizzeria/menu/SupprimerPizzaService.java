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
		System.out.println("Suppression d'une pizza : ");
		System.out.println("Veuillez choisir le code de la pizza à supprimer : ");
		String choice = scanner.nextLine();
		
		gestionnairePizza.deletePizza(choice);	
		
	}

}
