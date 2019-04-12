package fr.pizzeria.console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.dao.CommandesJpaDao;
import fr.pizzeria.exception.PersonnalSqlException;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Commande;
import fr.pizzeria.model.Pizza;

public class PizzeriaCommandeEnCours implements IPizzeriaConsole
{
	protected static Logger logger = LoggerFactory.getLogger(PizzeriaCommandeEnCours.class);
	CommandesJpaDao cJpaDao = new CommandesJpaDao();
	static Client client;
	static List<Pizza> listPizza = new ArrayList <> ();
	String choice = null;
	String choice2 = null;
	boolean sortiBoucle = false;
	Commande commande = new Commande();
	
	@Override
	public void displayMenu ()
	{
		IPizzeriaConsole.clean();

		logger.info("***** Commande en cours *****");
		logger.info("1.  Commander une pizza");
		logger.info("2.  Consulter sa commande en cours");
		logger.info("99. Finaliser votre commande");
		logger.info("\nVeuillez saisir votre choix : ");
	}
	
	public void displayCommandeClient (Commande commande, Scanner scanner)
	{
		commande.afficherCommandesClient();
		logger.info("Veuillez presser la touche entrée pour continuer");
		scanner.nextLine();
	}
	
	public void addCommande (Commande commande)
	{
		commande.setListComPiz(listPizza.stream().filter(t -> t.getCode ().equals(choice2)).collect(Collectors.toList()));
	}
	
	public boolean pizzaInListEqualsCode (List <Pizza> p)
	{
		return p.stream().filter(t -> t.getCode().equals(choice2)).collect(Collectors.counting()) < 1;
	}
	
	@Override
	public void choixMenu (Scanner scanner)
	{
		if (Integer.parseInt(choice) == 1)
		{
			
			logger.info("Choix d'une pizza : ");

			listPizza.forEach(Pizza::afficherPizza);

			while (pizzaInListEqualsCode (listPizza))
			{
				logger.info("Veuillez choisir le code de la pizza à commander : ");
				choice2 = scanner.nextLine().toUpperCase();
			}

			boolean doublon = pizzaInListEqualsCode (commande.getListComPiz());

			if (!doublon)
			{
				addCommande (commande);
			}
			else
			{
				logger.info("Impossible d'ajouter une pizza en double !");
			}
		}
		else if (Integer.parseInt(choice) == 2)
		{
			displayCommandeClient (commande, scanner);
			
		}
		else if (Integer.parseInt(choice) == 99)
		{
			sortiBoucle = true;
			cJpaDao.ajoutCommande(client, commande);
		}
		else
		{
			logger.info("Choix invalide, veuillez recommencer !");
		}
	}
	
	@Override
	public void display(Scanner scanner)
	{
		while (!sortiBoucle)
		{
			displayMenu ();
			choice = scanner.nextLine();
			
			try
			{
				choixMenu (scanner);
			}
			catch (NumberFormatException e)
			{
				// Fait boucler le programme sans interaction de l'utilisateur
			}
			catch (PersonnalSqlException e)
			{
				logger.info(e.getMessage());
			}
		}
	}
	
	@Override
	public void displayException (String e)
	{
		logger.info(e);
	}

	public CommandesJpaDao getcJpaDao()
	{
		return cJpaDao;
	}

	public void setcJpaDao(CommandesJpaDao cJpaDao)
	{
		this.cJpaDao = cJpaDao;
	}

	public static Client getClient()
	{
		return client;
	}

	public static void setClient(Client client)
	{
		PizzeriaCommandeEnCours.client = client;
	}

	public static List<Pizza> getListPizza()
	{
		return listPizza;
	}

	public static void setListPizza(List<Pizza> listPizza)
	{
		PizzeriaCommandeEnCours.listPizza = listPizza;
	}

}
