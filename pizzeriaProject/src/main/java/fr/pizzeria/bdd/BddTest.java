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
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// Etape 2 - Définition de la JDBC URL
		String jdbcUrl = "jdbc:mysql://bxnieqyqjpcgwd3f2wwb-mysql.services.clever-cloud.com:3306/bxnieqyqjpcgwd3f2wwb?useSSL=false";
		
		// Etape 3 - Création de la connexion
		Connection connexionBDD = DriverManager.getConnection(jdbcUrl, "u23oixvvtlomobsc", "lwW5IiUfLRDdIsxsqY7G");
		connexionBDD.setAutoCommit(false);
		
		
		//*
		Statement st = connexionBDD.createStatement();
		
		// Etape 4 - exécution  de la requête
		//st.execute("CREATE TABLE deuxChamp ( CODE_PAYS VARCHAR(4) PRIMARY KEY, NOM_PAYS VARCHAR(30) )");
		
		// Etape 5 - exploitation des résultats
		ResultSet rs = st.executeQuery("SELECT * FROM pizza");
		while(rs.next()) {
			
			String titre = rs.getString("CODE_PAYS");
			String titre2 = rs.getString("nom_PAYS");
			
			System.out.println("CODE=" + titre + " NOM=" + titre2);
		}

		// Etape 6 - Fermeture des ressources
		rs.close();
		
		st.close();
		//*/
		
		connexionBDD.close();

	}
}
