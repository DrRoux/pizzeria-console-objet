/**
 * 
 */
package fr.pizzeria.exception;

import fr.pizzeria.logger.ILogger;

/**
 *
 * @author BIRABEN-BIANCHI Hugo
 */
public class PersonnalSqlException extends RuntimeException implements ILogger
{
	private static final long serialVersionUID = -8898974333236523950L;

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
