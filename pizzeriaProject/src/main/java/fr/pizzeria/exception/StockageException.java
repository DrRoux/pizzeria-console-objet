/**
 * 
 */
package fr.pizzeria.exception;

import fr.pizzeria.logger.ILogger;

/**
 *
 * @author BIRABEN-BIANCHI Hugo
 */
public class StockageException extends Exception implements ILogger
{
	private static final long serialVersionUID = -1030966979133115038L;

	public StockageException(String msg)
	{
		super(msg);
	}

	public StockageException(Exception e)
	{
		super(e);
	}

}
