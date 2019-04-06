package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.exception.PersonnalSqlException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.menu.CommandeClientService;
import fr.pizzeria.menu.ListerClientConnecteService;
import fr.pizzeria.menu.MenuFactory;
import fr.pizzeria.model.Client;

public class PizzeriaClientConnecteConsoleApp implements IPizzeriaConsole
{
	static Client client = null;
	
	public void display(Scanner questionUser) 
	{
		String choice = "0";
		MenuFactory menu = new MenuFactory ();
		boolean sortiBoucle = false;
		
		clean ();
		
		while (sortiBoucle == false)
		{
			System.out.println("***** Pizzeria Client Connecté *****");
			System.out.println("1.  Passer une nouvelle commande");
			System.out.println("2.  Lister ses commandes");
			System.out.println("99. Quitter l'application");
			System.out.println("\nVeuillez saisir votre choix : ");
			
			choice = questionUser.nextLine();
			
			try
			{
				if (Integer.parseInt(choice) == 1)
				{
					CommandeClientService c =(CommandeClientService) menu.create("commander");
					c.set(client);
					c.executeUC(questionUser);
				}
				else if (Integer.parseInt(choice) == 2)
				{
					ListerClientConnecteService l = (ListerClientConnecteService) menu.create("listerClientConnecte");
					l.set(client);
					l.executeUC(questionUser);
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
	
	public void set (Client c)
	{
		client = c;
	}

}
