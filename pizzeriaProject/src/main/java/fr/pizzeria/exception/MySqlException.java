/**
 * 
 */
package fr.pizzeria.exception;

/**
 *
 * @author BIRABEN-BIANCHI Hugo
 */
public class MySqlException extends RuntimeException
{
	private static final long serialVersionUID = -8898974333236523950L;
	
	public MySqlException(String msg) 
	{
		super(msg);
	}
	
	public MySqlException(Exception e) 
	{
		super(e);
	}

	public MySqlException()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public MySqlException(String arg0, Throwable arg1)
	{
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public MySqlException(Throwable arg0)
	{
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
	

}
