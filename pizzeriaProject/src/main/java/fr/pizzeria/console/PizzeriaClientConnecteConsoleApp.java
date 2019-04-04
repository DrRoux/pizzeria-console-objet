package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.exception.PersonnalSqlException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.menu.MenuFactory;
import fr.pizzeria.model.Client;

public class PizzeriaClientConnecteConsoleApp implements PizzeriaConsole
{
	public void display(Scanner questionUser, Client client) 
	{
		String choice = "0";
		
		MenuFactory menu = new MenuFactory ();
		
		boolean sortiBoucle = false;
		
		while (sortiBoucle == false)
		{
			System.out.println("***** Pizzeria Client Connecté *****");
			System.out.println("1.  Commander une pizza");
			System.out.println("2.  Lister ses commandes");
			System.out.println("99. Quitter l'application");
			System.out.println("\nVeuillez saisir votre choix : ");
			
			choice = questionUser.nextLine();
			
			try
			{
				if (Integer.parseInt(choice) == 1)
				{
					menu.create("commander").executeUC(questionUser);
				}
				else if (Integer.parseInt(choice) == 2)
				{
					menu.create("listerClientConnecte").executeUC(questionUser);
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
			catch (StockageException e)
			{
				System.out.println(e.getMessage());
			}
			catch (PersonnalSqlException e) 
			{
				System.out.println(e.getMessage());
			}
		}
		
	}

}
