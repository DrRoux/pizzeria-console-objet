/**
 * 
 */
package fr.pizzeria.menu;

import java.util.Scanner;

import fr.pizzeria.dao.CommandesJpaDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Commande;

/**
 *
 * @author BIRABEN-BIANCHI Hugo
 */
public class ListerCommandesAttenteService extends MenuService
{
	CommandesJpaDao cJpaDao = new CommandesJpaDao();
	static boolean precision = false;

	@Override
	public void executeUC(Scanner scanner) throws StockageException
	{
		if (!precision)
		{
			cJpaDao.listerCommandesAttente().forEach(Commande::afficherListeAttente);
		}
		else
		{
			clean();
			logger.info("Voici la liste des commandes en attente !");
			cJpaDao.listerCommandesAttente().forEach(Commande::afficherListeAttente);
			logger.info("Veuillez presser la touche entrée pour continuer");
			scanner.nextLine();
		}
	}

	public static void addPrecision()
	{
		precision = true;
	}

	public static void removePrecision()
	{
		precision = false;
	}
}
