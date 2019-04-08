package fr.pizzeria.menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Cette classe permet d'instancier les types de menu selon une clé String
 * 
 * @author BIRABEN-BIANCHI Hugo
 */
public class MenuFactory
{
	static Logger LOG = LoggerFactory.getLogger(MenuFactory.class);

	public MenuService create(String typeMenu)
	{
		MenuService retour = null;

		// Administration
		if (typeMenu.equals("list"))
		{
			retour = new ListerPizzaService();
		}
		else if (typeMenu.equals("ajout"))
		{
			retour = new AjouterPizzaService();
		}
		else if (typeMenu.equals("modif"))
		{
			retour = new ModifierPizzaService();
		}
		else if (typeMenu.equals("suppr"))
		{
			retour = new SupprimerPizzaService();
		}
		else if (typeMenu.equals("listerCommandesAttente"))
		{
			retour = new ListerCommandesAttenteService();
		}
		else if (typeMenu.equals("ajouterLivreur"))
		{
			retour = new AjouterLivreurService();
		}
		else if (typeMenu.equals("expedierCommande"))
		{
			retour = new ExpedierCommandeService();
		}
		// Visiteurs de l'application
		else if (typeMenu.equals("connexionClient"))
		{
			retour = new ConnecterClientService();
		}
		else if (typeMenu.equals("inscription"))
		{
			retour = new InscrireClientService();
		}
		// Clients connectés
		else if (typeMenu.equals("passerCommandeClient"))
		{
			retour = new PasserCommandeClientService();
		}
		else if (typeMenu.equals("listerCommandesClient"))
		{
			retour = new ListerCommandesClientService();
		}

		return retour;
	}
}
