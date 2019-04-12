/**
 * 
 */
package fr.pizzeria.menu;

import java.util.Scanner;

import fr.pizzeria.console.PizzeriaCommandeEnCours;
import fr.pizzeria.dao.CommandesJpaDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Client;

/**
 *
 * @author BIRABEN-BIANCHI Hugo
 */
public class PasserCommandeClientService extends MenuService
{
	CommandesJpaDao cJpaDao = new CommandesJpaDao();
	static Client client;
	PizzeriaCommandeEnCours p = new PizzeriaCommandeEnCours ();
	
	@Override
	public void executeUC(Scanner scanner) throws StockageException
	{	
		PizzeriaCommandeEnCours.setClient (client);
		PizzeriaCommandeEnCours.setListPizza(getGestionnairePizza().findAllPizzas());
		p.display(scanner);
	}

	public static void set(Client c)
	{
		client = c;
	}
}
