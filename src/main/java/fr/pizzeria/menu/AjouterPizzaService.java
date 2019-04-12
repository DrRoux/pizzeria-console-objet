/**
 * 
 */
package fr.pizzeria.menu;

import java.util.Scanner;

import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.Pizza;

/**
 * @author BIRABEN-BIANCHI Hugo
 *
 */
public class AjouterPizzaService extends MenuService
{

	@Override
	public void executeUC(Scanner scanner) throws SavePizzaException
	{
		logger.info("Ajout d'une nouvelle pizza : ");
		
		String choiceCode = "AAAAAAAAAAAA";
		int lengthCode = 0;
		
		while (lengthCode < 3 || lengthCode > 5)
		{
			logger.info("Veuillez saisir le code :");
			choiceCode = scanner.nextLine();
			lengthCode = choiceCode.length();
			
			if (lengthCode < 3 || lengthCode > 5)
			{
				logger.info("CODE INVALIDE ! Il doit faire entre 3 et 5 caractères !");
			}
		}
		
		logger.info("Veuillez saisir le nom :");
		String choiceLibelle = scanner.nextLine();
		
		double choicePrice = 0;
		
		try
		{
			while (choicePrice == 0)
			{
				logger.info("Veuillez saisir le prix :");
				String choiceTempString = scanner.nextLine();
				choicePrice = Double.parseDouble(choiceTempString);
			}
		}
		catch (NumberFormatException e)
		{
			logger.info("Veuillez saisir une nombre valide !");
			choicePrice = 0;
		}

		getGestionnairePizza().saveNewPizza(new Pizza (choiceCode, choiceLibelle, choicePrice));
	}

}
