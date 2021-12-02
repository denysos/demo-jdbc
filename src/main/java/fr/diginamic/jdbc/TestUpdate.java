package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestUpdate {

	private static final String DB_URL = "jdbc:mariadb://localhost:3306/compta";
	private static final String DB_LOGIN = "root";
	private static final String DB_PWD = "";

	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection(DB_URL, DB_LOGIN, DB_PWD)) {
			System.out.println(connection);
			Statement st = connection.createStatement();
			int nb = st.executeUpdate("UPDATE fournisseur set nom= 'La Maison des Peinture' where nom = 'La Maison de la Peinture'");
			if (nb == 1) {
				System.out.println("mise à jour réussie !!!");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

}
