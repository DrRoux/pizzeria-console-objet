/**
 * 
 */
package fr.pizzeria.menu;

import java.util.List;
import java.util.Scanner;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.utils.*;

/**
 * @author BIRABEN-BIANCHI Hugo
 *
 */
public class ListerPizzaService extends MenuService
{

	@Override
	public void executeUC(Scanner scanner)
	{
		StringUtils s = new StringUtils ();
		
		System.out.println("Liste des pizzas : ");
		
		List<Pizza> pizzas = gestionnairePizza.findAllPizzas();
		for (Pizza pi : pizzas)
		{
			s.setAttribut(pi);
			System.out.println(s);
			//System.out.println(pi);
		}
				
		
		System.out.println(" ");	
	}

}
