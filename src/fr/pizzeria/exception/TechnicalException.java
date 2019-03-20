/**
 * 
 */
package fr.pizzeria.exception;

/**
 * Gestion des erreurs pour la classe gestionFichier
 * @author BIRABEN-BIANCHI Hugo
 */
public class TechnicalException extends RuntimeException
{

	public TechnicalException(String msg) {
		super(msg);
	}
	
	public TechnicalException(Exception e) {
		super(e);
	}
}
