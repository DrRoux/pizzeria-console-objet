/**
 * 
 */
package fr.pizzeria.console;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * IPizzeriaConsole : Interface de gestion des menus. Sert aux affichages
 * utilisateurs.
 * 
 * @author BIRABEN-BIANCHI Hugo
 */
public interface IPizzeriaConsole
{	
	/**
	 * Fonction d'affichage contenant les différents menus (Client, ClientConnecte
	 * et Administrateur)
	 */
	void display(Scanner questionUser);

	/**
	 * Nettoyage de la console en affichant un grand nombre de ligne vide pour
	 * accroître la lisibilité de l'application
	 */
	static void clean()
	{
		Logger logger = LoggerFactory.getLogger(IPizzeriaConsole.class);
		
		for (int i = 0; i < 40; i++)
		{
			logger.info(" ");
		}
	}
}
