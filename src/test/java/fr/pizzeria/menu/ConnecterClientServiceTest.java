/**
 * 
 */
package fr.pizzeria.menu;

import static org.apache.commons.codec.digest.MessageDigestAlgorithms.SHA_512;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import java.util.Scanner;

import org.apache.commons.codec.digest.DigestUtils;
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
		Mockito.when(mockedDao.getClient(login, new DigestUtils(SHA_512).digestAsHex(mdp)))
				.thenReturn(new Client("a", "a", "a", "a"));

		ConnecterClientService c = new ConnecterClientService();

		systemInMock.provideLines(login, mdp, "99");
		c.setcJpaDao(mockedDao);
		c.executeUC(new Scanner(System.in));

		Mockito.verify(mockedDao).getClient(login, new DigestUtils(SHA_512).digestAsHex(mdp));
	}

	@Test
	public void executeUC_client_DoesntExistThenExists() throws StockageException
	{
		String login = "m";
		String mdp = "m";
		String loginPassant = "a";
		String mdpPassant = "a";
		String mdpHash = new DigestUtils(SHA_512).digestAsHex(mdp);
		String mdpPHash = new DigestUtils(SHA_512).digestAsHex(mdpPassant);

		ClientJpaDao mockedDao = Mockito.mock(ClientJpaDao.class);
		Mockito.when(mockedDao.getClient(login, mdpHash)).thenReturn(null);
		Mockito.when(mockedDao.getClient(loginPassant, mdpPHash)).thenReturn(new Client("a", "a", "a", "a"));

		systemInMock.provideLines(login, mdp, loginPassant, mdpPassant, "99");
		ConnecterClientService c = new ConnecterClientService();
		c.setcJpaDao(mockedDao);
		c.executeUC(new Scanner(System.in));

		Mockito.verify(mockedDao).getClient(login, mdpHash);
		Mockito.verify(mockedDao).getClient(loginPassant, mdpPHash);
	}
}
