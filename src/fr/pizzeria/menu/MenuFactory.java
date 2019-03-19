package fr.pizzeria.menu;

/**
 * @author BIRABEN-BIANCHI Hugo
 *
 */
public class MenuFactory
{
	public MenuService create (String typeMenu) 
	{
		MenuService retour = null;
		
		if (typeMenu.equals("list"))
			retour = new ListerPizzaService ();	
		else if (typeMenu.equals("ajout"))
			retour =  new AjouterPizzaService ();	
		else if (typeMenu.equals("modif"))
			retour =  new ModifierPizzaService ();	
		else if (typeMenu.equals("suppr"))
			retour =  new SupprimerPizzaService ();
		
		return retour;
	}
}
