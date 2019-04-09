/**
 * 
 */
package fr.pizzeria.menu;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.CommandesJpaDao;
import fr.pizzeria.dao.LivreurJpaDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Commande;
import fr.pizzeria.model.Livreur;

/**
 *
 * @author BIRABEN-BIANCHI Hugo
 */
public class AjouterLivreurService extends MenuService
{
	CommandesJpaDao cJpaDao = new CommandesJpaDao();
	LivreurJpaDao lJpaDao = new LivreurJpaDao();

	@Override
	public void executeUC(Scanner scanner) throws StockageException
	{
		clean();

		int choiceCommande = -1;
		boolean sortir = false;

		while (choiceCommande == -1 && !sortir)
		{
			try
			{
				ListerCommandesAttenteService l = new ListerCommandesAttenteService();
				ListerCommandesAttenteService.removePrecision();
				l.executeUC(scanner);
				System.out.println("Veuillez saisir le numero de la commande");
				choiceCommande = Integer.parseInt(scanner.nextLine());

				List<Commande> listeCommande = cJpaDao.listerCommandesAttente();
				for (Commande c : listeCommande)
				{
					if (c.getId() == choiceCommande)
					{
						sortir = true;
						break;
					}
				}

				if (!sortir)
				{
					choiceCommande = -1;
				}
			}
			catch (NumberFormatException e)
			{
				choiceCommande = -1;
			}
		}

		sortir = false;
		int choiceLivreur = -1;
		while (choiceLivreur == -1 && !sortir)
		{
			try
			{
				List<Livreur> listLivreur = lJpaDao.listLivreur();
				listLivreur.forEach(t -> t.displayComplet());
				System.out.println("Veuillez attribuer un livreur à la commande");
				choiceLivreur = Integer.parseInt(scanner.nextLine());

				for (Livreur l : listLivreur)
				{
					if (l.getId() == choiceLivreur)
					{
						sortir = true;
						break;
					}
				}

				if (!sortir)
				{
					choiceLivreur = -1;
				}
			}
			catch (NumberFormatException e)
			{
				choiceLivreur = -1;
			}
		}

		cJpaDao.associerLivreurCommande(choiceCommande, choiceLivreur);
	}

}
