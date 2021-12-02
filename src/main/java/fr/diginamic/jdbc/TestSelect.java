package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import fr.diginamic.jdbc.entites.Fournisseur;

public class TestSelect {

	private static final String DB_URL = "jdbc:mariadb://localhost:3306/compta";
	private static final String DB_LOGIN = "root";
	private static final String DB_PWD = "";

	public static void main(String[] args) {

		ArrayList<Fournisseur> listeFournisseurs = new ArrayList<>();

		Statement st = null;
		ResultSet curseur = null;

		try (Connection connection = DriverManager.getConnection(DB_URL, DB_LOGIN, DB_PWD)) {
			System.out.println(connection);
			st = connection.createStatement();
			curseur = st.executeQuery("select * from fournisseur");
			while (curseur.next()) {
				Fournisseur fournisseur = new Fournisseur(curseur.getInt("id"), curseur.getString("nom"));
				listeFournisseurs.add(fournisseur);
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				curseur.close();
				st.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		for (Fournisseur fournisseur : listeFournisseurs) {
			System.out.println(fournisseur.toString());
		}
	}

}
