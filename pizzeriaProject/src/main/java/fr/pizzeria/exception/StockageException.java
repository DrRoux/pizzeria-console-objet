/**
 * 
 */
package fr.pizzeria.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author BIRABEN-BIANCHI Hugo
 */
public class StockageException extends Exception
{
	private static final long serialVersionUID = -1030966979133115038L;
	protected static Logger LOGGER = LoggerFactory.getLogger(StockageException.class);

	public StockageException(String msg)
	{
		super(msg);
	}

	public StockageException(Exception e)
	{
		super(e);
	}

}
