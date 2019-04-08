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
	private static Logger LOG = LoggerFactory.getLogger(App.class);

	public static void main(String[] args)
	{
		Scanner userChoice = new Scanner(System.in);
		String choice = null;

		boolean sortiBoucle = false;

		while (sortiBoucle == false)
		{
			for (int i = 0; i < 40; i++)
			{
				System.out.println(" ");
			}
			
			System.out.println("***** Accueil de la pizzeria *****");
			System.out.println("1.  Client ");
			System.out.println("2.  Administration");
			System.out.println("99. Quitter l'application");
			System.out.println("\nVeuillez saisir votre choix : ");

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
					System.out.println("Aurevoir ☻");
					sortiBoucle = true;
				}
				else
				{
					System.out.println("Choix invalide, veuillez recommencer !");
				}
			}
			catch (NumberFormatException e)
			{
				choice = "0";
			}
			catch (Exception e)
			{
				LOG.error(e.getMessage());
			}
		}

		System.out.println("FIN DE L'APPLICATION AVEC SUCCES !");
	}
}
