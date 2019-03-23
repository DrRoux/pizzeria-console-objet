/**
 * 
 */
package fr.pizzeria.exception;

/**
 *
 * @author BIRABEN-BIANCHI Hugo
 */
public class SavePizzaException extends StockageException
{
	private static final long serialVersionUID = 3342804450040362421L;

	public SavePizzaException(String msg) 
	{
		super(msg);
	}
	
	public SavePizzaException(Exception e) 
	{
		super(e);
	}

}
