/**
 * 
 */
package fr.pizzeria.menu;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.model.Pizza;

/**
 * @author BIRABEN-BIANCHI Hugo
 *
 */
public class ListerPizzaService extends MenuService
{

	@Override
	public void executeUC(Scanner scanner)
	{
		logger.info("Liste des pizzas : ");

		List<Pizza> pizzas = getGestionnairePizza().findAllPizzas();

		for (Pizza pi : pizzas)
		{
			String string = pi.toString();
			logger.info(string);
		}

		logger.info(" ");
	}

}
