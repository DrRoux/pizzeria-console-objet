package fr.pizzeria.menu;

import java.util.Scanner;

import fr.pizzeria.dao.CommandesJpaDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Client;

public class ListerClientConnecteService extends MenuService
{
	CommandesJpaDao cJpaDao = new CommandesJpaDao ();
	Client client = null;
	
	@Override
	public void executeUC (Scanner scanner) throws StockageException 
	{
		cJpaDao.beginConnexionBdd();
		cJpaDao.listerCommandes (client).forEach(t->System.out.println(t));
		cJpaDao.beginConnexionBdd();
	}
}
