package fr.pizzeria.menu;

import java.util.Scanner;

import fr.pizzeria.dao.CommandesJpaDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Client;

public class ListerClientConnecteService extends MenuService
{
	CommandesJpaDao cJpaDao = new CommandesJpaDao ();
	static Client client;
	
	@Override
	public void executeUC (Scanner scanner) throws StockageException 
	{
		cJpaDao.listerCommandes (client);
	}
	
	public <T> void set (T c)
	{
		client = (Client)c;
	}
}
