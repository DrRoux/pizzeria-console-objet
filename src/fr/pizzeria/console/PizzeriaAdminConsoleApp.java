package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.model.*;

public class PizzeriaAdminConsoleApp 
{
	private static Scanner questionUser;
	private static PizzaMemDao gestionnairePizza;
	
	public static void main(String[] args) 
	{
		String choice = "0";
		questionUser = new Scanner (System.in);
		gestionnairePizza = new PizzaMemDao ();
		
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
				gestionnairePizza.displayList ();
				System.out.println(" ");	
			}
			else if (Integer.parseInt(choice) == 2)
			{
				System.out.println("Ajout d'une nouvelle pizza : ");
				
				System.out.println("Veuillez saisir le code :");
				String choiceCode = questionUser.nextLine();
				
				System.out.println("Veuillez saisir le nom (sans espace):");
				String choiceLibelle = questionUser.nextLine();
				
				System.out.println("Veuillez saisir le prix :");
				String choiceTempString = questionUser.nextLine();
				double choicePrice = Double.parseDouble(choiceTempString);
				
				gestionnairePizza.saveNewPizza(new Pizza (choiceCode, choiceLibelle, choicePrice));
				
			}
			else if (Integer.parseInt(choice) == 3)
			{
				System.out.println("Mise à jour d'une pizza : ");
				System.out.println("Veuillez choisir le code de la pizza à modifier : ");
				choice = questionUser.nextLine();
				System.out.println(choice);
				
				System.out.println("Veuillez saisir le code :");
				String choiceCode = questionUser.nextLine();
				
				System.out.println("Veuillez saisir le nom (sans espace):");
				String choiceLibelle = questionUser.nextLine();
				
				System.out.println("Veuillez saisir le prix :");
				String choiceTempString = questionUser.nextLine();
				double choicePrice = Double.parseDouble(choiceTempString);
				
				gestionnairePizza.updatePizza(choice, new Pizza (choiceCode, choiceLibelle, choicePrice));
				
			}
			else if (Integer.parseInt(choice) == 4)
			{
				System.out.println("Suppression d'une pizza : ");
				System.out.println("Veuillez choisir le code de la pizza à supprimer : ");
				choice = questionUser.nextLine();
				System.out.println(choice);
				
				gestionnairePizza.deletePizza(choice);				
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
