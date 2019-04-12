package fr.pizzeria.console;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.exception.PersonnalSqlException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.menu.ListerCommandesClientService;
import fr.pizzeria.menu.MenuFactory;
import fr.pizzeria.menu.PasserCommandeClientService;
import fr.pizzeria.model.Client;

public class PizzeriaClientConnecteConsoleApp implements IPizzeriaConsole
{
	private static Logger logger = LoggerFactory.getLogger(PizzeriaClientConnecteConsoleApp.class);
	private static Client client = null;
	private String choice = null;
	private static MenuFactory menu = new MenuFactory();
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
	public void displayException (String e)
	{
		logger.info(e);
	}

	public static void set(Client c)
	{
		client = c;
	}

	@Override
	public void displayMenu()
	{
		IPizzeriaConsole.clean();
		logger.info("***** Pizzeria Client Connecté *****");
		logger.info("1.  Passer une nouvelle commande");
		logger.info("2.  Lister ses commandes");
		logger.info("99. Quitter l'application");
		logger.info("\nVeuillez saisir votre choix : ");
	}

	@Override
	public void choixMenu(Scanner questionUser) throws StockageException
	{
		if (Integer.parseInt(choice) == 1)
		{
			PasserCommandeClientService c = (PasserCommandeClientService) menu.create("passerCommandeClient");
			PasserCommandeClientService.set(client);
			c.executeUC(questionUser);
		}
		else if (Integer.parseInt(choice) == 2)
		{
			ListerCommandesClientService l = (ListerCommandesClientService) menu
					.create("listerCommandesClient");
			ListerCommandesClientService.set(client);
			l.executeUC(questionUser);
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
