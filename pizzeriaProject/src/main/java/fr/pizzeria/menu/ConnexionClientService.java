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
public class ConnexionClientService extends MenuService
{
	ClientJpaDao cJpaDao = new ClientJpaDao ();
	PizzeriaClientConnecteConsoleApp console = new PizzeriaClientConnecteConsoleApp ();
	/* (non-Javadoc)
	 * @see fr.pizzeria.menu.MenuService#executeUC(java.util.Scanner)
	 */
	@Override
	public void executeUC(Scanner scanner) throws StockageException
	{
		System.out.println("Connexion : ");
		
		String choiceMail = null;
		String choicePswd = null;
		
		System.out.println("Veuillez saisir votre adresse email:");
		choiceMail = scanner.nextLine();
		
		System.out.println("Veuillez saisir votre mot de passe:");
		choicePswd = new DigestUtils(SHA_512).digestAsHex(scanner.nextLine());
		
		cJpaDao.beginConnexionBdd();
		Client client = cJpaDao.getClient (choiceMail, choicePswd);
		cJpaDao.closeConnexionBdd();
		
		console.display(scanner, client);
	}

}
