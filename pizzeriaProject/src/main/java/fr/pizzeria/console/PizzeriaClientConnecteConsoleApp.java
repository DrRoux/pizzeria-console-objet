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
	protected static Logger logger = LoggerFactory.getLogger(PizzeriaClientConnecteConsoleApp.class);
	static Client client = null;

	@Override
	public void display(Scanner questionUser)
	{
		String choice;
		MenuFactory menu = new MenuFactory();
		boolean sortiBoucle = false;

		while (!sortiBoucle)
		{
			clean();
			logger.info("***** Pizzeria Client Connecté *****");
			logger.info("1.  Passer une nouvelle commande");
			logger.info("2.  Lister ses commandes");
			logger.info("99. Quitter l'application");
			logger.info("\nVeuillez saisir votre choix : ");

			choice = questionUser.nextLine();

			try
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

	public static void set(Client c)
	{
		client = c;
	}

}
