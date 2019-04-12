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
	private static final long serialVersionUID = -5332444671489236748L;

	public TechnicalException(String msg) 
	{
		super(msg);
	}
	
	public TechnicalException(Exception e) 
	{
		super(e);
	}
}
