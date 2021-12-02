package fr.diginamic.d16.demo_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TestConnexionJdbcProp {

	private static final ResourceBundle fichierConfDB = ResourceBundle.getBundle("db");

	private static final String DB_URL2 = fichierConfDB.getString("jdbc.db.url");
	private static final String DB_LOGIN2 = fichierConfDB.getString("jdbc.db.login");
	private static final String DB_PWD2 = fichierConfDB.getString("jdbc.db.pwd");

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		try (Connection connection = DriverManager.getConnection(DB_URL2, DB_LOGIN2, DB_PWD2)) {
			System.out.println(connection);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

	}
}
