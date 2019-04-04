/**
 * 
 */
package fr.pizzeria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author BIRABEN-BIANCHI Hugo
 */
public abstract class JpaDao
{
	String driverName = null;
	String jdbcUrl = null;
	String userName = null;
	String password = null;
	Connection connexionBDD = null;
	PreparedStatement st = null;
}
