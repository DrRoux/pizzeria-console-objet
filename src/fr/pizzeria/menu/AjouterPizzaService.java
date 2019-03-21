/**
 * 
 */
package fr.pizzeria.menu;

import java.util.Scanner;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.exception.*;

/**
 * @author BIRABEN-BIANCHI Hugo
 *
 */
public class AjouterPizzaService extends MenuService
{

	@Override
	public void executeUC(Scanner scanner) throws SavePizzaException
	{
		System.out.println("Ajout d'une nouvelle pizza : ");
		
		System.out.println("Veuillez saisir le code :");
		String choiceCode = scanner.nextLine();

		if (choiceCode.length() < 3)
			throw new SavePizzaException ("codeTropCourt");
		else if (choiceCode.length() > 5)
			throw new SavePizzaException ("codeTropLong");

		
		System.out.println("Veuillez saisir le nom (sans espace):");
		String choiceLibelle = scanner.nextLine();
		
		System.out.println("Veuillez saisir le prix :");
		String choiceTempString = scanner.nextLine();
		double choicePrice = Double.parseDouble(choiceTempString);
		
		gestionnairePizza.saveNewPizza(new Pizza (choiceCode, choiceLibelle, choicePrice));
	}

}
