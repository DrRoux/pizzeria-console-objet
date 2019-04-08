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
	public void savePizza_AddOnePizza()
	{
		p = new PizzaMemDao();

		Pizza pizzaTemp = new Pizza();
		int size = p.findAllPizzas().size();
		p.saveNewPizza(pizzaTemp);

		assertEquals(size + 1, p.findAllPizzas().size());
	}

	@Test
	public void deletePizza_DeleteOnePizzaIND()
	{
		p = new PizzaMemDao();

		String pizzaCode = "IND";
		int size = p.findAllPizzas().size();
		p.deletePizza(pizzaCode);

		assertEquals(size - 1, p.findAllPizzas().size());
	}

	@Test
	public void deletePizza_All()
	{
		p = new PizzaMemDao();

		System.out.println(p.findAllPizzas().size());
		List<String> listPizza = p.findAllPizzas().stream().map(t -> t.getCode()).collect(Collectors.toList());

		listPizza.forEach(t -> p.deletePizza(t));

		assertEquals(0, p.findAllPizzas().size());
	}

	@Test
	public void pizzaFindByCode_WhereCodeisNull()
	{
		p = new PizzaMemDao();
		assertEquals(null, p.findPizzaByCode("PizzaQuiNExistePas"));
	}

	@Test
	public void pizzaExists_Not()
	{
		p = new PizzaMemDao();
		assertEquals(false, p.pizzaExists("PizzaQuiNExistePas"));
	}

}
