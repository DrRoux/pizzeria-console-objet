/**
 * 
 */
package fr.pizzeria.menu;

import java.util.Scanner;

import fr.pizzeria.dao.CommandesJpaDao;
import fr.pizzeria.exception.StockageException;

/**
 *
 * @author BIRABEN-BIANCHI Hugo
 */
public class ExpedierCommandeService extends MenuService
{
	CommandesJpaDao cJpaDao = new CommandesJpaDao ();
	
	@Override
	public void executeUC(Scanner scanner) throws StockageException
	{
		cJpaDao.expedierCommande();		
	}

}
