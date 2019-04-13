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

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.Pizza;

/**
 *
 * @author BIRABEN-BIANCHI Hugo
 */
public class AjouterPizzaServiceTest
{
	/**
	 * Création d'une "Rule" qui va permettre de substituer le System.in utilisé par
	 * le Scanner par un mock: systemInMock
	 */
	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	@Test
	public void executeUC_addPizza() throws SavePizzaException
	{
		IPizzaDao mockedDao = Mockito.mock(IPizzaDao.class);
		
		String code = "AAA";
		String libel = "La pizza des A";
		String prix = "12.5";
		
		AjouterPizzaService c = new AjouterPizzaService();
		AjouterPizzaService.setGestionnairePizza(mockedDao);

		systemInMock.provideLines(code, libel, prix);
		c.executeUC(new Scanner(System.in));

		Mockito.verify(mockedDao).saveNewPizza(new Pizza (code, libel, Double.parseDouble(prix)));
	}
}
