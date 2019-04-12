/**
 * 
 */
package fr.pizzeria.console;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.exception.PersonnalSqlException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.menu.MenuFactory;

/**
 *
 * @author BIRABEN-BIANCHI Hugo
 */
public class PizzeriaClientConsoleApp implements IPizzeriaConsole
{
	protected static Logger logger = LoggerFactory.getLogger(PizzeriaClientConsoleApp.class);
	
	@Override
	public void display(Scanner questionUser)
	{
		String choice;
		MenuFactory menu = new MenuFactory();
		boolean sortiBoucle = false;

		while (!sortiBoucle)
		{
			IPizzeriaConsole.clean();
			logger.info("***** Pizzeria Client *****");
			logger.info("1.  S'inscrire ");
			logger.info("2.  Se connecter");
			logger.info("99. Quitter l'application");
			logger.info("\nVeuillez saisir votre choix : ");

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
					logger.info("Choix invalide, veuillez recommencer !");
				}
			}
			catch (NumberFormatException e)
			{
				// Fait boucler le programme sans interaction de l'utilisateur
			}
			catch (StockageException | PersonnalSqlException e)
			{
				logger.info(e.getMessage());
			}
		}
	}
}
