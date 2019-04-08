/**
 * 
 */
package fr.pizzeria.menu;

import static org.apache.commons.codec.digest.MessageDigestAlgorithms.SHA_512;

import java.util.Scanner;

import org.apache.commons.codec.digest.DigestUtils;

import fr.pizzeria.console.PizzeriaClientConnecteConsoleApp;
import fr.pizzeria.dao.ClientJpaDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Client;

/**
 *
 * @author BIRABEN-BIANCHI Hugo
 */
public class ConnecterClientService extends MenuService
{
	ClientJpaDao cJpaDao = new ClientJpaDao();
	PizzeriaClientConnecteConsoleApp console = new PizzeriaClientConnecteConsoleApp();

	@Override
	public void executeUC(Scanner scanner) throws StockageException
	{
		clean();
		System.out.println("Connexion : ");

		String choiceMail = null;
		String choicePswd = null;
		Client client = null;

		while (client == null)
		{
			System.out.println("Veuillez saisir votre adresse email:");
			choiceMail = scanner.nextLine();

			System.out.println("Veuillez saisir votre mot de passe:");
			choicePswd = new DigestUtils(SHA_512).digestAsHex(scanner.nextLine());

			cJpaDao.beginConnexionBdd();
			client = cJpaDao.getClient(choiceMail, choicePswd);
			cJpaDao.closeConnexionBdd();
		}

		console.set(client);
		console.display(scanner);
	}

}
