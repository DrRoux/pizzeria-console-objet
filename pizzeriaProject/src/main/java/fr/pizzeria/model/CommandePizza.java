/**
 * 
 */
package fr.pizzeria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	private int commande_id;
	@Column
	private int pizza_id;
}
