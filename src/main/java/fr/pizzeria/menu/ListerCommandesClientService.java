package fr.pizzeria.menu;

import java.util.Scanner;

import fr.pizzeria.dao.CommandesJpaDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Commande;

public class ListerCommandesClientService extends MenuService
{
	CommandesJpaDao cJpaDao = new CommandesJpaDao();
	static Client client;

	@Override
	public void executeUC(Scanner scanner) throws StockageException
	{
		clean();
		logger.info("Voici la liste détaillée de vos commandes !");
		cJpaDao.listerCommandesClient(client).forEach(Commande::afficherCommandesClient);
		logger.info("Veuillez presser la touche entrée pour continuer");
		scanner.nextLine();
	}

	public static void set(Client c)
	{
		client = c;
	}
}
