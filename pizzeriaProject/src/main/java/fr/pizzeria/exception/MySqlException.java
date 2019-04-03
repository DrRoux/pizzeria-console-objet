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

}
