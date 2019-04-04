package dev;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.pizzeria.console.*;
import fr.pizzeria.model.Pizza;

/**
 * Hello world!
 *
 */
public class App 
{
	private static PizzeriaAdminConsoleApp p = new PizzeriaAdminConsoleApp ();
	
    public static void main( String[] args )
    {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("pizzeriaProject");
    	EntityManager em = emf.createEntityManager();

    	TypedQuery <Pizza> requete = em.createQuery("select p from Pizza p", Pizza.class);
    	List <Pizza> listPizza = requete.getResultList();
    	
    	listPizza.forEach(t -> System.out.println(t));
        
        em.close ();
        emf.close ();
        
        //p.display ();
    }
}
