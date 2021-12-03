package fr.diginamic.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.diginamic.jdbc.entites.Fournisseur;

public class TestConnexionJdbcDao {

	public static void main(String[] args) {

		// liste des fournisseurs
		FournisseurDaoJdbc rqFournisseur = new FournisseurDaoJdbc();
		List<Fournisseur> listeFournisseurs = new ArrayList<>();
		try {
			listeFournisseurs = rqFournisseur.extraire();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

		for (Fournisseur fournisseur : listeFournisseurs) {
			System.out.println(fournisseur.toString());
		}

		// insertion d'un fournisseur

		Fournisseur fournisseur = new Fournisseur(0, "Duppppont");

		try {
			rqFournisseur.insert(fournisseur);

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

		// mise à jour d'un fournisseur avec PreparedStatement
		try {
			rqFournisseur.update("Toto", "Denis");

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		
		
		// suppression d'un fournisseur avec PreparedStatement
		fournisseur = new Fournisseur(0, "Tutu");
		try {
			rqFournisseur.delete(fournisseur);

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
}
