/**
 * 
 */
package fr.pizzeria.menu;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import java.util.Scanner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.mockito.Mockito;

import fr.pizzeria.dao.ClientJpaDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Client;

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
		String login = "a";
		String mdp = "a";
		ClientJpaDao mockedDao = Mockito.mock(ClientJpaDao.class);
		Mockito.when(mockedDao.getClient(login, mdp)).thenReturn(new Client());

		ConnecterClientService c = new ConnecterClientService();

		systemInMock.provideLines(login, mdp, "99");
		c.executeUC(new Scanner(System.in));

		Mockito.verify(mockedDao).getClient(login, mdp);
	}

	@Test
	public void executeUC_client_DoesntExistThenExists() throws StockageException
	{
		String login = "m";
		String mdp = "m";
		String loginPassant = "a";
		String mdpPassant = "a";

		ClientJpaDao mockedDao = Mockito.mock(ClientJpaDao.class);
		Mockito.when(mockedDao.getClient(login, mdp)).thenReturn(null);
		Mockito.when(mockedDao.getClient(loginPassant, mdpPassant)).thenReturn(new Client());

		systemInMock.provideLines(login, mdp, loginPassant, mdpPassant, "99");
		ConnecterClientService c = new ConnecterClientService();
		c.executeUC(new Scanner(System.in));

		Mockito.verify(mockedDao).getClient(login, mdp);
	}
}
