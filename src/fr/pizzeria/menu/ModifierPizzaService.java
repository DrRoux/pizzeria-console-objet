/**
 * 
 */
package fr.pizzeria.menu;

import java.util.Scanner;
import fr.pizzeria.exception.*;
import fr.pizzeria.model.Pizza;

/**
 * @author BIRABEN-BIANCHI Hugo
 *
 */
public class ModifierPizzaService extends MenuService
{
	
	@Override
	public void executeUC(Scanner scanner) throws UpdatePizzaException
	{
		String choice = null;
		System.out.println("Modification d'une pizza : ");
		
		while (gestionnairePizza.pizzaExists(choice) == false)
		{	
			System.out.println("Veuillez choisir le code de la pizza à modifier : ");
			choice = scanner.nextLine().toUpperCase();
		}
		
		System.out.println("Veuillez saisir le code :");
		String choiceCode = scanner.nextLine();
		
		System.out.println("Veuillez saisir le nom (sans espace):");
		String choiceLibelle = scanner.nextLine();
		
		System.out.println("Veuillez saisir le prix :");
		String choiceTempString = scanner.nextLine();
		double choicePrice = Double.parseDouble(choiceTempString);
		
		gestionnairePizza.updatePizza(choice, new Pizza (choiceCode, choiceLibelle, choicePrice));
	}
	
}
