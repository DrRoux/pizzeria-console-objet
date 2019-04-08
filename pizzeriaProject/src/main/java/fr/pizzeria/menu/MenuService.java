package fr.pizzeria.menu;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaJpaDao;
import fr.pizzeria.exception.StockageException;

/**
 * @author BIRABEN-BIANCHI Hugo
 */
public abstract class MenuService
{
	static Logger LOG = LoggerFactory.getLogger(MenuService.class);

	private static IPizzaDao gestionnairePizza = new PizzaJpaDao();

	public abstract void executeUC(Scanner scanner) throws StockageException;

	public void clean()
	{
		for (int i = 0; i < 40; i++)
		{
			System.out.println(" ");
		}
	}

	/**
	 * Getter
	 * @return the gestionnairePizza
	 */
	public static IPizzaDao getGestionnairePizza()
	{
		return gestionnairePizza;
	}

	/**
	 * Setter
	 * @param gestionnairePizza the gestionnairePizza to set
	 */
	public static void setGestionnairePizza(IPizzaDao gestionnairePizza)
	{
		MenuService.gestionnairePizza = gestionnairePizza;
	}
}
