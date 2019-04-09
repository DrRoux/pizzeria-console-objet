/**
 * 
 */
package fr.pizzeria.menu;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import java.util.Scanner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.menu.ConnecterClientService;

/**
 *
 * @author BIRABEN-BIANCHI Hugo
 */
public class ConnecterClientServiceTest
{
	/**
	 * Création d'une "Rule" qui va permettre de substituer le System.in utilisé par
	 * le Scanner par un mock: systemInMock
	 */
	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	@Test
	public void executeUC_clientExist() throws StockageException
	{
		systemInMock.provideLines("a", "a", "99");
		ConnecterClientService c = new ConnecterClientService();

		c.executeUC(new Scanner(System.in));
	}

	@Test
	public void executeUC_client_DoesntExistThenExists() throws StockageException
	{
		systemInMock.provideLines("m", "m", "a", "a", "99");
		ConnecterClientService c = new ConnecterClientService();

		c.executeUC(new Scanner(System.in));
	}
}
