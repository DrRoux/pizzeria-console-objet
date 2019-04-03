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
		
		String choiceCode = "AAAAAAAAAAAA";
		int lengthCode = 0;
		
		while (lengthCode < 3 || lengthCode > 5)
		{
			System.out.println("Veuillez saisir le code :");
			choiceCode = scanner.nextLine();
			lengthCode = choiceCode.length();
			
			if (lengthCode < 3 || lengthCode > 5)
			{
				System.out.println("CODE INVALIDE ! Il doit faire entre 3 et 5 caractères !");
			}
		}
		
		System.out.println("Veuillez saisir le nom :");
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
		
		try
		{
			gestionnairePizza.saveNewPizza(new Pizza (choiceCode, choiceLibelle, choicePrice));
		}
		catch (MySqlException e)
		{
			System.out.println(e.getMessage());
		}
		
	}

}
