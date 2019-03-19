package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.menu.*;
import fr.pizzeria.model.*;

public class PizzeriaAdminConsoleApp 
{
	private static Scanner questionUser;
	
	
	public static void main(String[] args) 
	{
		String choice = "0";
		questionUser = new Scanner (System.in);
		ListerPizzaService list = new ListerPizzaService ();
		AjouterPizzaService ajout = new AjouterPizzaService ();
		ModifierPizzaService modif = new ModifierPizzaService ();
		SupprimerPizzaService suppr = new SupprimerPizzaService ();
		
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
				list.executeUC(questionUser);
			}
			else if (Integer.parseInt(choice) == 2)
			{
				ajout.executeUC(questionUser);
			}
			else if (Integer.parseInt(choice) == 3)
			{
				modif.executeUC(questionUser);
			}
			else if (Integer.parseInt(choice) == 4)
			{
				suppr.executeUC(questionUser);			
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
