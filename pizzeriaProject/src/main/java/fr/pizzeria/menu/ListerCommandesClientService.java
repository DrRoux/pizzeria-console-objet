package fr.pizzeria.menu;

import java.util.Scanner;

import fr.pizzeria.dao.CommandesJpaDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Client;

public class ListerCommandesClientService extends MenuService
{
	CommandesJpaDao cJpaDao = new CommandesJpaDao();
	static Client client;

	@Override
	public void executeUC(Scanner scanner) throws StockageException
	{
		clean();
		System.out.println("Voici la liste détaillée de vos commandes !");
		cJpaDao.listerCommandesClient(client).forEach(t -> t.afficherCommandesClient());
		System.out.println("Veuillez presser la touche entrée pour continuer");
		scanner.nextLine();
	}

	public static void set(Client c)
	{
		client = c;
	}
}
