/**
 * 
 */
package fr.pizzeria.menu;

import java.util.Scanner;

import fr.pizzeria.exception.DeletePizzaException;

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
		logger.info("Suppression d'une pizza : ");

		while (!getGestionnairePizza().pizzaExists(choice))
		{
			logger.info("Veuillez choisir le code de la pizza à supprimer : ");
			choice = scanner.nextLine().toUpperCase();
		}

		getGestionnairePizza().deletePizza(choice);

	}

}
