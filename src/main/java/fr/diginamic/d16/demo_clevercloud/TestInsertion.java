package fr.diginamic.d16.demo_clevercloud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestInsertion {

	private static final ResourceBundle fichierConfDB = ResourceBundle.getBundle("dbclevercloud");

	private static final String DB_URL2;
	private static final String DB_LOGIN2;
	private static final String DB_PWD2;

	// bloc static : les constantes doivent être définies avant !!
		static {
			DB_URL2 = fichierConfDB.getString("jdbc.db.url");
			DB_LOGIN2 = fichierConfDB.getString("jdbc.db.login");
			DB_PWD2 = fichierConfDB.getString("jdbc.db.pwd");
		}
	
	public static void main(String[] args) {

		Statement st = null;
		// passer les instruction du fichier requeteAlimentationDonneeBaseMySqlCleverCloud.sql
		try (Connection connection = DriverManager.getConnection(DB_URL2, DB_LOGIN2, DB_PWD2)) {
			System.out.println(connection);
			st = connection.createStatement();
			int nb = st.executeUpdate("INSERT INTO fournisseur (nom) values ('La Maison de la Peinture')");
			if (nb == 1) {
				System.out.println("insertion réussie !!!");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
