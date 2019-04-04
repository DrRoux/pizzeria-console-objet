/**
 * 
 */
package fr.pizzeria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author BIRABEN-BIANCHI Hugo
 */
@Entity
@Table (name="commande_pizza")
public class CommandePizza
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int commande_id;
	@Column
	private int pizza_id;
	
	public CommandePizza ()
	{
	}

	public CommandePizza(int commande_id, int pizza_id)
	{
		super();
		this.commande_id = commande_id;
		this.pizza_id = pizza_id;
	}

	/**
	 * Getter
	 * @return the commande_id
	 */
	public int getCommande_id()
	{
		return commande_id;
	}

	/**
	 * Setter
	 * @param commande_id the commande_id to set
	 */
	public void setCommande_id(int commande_id)
	{
		this.commande_id = commande_id;
	}

	/**
	 * Getter
	 * @return the pizza_id
	 */
	public int getPizza_id()
	{
		return pizza_id;
	}

	/**
	 * Setter
	 * @param pizza_id the pizza_id to set
	 */
	public void setPizza_id(int pizza_id)
	{
		this.pizza_id = pizza_id;
	}
}
