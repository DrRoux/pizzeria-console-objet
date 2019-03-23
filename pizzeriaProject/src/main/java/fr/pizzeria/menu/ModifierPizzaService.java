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
		
		double choicePrice = 0;
		
		try
		{
			while (choicePrice == 0)
			{
				System.out.println("Veuillez saisir le prix :");
				String choiceTempString = scanner.nextLine();
				choicePrice = Double.parseDouble(choiceTempString);
			}
		}
		catch (NumberFormatException e)
		{
			System.out.println("Veuillez saisir une nombre valide !");
			choicePrice = 0;
		}
			
		
		
		gestionnairePizza.updatePizza(choice, new Pizza (choiceCode, choiceLibelle, choicePrice));
	}
	
}
