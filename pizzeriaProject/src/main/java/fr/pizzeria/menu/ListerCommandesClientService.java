package fr.pizzeria.menu;

import java.util.Scanner;

import fr.pizzeria.dao.CommandesJpaDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Client;

public class ListerCommandesClientService extends MenuService
{
	CommandesJpaDao cJpaDao = new CommandesJpaDao ();
	static Client client;
	
	@Override
	public void executeUC (Scanner scanner) throws StockageException 
	{
		clean ();
		System.out.println("Liste de vos commandes détaillées");
		cJpaDao.listerCommandesClient (client).forEach(t->t.afficherCommandesClient());
	}
	
	public void set (Client c)
	{
		client = c;
	}
}
