package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.menu.MenuFactory;

/**
 * Cette classe permet de gérer le menu d'affichage
 * de l'application.
 * @author BIRABEN-BIANCHI Hugo
 */
public class PizzeriaAdminConsoleApp 
{
	private Scanner questionUser;
	
	public void display() 
	{
		String choice = "0";
		questionUser = new Scanner (System.in);
		
		MenuFactory menu = new MenuFactory ();
		
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
			
			choice = questionUser.nextLine();
			
			try
			{
				if (Integer.parseInt(choice) == 1)
				{
					menu.create("list").executeUC(questionUser);
				}
				else if (Integer.parseInt(choice) == 2)
				{
					menu.create("ajout").executeUC(questionUser);
				}
				else if (Integer.parseInt(choice) == 3)
				{
					menu.create("modif").executeUC(questionUser);
				}
				else if (Integer.parseInt(choice) == 4)
				{
					menu.create("suppr").executeUC(questionUser);			
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
			//*
			}
			catch (NumberFormatException e)
			{
				choice = "0";
			}
			catch (SavePizzaException e)
			{
				System.out.println(e.getMessage());
				
				if (e.getMessage().equals("codeTropCourt"))
					System.out.println();
			}
			catch (Exception e)
			{
				
			}
			//*/
			
		}
		
		questionUser.close ();
		System.out.println("FIN DE L'APPLICATION AVEC SUCCES !");
	}

}
