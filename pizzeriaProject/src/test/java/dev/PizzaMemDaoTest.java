/**
 * 
 */
package dev;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import fr.pizzeria.dao.oldDao.PizzaMemDao;
import fr.pizzeria.model.Pizza;

/**
 *
 * @author BIRABEN-BIANCHI Hugo
 */
public class PizzaMemDaoTest
{
	PizzaMemDao p;

	@Test
	public void saveOnePizza()
	{
		p = new PizzaMemDao();

		Pizza pizzaTemp = new Pizza();
		int size = p.findAllPizzas().size();
		p.saveNewPizza(pizzaTemp);

		assertEquals(size + 1, p.findAllPizzas().size());
	}

	@Test
	public void deleteOnePizzaIND()
	{
		p = new PizzaMemDao();

		String pizzaCode = "IND";
		int size = p.findAllPizzas().size();
		p.deletePizza(pizzaCode);

		assertEquals(size - 1, p.findAllPizzas().size());
	}

	@Test
	public void deletePizzaAll()
	{
		p = new PizzaMemDao();

		System.out.println(p.findAllPizzas().size());
		List<String> listPizza = p.findAllPizzas().stream().map(t -> t.getCode()).collect(Collectors.toList());

		listPizza.forEach(t -> p.deletePizza(t));

		assertEquals(0, p.findAllPizzas().size());
	}

}
