package fr.pizzeria.console;

import java.util.Scanner;
import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp 
{
	private static Scanner questionUser;
	
	public static void main(String[] args) 
	{
		String choice = "0";
		questionUser = new Scanner (System.in);
		
		Pizza [] tableauPizza = new Pizza [100];
		tableauPizza[0] = new Pizza ("PEP",  "Pépéroni", 	 12.50);
		tableauPizza[1] = new Pizza ("MAR",  "Margherita", 	 14.00);
		tableauPizza[2] = new Pizza ("REIN", "La Reine", 	 11.50);
		tableauPizza[3] = new Pizza ("FRO",  "La 4 Fromage", 12.00);
		tableauPizza[4] = new Pizza ("CAN",  "La cannibale", 12.50);
		tableauPizza[5] = new Pizza ("SAV",  "La savoyarde", 13.00);
		tableauPizza[6] = new Pizza ("ORI",  "L’orientale",  13.50);
		tableauPizza[7] = new Pizza ("IND",  "L’indienne", 	 14.00);
		int tailleTableau = 8;
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
				System.out.println("Liste des pizzas : ");
				
				for (Pizza pizza : tableauPizza)
					if (pizza != null)
						pizza.affichage();
				
				System.out.println(" ");	
			}
			else if (Integer.parseInt(choice) == 2)
			{
				System.out.println("Ajout d'une nouvelle pizza : ");
				tableauPizza[tailleTableau] = new Pizza ();
				tableauPizza[tailleTableau].modifPizza();
				tailleTableau++;
			}
			else if (Integer.parseInt(choice) == 3)
			{
				System.out.println("Mise à jour d'une pizza : ");
				System.out.println("Veuillez choisir le code de la pizza à modifier : ");
				choice = questionUser.nextLine().toUpperCase();
				System.out.println(choice);
				
				for (Pizza pizza : tableauPizza)
				{
					if (pizza != null)
						if (pizza.getCode().equals(choice))
							pizza.modifPizza ();
				}
			}
			else if (Integer.parseInt(choice) == 4)
			{
				System.out.println("Suppression d'une pizza : ");
				System.out.println("Veuillez choisir le code de la pizza à supprimer : ");
				choice = questionUser.nextLine().toUpperCase();
				System.out.println(choice);
				
				for (int i = 0; i < tableauPizza.length; i++)
				{
					if (tableauPizza[i] != null)
						if (tableauPizza[i].getCode().equals(choice))
							tableauPizza[i] = null;
				}
				
			}
			else if (Integer.parseInt(choice) == 99)
			{
				System.out.println("Aurevoir :(");
				sortiBoucle = true;
			}
			else
			{
				System.out.println("Choix invalide, veuillez recommencer !");
			}
			
		}
	}

}
