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
import fr.pizzeria.model.Pizza;

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
		Commande commande = new Commande ();
		String choice = "0";
		
		List <Pizza> listPizza = gestionnairePizza.findAllPizzas();
		
		boolean sortiBoucle = false;
		
		while (sortiBoucle == false)
		{
			System.out.println("***** Commande en cours *****");
			System.out.println("1.  Commander une pizza");
			System.out.println("2.  Consulter sa commande en cours");
			System.out.println("99. Finaliser votre commande");
			System.out.println("\nVeuillez saisir votre choix : ");
			
			choice = scanner.nextLine();
			
			try
			{
				if (Integer.parseInt(choice) == 1)
				{
					String choice2 = null;
					System.out.println("Choix d'une pizza : ");
					
					System.out.println(listPizza);
					
					while (gestionnairePizza.pizzaExists(choice2) != true)
					{	
						System.out.println("Veuillez choisir le code de la pizza à commander : ");
						choice2 = scanner.nextLine().toUpperCase();
					}
					
					commande.setListComPiz(gestionnairePizza.findPizzaByCode(choice2));
					
				}
				else if (Integer.parseInt(choice) == 2)
				{
					System.out.println(commande);
				}
				else if (Integer.parseInt(choice) == 99)
				{
					sortiBoucle = true;
					cJpaDao.ajoutCommande(client, commande);
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
