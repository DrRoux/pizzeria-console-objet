package dev;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.dao.oldDao.PizzaMemDao;
import fr.pizzeria.model.Pizza;

/**
 *
 * @author BIRABEN-BIANCHI Hugo
 */
public class PizzaMemDaoTest
{
	protected static Logger LOGGER = LoggerFactory.getLogger(PizzaMemDaoTest.class);
	PizzaMemDao p;

	@Before
	public void init()
	{
		LOGGER.info("Etant donné une nouvelle instance de PizzaMemDao");
		p = new PizzaMemDao();
	}

	@Test
	public void savePizza_AddOnePizza()
	{
		init();

		Pizza pizzaTemp = new Pizza();
		int size = p.findAllPizzas().size();

		LOGGER.info("Lorsqu'on insère une nouvelle pizza dans la liste");
		p.saveNewPizza(pizzaTemp);

		LOGGER.info("Alors on doit avoir une liste plus grande de 1");
		assertEquals(size + 1, p.findAllPizzas().size());
	}

	@Test
	public void deletePizza_DeleteOnePizzaIND()
	{
		init();

		String pizzaCode = "XOX";
		p.saveNewPizza(new Pizza(pizzaCode, "XOX", 12.4));

		int size = p.findAllPizzas().size();
		p.deletePizza(pizzaCode);

		assertEquals(size - 1, p.findAllPizzas().size());
	}

	@Test
	public void deletePizza_All()
	{
		init();

		System.out.println(p.findAllPizzas().size());
		List<String> listPizza = p.findAllPizzas().stream().map(t -> t.getCode()).collect(Collectors.toList());

		listPizza.forEach(t -> p.deletePizza(t));

		assertEquals(0, p.findAllPizzas().size());
	}

	@Test
	public void pizzaFindByCode_WhereCodeisNull()
	{
		init();
		assertEquals(null, p.findPizzaByCode("PizzaQuiNExistePas"));
	}

	@Test
	public void pizzaExists_Not()
	{
		init();
		assertEquals(false, p.pizzaExists("PizzaQuiNExistePas"));
	}

}
