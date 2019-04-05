/**
 * 
 */
package fr.pizzeria.menu;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.CommandesJpaDao;
import fr.pizzeria.exception.PersonnalSqlException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Commande;

/**
 *
 * @author BIRABEN-BIANCHI Hugo
 */
public class CommandeClientService extends MenuService
{
	CommandesJpaDao cJpaDao = new CommandesJpaDao ();
	static Client client;
	
	@Override
	public void executeUC(Scanner scanner) throws StockageException
	{
		List <Commande> a;
		String choice = "0";
		
		boolean sortiBoucle = false;
		
		while (sortiBoucle == false)
		{
			System.out.println("***** Commande en cours *****");
			System.out.println("1.  Commander une pizza");
			System.out.println("2.  Consulter sa commande en cours");
			System.out.println("99. Quitter l'application");
			System.out.println("\nVeuillez saisir votre choix : ");
			
			choice = scanner.nextLine();
			
			try
			{
				if (Integer.parseInt(choice) == 1)
				{
					
				}
				else if (Integer.parseInt(choice) == 2)
				{
					System.out.println();
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
			catch (PersonnalSqlException e) 
			{
				System.out.println(e.getMessage());
			}
		}
	}
	
	public <T> void set (T c)
	{
		client = (Client)c;
	}
}
