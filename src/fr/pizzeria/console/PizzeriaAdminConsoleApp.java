package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.menu.MenuFactory;

public class PizzeriaAdminConsoleApp 
{
	private static Scanner questionUser;
	
	
	public static void main(String[] args) 
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
			
		}
		
		questionUser.close ();
		System.out.println("FIN DE L'APPLICATION AVEC SUCCES !");
	}

}
