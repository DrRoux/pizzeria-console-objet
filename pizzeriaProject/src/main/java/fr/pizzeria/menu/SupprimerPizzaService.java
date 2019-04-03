/**
 * 
 */
package fr.pizzeria.menu;

import java.util.Scanner;
import fr.pizzeria.exception.*;

/**
 * @author BIRABEN-BIANCHI Hugo
 *
 */
public class SupprimerPizzaService extends MenuService
{

	@Override
	public void executeUC(Scanner scanner) throws DeletePizzaException
	{
		String choice = null;
		System.out.println("Suppression d'une pizza : ");
		
		while (gestionnairePizza.pizzaExists(choice) == false)
		{
			System.out.println("Veuillez choisir le code de la pizza à supprimer : ");
			choice = scanner.nextLine().toUpperCase();
		}
		
		try
		{
			gestionnairePizza.deletePizza(choice);	
		}
		catch (MySqlException e)
		{
			System.out.println(e.getMessage());
		}
		
	}

}
