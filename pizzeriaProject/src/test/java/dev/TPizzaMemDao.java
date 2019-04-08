/**
 * 
 */
package dev;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.pizzeria.dao.oldDao.PizzaMemDao;
import fr.pizzeria.model.Pizza;

/**
 *
 * @author BIRABEN-BIANCHI Hugo
 */
public class TPizzaMemDao
{
	PizzaMemDao p;

	@Test
	public void savePizza1PizzaByDefault()
	{
		p = new PizzaMemDao();
		Pizza pizzaTemp = new Pizza();
		int size = p.findAllPizzas().size();
		p.saveNewPizza(pizzaTemp);

		assertEquals(size + 1, p.findAllPizzas().size());
	}

}
