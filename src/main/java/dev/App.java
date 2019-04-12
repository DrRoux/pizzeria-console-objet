package dev;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.console.PizzeriaAdminConsoleApp;
import fr.pizzeria.console.PizzeriaClientConsoleApp;

/**
 * App : Classe contenant le point d'entrée du programme (main). Propose un menu
 * permettant de se rendre dans la partie cliente ou administrateur de
 * l'application.
 * 
 * @author BIRABEN-BIANCHI Hugo
 */
public class App
{
	private static PizzeriaAdminConsoleApp appAdmin = new PizzeriaAdminConsoleApp();
	private static PizzeriaClientConsoleApp appClient = new PizzeriaClientConsoleApp();
	private static Logger logger = LoggerFactory.getLogger(App.class);

	public static void main(String[] args)
	{
		Scanner userChoice = new Scanner(System.in);
		String choice = null;

		boolean sortiBoucle = false;

		while (!sortiBoucle)
		{
			for (int i = 0; i < 40; i++)
			{
				logger.info("\n");
			}

			logger.info("***** Accueil de la pizzeria *****");
			logger.info("1.  Client ");
			logger.info("2.  Administration");
			logger.info("99. Quitter l'application");
			logger.info("\nVeuillez saisir votre choix : ");

			choice = userChoice.nextLine();

			try
			{
				if (Integer.parseInt(choice) == 1)
				{
					appClient.display(userChoice);
				}
				else if (Integer.parseInt(choice) == 2)
				{
					appAdmin.display(userChoice);
				}
				else if (Integer.parseInt(choice) == 99)
				{
					logger.info("Aurevoir ☻");
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
			catch (Exception e)
			{
				logger.error(e.getMessage());
			}
		}

		logger.info("FIN DE L'APPLICATION AVEC SUCCES !");
	}
}
