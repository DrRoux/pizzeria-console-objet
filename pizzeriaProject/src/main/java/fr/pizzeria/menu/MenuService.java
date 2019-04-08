package fr.pizzeria.menu;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaJpaDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.logger.ILogger;

/**
 * @author BIRABEN-BIANCHI Hugo
 */
public abstract class MenuService implements ILogger
{
	protected static IPizzaDao gestionnairePizza = new PizzaJpaDao();

	public abstract void executeUC(Scanner scanner) throws StockageException;

	public void clean()
	{
		for (int i = 0; i < 40; i++)
		{
			System.out.println(" ");
		}
	}
}
