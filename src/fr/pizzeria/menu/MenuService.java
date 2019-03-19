package fr.pizzeria.menu;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaMemDao;

/**
 * @author BIRABEN-BIANCHI Hugo
 *
 */
public abstract class MenuService
{
	protected static PizzaMemDao gestionnairePizza = new PizzaMemDao ();;
	
	abstract void executeUC (Scanner scanner);
}
