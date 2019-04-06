/**
 * 
 */
package fr.pizzeria.menu;

import static org.apache.commons.codec.digest.MessageDigestAlgorithms.SHA_512;

import java.util.Scanner;

import org.apache.commons.codec.digest.DigestUtils;

import fr.pizzeria.dao.ClientJpaDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Client;

/**
 *
 * @author BIRABEN-BIANCHI Hugo
 */
public class InscrireClientService extends MenuService
{
	ClientJpaDao cJpaDao = new ClientJpaDao ();

	@Override
	public void executeUC(Scanner scanner) throws StockageException
	{
		System.out.println("Inscription : ");
		
		String choiceNom = null;
		String choicePrenom = null;
		String choiceMail = null;
		String choicePswd = null;
		
		System.out.println("Veuillez saisir votre nom :");
		choiceNom = scanner.nextLine();
		
		System.out.println("Veuillez saisir votre prénom:");
		choicePrenom = scanner.nextLine();
		
		System.out.println("Veuillez saisir votre adresse email:");
		choiceMail = scanner.nextLine();
		
		System.out.println("Veuillez saisir votre mot de passe:");
		choicePswd = new DigestUtils(SHA_512).digestAsHex(scanner.nextLine());
		
		Client client = new Client (choiceNom, choicePrenom, choiceMail, choicePswd);
		cJpaDao.beginConnexionBdd();
		cJpaDao.ajout(client);
		cJpaDao.closeConnexionBdd();
	}

}
