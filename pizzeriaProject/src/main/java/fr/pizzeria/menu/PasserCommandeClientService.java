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
		String choice;

		List<Pizza> listPizza = getGestionnairePizza().findAllPizzas();

		boolean sortiBoucle = false;

		while (!sortiBoucle)
		{
			clean();

			logger.info("***** Commande en cours *****");
			logger.info("1.  Commander une pizza");
			logger.info("2.  Consulter sa commande en cours");
			logger.info("99. Finaliser votre commande");
			logger.info("\nVeuillez saisir votre choix : ");

			choice = scanner.nextLine();

			try
			{
				if (Integer.parseInt(choice) == 1)
				{
					String choice2 = null;
					logger.info("Choix d'une pizza : ");

					listPizza.forEach(t -> t.afficherPizza());

					while (!getGestionnairePizza().pizzaExists(choice2))
					{
						logger.info("Veuillez choisir le code de la pizza à commander : ");
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

					if (!doublon)
					{
						commande.setListComPiz(getGestionnairePizza().findPizzaByCode(choice2));
					}
					else
					{
						logger.info("Impossible d'ajouter une pizza en double !");
					}
				}
				else if (Integer.parseInt(choice) == 2)
				{
					commande.afficherCommandesClient();
					logger.info("Veuillez presser la touche entrée pour continuer");
					scanner.nextLine();
				}
				else if (Integer.parseInt(choice) == 99)
				{
					sortiBoucle = true;
					cJpaDao.ajoutCommande(client, commande);
				}
				else
				{
					logger.info("Choix invalide, veuillez recommencer !");
				}
			}
			catch (NumberFormatException e)
			{
				// Fait boucler le programme sans interaction de l'utilisateur
			}
			catch (PersonnalSqlException e)
			{
				logger.info(e.getMessage());
			}
		}
	}

	public static void set(Client c)
	{
		client = c;
	}
}
