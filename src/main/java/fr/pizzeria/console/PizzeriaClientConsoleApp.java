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
	private static Logger logger = LoggerFactory.getLogger(PizzeriaClientConsoleApp.class);
	private String choice;
	private MenuFactory menu = new MenuFactory();
	private boolean sortiBoucle = false;
	
	@Override
	public void display(Scanner questionUser)
	{
		while (!sortiBoucle)
		{
			displayMenu ();

			choice = questionUser.nextLine();

			try
			{
				choixMenu (questionUser);
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

	@Override
	public void displayMenu()
	{
		IPizzeriaConsole.clean();
		logger.info("***** Pizzeria Client *****");
		logger.info("1.  S'inscrire ");
		logger.info("2.  Se connecter");
		logger.info("99. Quitter l'application");
		logger.info("\nVeuillez saisir votre choix : ");
	}
	
	@Override
	public void displayException (String e)
	{
		logger.info(e);
	}

	@Override
	public void choixMenu(Scanner questionUser) throws StockageException
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
}
