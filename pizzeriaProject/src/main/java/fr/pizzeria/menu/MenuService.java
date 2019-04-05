package fr.pizzeria.menu;

import java.util.Scanner;
import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaJpaDao;
import fr.pizzeria.exception.*;

/**
 * @author BIRABEN-BIANCHI Hugo
 */
public abstract class MenuService implements ISet
{
	protected static IPizzaDao gestionnairePizza = new PizzaJpaDao ();
		
	public abstract void executeUC (Scanner scanner) throws StockageException;
}
