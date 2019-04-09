/**
 * 
 */
package fr.pizzeria.menu;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import java.util.Scanner;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import fr.pizzeria.exception.SavePizzaException;

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
		AjouterPizzaService c = new AjouterPizzaService();
		int sizeBefore = AjouterPizzaService.getGestionnairePizza().findAllPizzas().size();

		c.executeUC(new Scanner(System.in));
		systemInMock.provideLines("AAA", "La Pizza des A", "12.5");

		int sizeAfter = AjouterPizzaService.getGestionnairePizza().findAllPizzas().size();
		Assert.assertEquals(sizeBefore + 1, sizeAfter);
	}
}
