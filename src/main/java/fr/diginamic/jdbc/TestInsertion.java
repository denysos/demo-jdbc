package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsertion {

	private static final String DB_URL = "jdbc:mariadb://localhost:3306/compta";
	private static final String DB_LOGIN = "root";
	private static final String DB_PWD = "";

	public static void main(String[] args) {

		Statement st = null;

		try (Connection connection = DriverManager.getConnection(DB_URL, DB_LOGIN, DB_PWD)) {
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
