/**
 * 
 */
package fr.pizzeria.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.CommandesJpaDao;
import fr.pizzeria.dao.LivreurJpaDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Livreur;

/**
 *
 * @author BIRABEN-BIANCHI Hugo
 */
public class AjouterLivreurService extends MenuService
{
	CommandesJpaDao cJpaDao = new CommandesJpaDao ();
	LivreurJpaDao lJpaDao = new LivreurJpaDao ();
	
	@Override
	public void executeUC(Scanner scanner) throws StockageException
	{
		clean ();
		int choiceCommande = -1;
		while (choiceCommande == -1)
		{
			try
			{
				ListerCommandesAttenteService l = new ListerCommandesAttenteService ();
				l.removePrecision();
				l.executeUC(scanner);
				System.out.println("Veuillez saisir le numero de la commande");
				choiceCommande = Integer.parseInt(scanner.nextLine());
			}
			catch (NumberFormatException e)
			{
				choiceCommande = -1;
			}
		}
		
		int choiceLivreur = -1;
		while (choiceLivreur == -1)
		{
			try
			{
				List<Livreur> listLivreur = new ArrayList <> ();
				listLivreur = lJpaDao.listLivreur();
				listLivreur.forEach(t -> t.displayComplet ());
				System.out.println("Veuillez attribuer un livreur à la commande");
				choiceLivreur = Integer.parseInt(scanner.nextLine());
			}
			catch (NumberFormatException e)
			{
				choiceLivreur = -1;
			}
		}
		
		cJpaDao.associerLivreurCommande(choiceCommande, choiceLivreur);
	}

}
