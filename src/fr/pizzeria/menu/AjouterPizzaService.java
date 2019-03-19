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
public class AjouterPizzaService extends MenuService
{

	@Override
	public void executeUC(Scanner scanner)
	{
		System.out.println("Ajout d'une nouvelle pizza : ");
		
		System.out.println("Veuillez saisir le code :");
		String choiceCode = scanner.nextLine();
		
		System.out.println("Veuillez saisir le nom (sans espace):");
		String choiceLibelle = scanner.nextLine();
		
		System.out.println("Veuillez saisir le prix :");
		String choiceTempString = scanner.nextLine();
		double choicePrice = Double.parseDouble(choiceTempString);
		
		gestionnairePizza.saveNewPizza(new Pizza (choiceCode, choiceLibelle, choicePrice));
	}

}
