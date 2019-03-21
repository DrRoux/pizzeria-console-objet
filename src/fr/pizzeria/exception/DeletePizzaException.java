/**
 * 
 */
package fr.pizzeria.exception;

/**
 *
 * @author BIRABEN-BIANCHI Hugo
 */
public class DeletePizzaException extends StockageException
{
	private static final long serialVersionUID = 1365824567363223301L;

	public DeletePizzaException (String msg) 
	{
		super(msg);
	}
	
	public DeletePizzaException (Exception e) 
	{
		super(e);
	}

}
