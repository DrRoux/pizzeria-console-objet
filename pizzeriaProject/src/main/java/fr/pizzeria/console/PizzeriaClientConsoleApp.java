/**
 * 
 */
package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.exception.PersonnalSqlException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.menu.MenuFactory;

/**
 *
 * @author BIRABEN-BIANCHI Hugo
 */
public class PizzeriaClientConsoleApp implements IPizzeriaConsole
{
	@Override
	public void display(Scanner questionUser)
	{
		String choice;
		MenuFactory menu = new MenuFactory();
		boolean sortiBoucle = false;

		while (!sortiBoucle)
		{
			clean();
			System.out.println("***** Pizzeria Client *****");
			System.out.println("1.  S'inscrire ");
			System.out.println("2.  Se connecter");
			System.out.println("99. Quitter l'application");
			System.out.println("\nVeuillez saisir votre choix : ");

			choice = questionUser.nextLine();

			try
			{
				if (Integer.parseInt(choice) == 1)
				{
					menu.create("inscription").executeUC(questionUser);
				}
				else if (Integer.parseInt(choice) == 2)
				{
					menu.create("connexionClient").executeUC(questionUser);
				}
				else if (Integer.parseInt(choice) == 99)
				{
					sortiBoucle = true;
				}
				else
				{
					System.out.println("Choix invalide, veuillez recommencer !");
				}
			}
			catch (NumberFormatException e)
			{
				// Fait boucler le programme sans interaction de l'utilisateur
			}
			catch (StockageException | PersonnalSqlException e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
}
