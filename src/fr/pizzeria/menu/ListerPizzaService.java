/**
 * 
 */
package fr.pizzeria.menu;

import java.util.List;
import java.util.Scanner;
import fr.pizzeria.model.Pizza;;

/**
 * @author BIRABEN-BIANCHI Hugo
 *
 */
public class ListerPizzaService extends MenuService
{

	@Override
	public void executeUC(Scanner scanner)
	{
		System.out.println("Liste des pizzas : ");
		
		List<Pizza> pizzas = gestionnairePizza.findAllPizzas();
		for (Pizza pi : pizzas)
			if (pi != null)
				System.out.println(pi);
		
		System.out.println(" ");	
	}

}
