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
public class PasserCommandeClientService extends MenuService
{
	CommandesJpaDao cJpaDao = new CommandesJpaDao();
	static Client client;

	@Override
	public void executeUC(Scanner scanner) throws StockageException
	{
		Commande commande = new Commande();
		String choice = "0";

		List<Pizza> listPizza = getGestionnairePizza().findAllPizzas();

		boolean sortiBoucle = false;

		while (sortiBoucle == false)
		{
			clean ();
			
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

					listPizza.forEach(t -> t.afficherPizza());

					while (getGestionnairePizza().pizzaExists(choice2) != true)
					{
						System.out.println("Veuillez choisir le code de la pizza à commander : ");
						choice2 = scanner.nextLine().toUpperCase();
					}
					
					boolean doublon = false;
					
					for (Pizza p : commande.getListComPiz())
					{
						if (p.getCode().equals(choice2))
						{
							doublon = true;
							break;
						}
					}
					
					if (doublon == false)
					{
						commande.setListComPiz(getGestionnairePizza().findPizzaByCode(choice2));
					}
					else
					{
						System.out.println("Impossible d'ajouter une pizza en double !");
					}
				}
				else if (Integer.parseInt(choice) == 2)
				{
					commande.afficherCommandesClient();
					System.out.println("Veuillez presser la touche entrée pour continuer");
					scanner.nextLine();
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

	public void set(Client c)
	{
		client = c;
	}
}
