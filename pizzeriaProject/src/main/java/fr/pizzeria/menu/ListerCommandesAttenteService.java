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
public class ListerCommandesAttenteService extends MenuService
{
	CommandesJpaDao cJpaDao = new CommandesJpaDao ();
	static boolean precision = false;
	
	@Override
	public void executeUC(Scanner scanner) throws StockageException
	{
		if (precision == false)
		{	
			cJpaDao.listerCommandesAttente().forEach(t->t.afficherListeAttente());
		}
		else 
		{
			clean ();
			System.out.println("Voici la liste des commandes en attente !");
			cJpaDao.listerCommandesAttente().forEach(t->t.afficherListeAttente());
			System.out.println("Veuillez presser la touche entrée pour continuer");
			scanner.nextLine();
		}
	}
	
	public void addPrecision ()
	{
		precision = true;
	}
	
	public void removePrecision ()
	{
		precision = false;
	}
}
