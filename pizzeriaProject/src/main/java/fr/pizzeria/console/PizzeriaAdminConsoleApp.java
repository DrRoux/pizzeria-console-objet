package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.exception.PersonnalSqlException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.menu.MenuFactory;

/**
 * Cette classe permet de gérer le menu d'affichage
 * de l'application.
 * @author BIRABEN-BIANCHI Hugo
 */
public class PizzeriaAdminConsoleApp implements IPizzeriaConsole
{
	@Override
	public void display(Scanner questionUser) 
	{
		String choice = "0";
		
		MenuFactory menu = new MenuFactory ();
		
		boolean sortiBoucle = false;
		
		while (sortiBoucle == false)
		{
			System.out.println("***** Pizzeria Administration *****");
			System.out.println("1.  Lister les pizzas ");
			System.out.println("2.  Ajouter une nouvelle pizza");
			System.out.println("3.  Mettre à jour une pizza");
			System.out.println("4.  Supprimer une pizza");
			System.out.println("5.  Lister toutes les commandes non traitées");
			System.out.println("6.  Ajouter un livreur");
			System.out.println("7.  Expédier une commande");
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
				else if (Integer.parseInt(choice) == 5)
				{
					menu.create("listerAttente").executeUC(questionUser);			
				}
				else if (Integer.parseInt(choice) == 6)
				{
					menu.create("ajouterLivreur").executeUC(questionUser);			
				}
				else if (Integer.parseInt(choice) == 7)
				{
					menu.create("expedierCommande").executeUC(questionUser);			
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
			catch (SavePizzaException e)
			{
				System.out.println(e.getMessage());
				
				if (e.getMessage().equals("codeTropCourt"))
				{
					System.out.println();
				}
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
