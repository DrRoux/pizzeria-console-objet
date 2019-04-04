package fr.pizzeria.menu;

/**
 * Cette classe permet d'instancier les types de menu
 * selon une clé String
 * @author BIRABEN-BIANCHI Hugo
 */
public class MenuFactory
{
	public MenuService create (String typeMenu) 
	{
		MenuService retour = null;
		
		if (typeMenu.equals("list"))
		{
			retour = new ListerPizzaService ();	
		}
		else if (typeMenu.equals("ajout"))
		{
			retour =  new AjouterPizzaService ();	
		}
		else if (typeMenu.equals("modif"))
		{
			retour =  new ModifierPizzaService ();	
		}
		else if (typeMenu.equals("suppr"))
		{
			retour =  new SupprimerPizzaService ();
		}
		else if (typeMenu.equals("connexionClient"))
		{
			retour =  new ConnexionClientService ();
		}
		else if (typeMenu.equals("inscription"))
		{
			retour =  new InscriptionClientService ();
		}
		else if (typeMenu.equals("clientConnecte"))
		{
			retour =  new ListerClientConnecteService ();
		}
		
		return retour;
	}
}
