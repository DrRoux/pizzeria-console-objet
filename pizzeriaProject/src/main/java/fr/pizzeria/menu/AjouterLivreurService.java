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
		System.out.println("Veuillez saisir le numero de la commande");
		ListerAttenteService l = new ListerAttenteService ();
		l.executeUC(scanner);
		int choiceCommande = Integer.parseInt(scanner.nextLine());
		
		List<Livreur> listLivreur = new ArrayList <> ();
		listLivreur = lJpaDao.listLivreur();
		listLivreur.forEach(t -> t.displayComplet ());
		System.out.println("Veuillez attribuer un livreur à la commande");
		int choiceLivreur = Integer.parseInt(scanner.nextLine());
		
		cJpaDao.associerLivreurCommande(choiceCommande, choiceLivreur);
	}

}
