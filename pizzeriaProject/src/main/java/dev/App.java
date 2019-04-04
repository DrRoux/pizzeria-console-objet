package dev;

import java.util.Scanner;

import fr.pizzeria.console.*;
import fr.pizzeria.exception.PersonnalSqlException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;

/**
 * Hello world!
 *
 */
public class App 
{
	private static PizzeriaAdminConsoleApp appAdmin = new PizzeriaAdminConsoleApp ();
	private static PizzeriaClientConsoleApp appClient = new PizzeriaClientConsoleApp ();
	
    public static void main( String[] args )
    {
    	Scanner userChoice = new Scanner (System.in);
    	String choice = null;
    	
    	boolean sortiBoucle = false;
		
		while (sortiBoucle == false)
		{
			System.out.println("***** Pizzeria Administration *****");
			System.out.println("1.  Lister les pizzas ");
			System.out.println("2.  Ajouter une nouvelle pizza");
			System.out.println("3.  Mettre à jour une pizza");
			System.out.println("4.  Supprimer une pizza");
			System.out.println("99. Quitter l'application");
			System.out.println("\nVeuillez saisir votre choix : ");
			
			choice = userChoice.nextLine();
			
			try
			{
				if (Integer.parseInt(choice) == 1)
				{
					appAdmin.display (userChoice);
				}
				else if (Integer.parseInt(choice) == 2)
				{
					appClient.display (userChoice);
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
		}
    	
    }
}
