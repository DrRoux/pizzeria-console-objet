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
public class PersonnalSqlException extends RuntimeException
{
	private static final long serialVersionUID = -8898974333236523950L;
	protected static Logger LOGGER = LoggerFactory.getLogger(PersonnalSqlException.class);

	public PersonnalSqlException(String msg)
	{
		super(msg);
	}

	public PersonnalSqlException(Exception e)
	{
		super(e);
	}

	public PersonnalSqlException()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public PersonnalSqlException(String arg0, Throwable arg1)
	{
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public PersonnalSqlException(Throwable arg0)
	{
		super(arg0);
		// TODO Auto-generated constructor stub
	}

}
