/**
 * 
 */
package fr.pizzeria.exception;

/**
 *
 * @author BIRABEN-BIANCHI Hugo
 */
public class UpdatePizzaException extends StockageException
{
	private static final long serialVersionUID = -6635303048861536281L;

	public UpdatePizzaException (String msg) 
	{
		super(msg);
	}
	
	public UpdatePizzaException (Exception e) 
	{
		super(e);
	}
}
