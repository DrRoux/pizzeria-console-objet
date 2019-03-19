/**
 * 
 */
package fr.pizzeria.menu;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;

/**
 * @author hugo-
 *
 */
public class ModifierPizzaService extends MenuService
{
	
	@Override
	public void executeUC(Scanner scanner)
	{
		System.out.println("Mise à jour d'une pizza : ");
		System.out.println("Veuillez choisir le code de la pizza à modifier : ");
		String choice = scanner.nextLine();
		
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
