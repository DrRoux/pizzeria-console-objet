/**
 * 
 */
package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.logger.ILogger;

/**
 * IPizzeriaConsole : Interface de gestion des menus. Sert aux affichages
 * utilisateurs.
 * 
 * @author BIRABEN-BIANCHI Hugo
 */
public interface IPizzeriaConsole extends ILogger
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
	default void clean()
	{
		for (int i = 0; i < 40; i++)
		{
			System.out.println(" ");
		}
	}
}
