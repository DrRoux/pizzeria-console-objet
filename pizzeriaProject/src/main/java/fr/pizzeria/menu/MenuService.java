package fr.pizzeria.menu;

import java.util.Scanner;
import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaBddDao;
import fr.pizzeria.exception.*;

/**
 * @author BIRABEN-BIANCHI Hugo
 */
public abstract class MenuService  
{
	protected static IPizzaDao gestionnairePizza = new PizzaBddDao ();
		
	public abstract void executeUC (Scanner scanner) throws StockageException;
}
