/**
 * 
 */
package fr.pizzeria.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author BIRABEN-BIANCHI Hugo
 */
public class BddTest
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// DriverManager.registerDriver(new Driver());
		// Etape 1 - Chargement du pilote
		Class.forName("org.mariadb.jdbc.Driver");
		
		// Etape 2 - Définition de la JDBC URL
		String jdbcUrl = "jdbc:mariadb://localhost:3307/bdd_mysql";
		
		// Etape 3 - Création de la connexion
		Connection uneConnexion = DriverManager.getConnection(jdbcUrl, "root", "");
		
		Statement st = uneConnexion.createStatement();
		
		// Etape 4 - exécution  de la requête
		ResultSet rs = st.executeQuery("select * from CLIENTS");
		
		// Etape 5 - exploitation des résultats
		while(rs.next()) {
			
			String titre = rs.getString("CODE_CLIENT");
			
			System.out.println("CODE=" + titre);
		}

		// Etape 6 - Fermeture des ressources
		rs.close();
		
		st.close();
		
		uneConnexion.close();

	}
}
