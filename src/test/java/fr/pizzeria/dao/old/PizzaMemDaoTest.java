package fr.pizzeria.dao.old;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.model.Pizza;

/**
 *
 * @author BIRABEN-BIANCHI Hugo
 */
public class PizzaMemDaoTest
{
	protected static Logger LOGGER = LoggerFactory.getLogger("loggerTest");
	PizzaMemDao p;

	@Rule
	public TestName pTest = new TestName();

	@Before
	public void init()
	{
		LOGGER.info("\nEtant donné une instance de PizzaMemDao");
		p = new PizzaMemDao();
	}

	@Test
	public void savePizza_AddOnePizza()
	{
		LOGGER.info("Exécution de la méthode {}", pTest.getMethodName());

		Pizza pizzaTemp = new Pizza();
		int size = p.findAllPizzas().size();

		LOGGER.info("Lorsqu'on insère une nouvelle pizza dans la liste");
		p.saveNewPizza(pizzaTemp);

		LOGGER.info("Alors on doit avoir une liste plus grande de 1");
		assertEquals(size + 1, p.findAllPizzas().size());
	}
	
	@Test
	public void updatePizza_ChangeOnePizza()
	{
		LOGGER.info("Exécution de la méthode {}", pTest.getMethodName());

		LOGGER.info("Soit l'initialisation comportant 8 elements, dont une pizza 'IND'");
		p.initialisation();
		Pizza pizzaTemp = new Pizza("LIG", "Ligurienne", 12);
		String codePizzaModif = "IND";

		LOGGER.info("Lorsqu'on met à jour une pizza dans la liste");
		p.updatePizza(codePizzaModif, pizzaTemp);

		LOGGER.info("Alors on doit retrouver l'objet inséré dans la liste");
		assertEquals(true, p.pizzaExists("LIG"));
	}

	@Test
	public void deletePizza_DeleteOnePizza()
	{
		LOGGER.info("Exécution de la méthode {}", pTest.getMethodName());
		
		LOGGER.info("On insère une pizza fictive pour s'assurer qu'elle est bien supprimer,"
					+ " peut importe l'état de la liste précédent le test");
		String pizzaCode = "XOX";
		p.saveNewPizza(new Pizza(pizzaCode, "XOX", 12.4));
		int size = p.findAllPizzas().size();
		
		LOGGER.info("Lorsqu'on supprime une pizza dans la liste");
		p.deletePizza(pizzaCode);

		LOGGER.info("Alors on doit avoir une liste plus petite de 1");
		assertEquals(size - 1, p.findAllPizzas().size());
	}

	@Test
	public void deletePizza_All()
	{
		LOGGER.info("Exécution de la méthode {}", pTest.getMethodName());

		p.initialisation();
		List<String> listPizza = p.findAllPizzas().stream().map(t -> t.getCode()).collect(Collectors.toList());

		LOGGER.info("Lorsqu'on supprime toutes les pizzas dans la liste");
		listPizza.forEach(t -> p.deletePizza(t));

		LOGGER.info("Alors on doit avoir une liste de taille 0");
		assertEquals(0, p.findAllPizzas().size());
	}

	@Test
	public void pizzaFindByCode_WhereCodeisNull()
	{
		LOGGER.info("Exécution de la méthode {}", pTest.getMethodName());
		LOGGER.info("Lorsqu'on cherche une pizza dans la liste avec un code non valide");
		LOGGER.info("Alors on doit un retour null");
		assertEquals(null, p.findPizzaByCode("PizzaQuiNExistePas"));
	}

	@Test
	public void pizzaExists_Not()
	{
		LOGGER.info("Exécution de la méthode {}", pTest.getMethodName());
		LOGGER.info("Lorsqu'on cherche à savoir si une pizza existe en donnant un code non valide");
		LOGGER.info("Alors on doit un retour faux");
		assertEquals(false, p.pizzaExists("PizzaQuiNExistePas"));
	}
	
	@Test
	public void initialisation()
	{
		LOGGER.info("Exécution de la méthode {}", pTest.getMethodName());
		LOGGER.info("Lorsqu'on cherche à savoir si l'initialisation fonctionne");
		p.initialisation();
		
		LOGGER.info("Alors on doit avoir un retour égal à 8");
		assertEquals(8, p.findAllPizzas().size());
	}

}
