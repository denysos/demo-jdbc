package fr.diginamic.d16.demo_clevercloud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TestConnexionJdbcPropCleverCloud {

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

		// TODO Auto-generated method stub
		try (Connection connection = DriverManager.getConnection(DB_URL2, DB_LOGIN2, DB_PWD2)) {
			System.out.println(connection);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

	}
}
