package fr.diginamic.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.jdbc.entites.Fournisseur;

public class FournisseurDaoJdbc implements FournisseurDao {

	public Connection connectionBase() throws SQLException {
		Connection connection = PersistenceManager.getConnection();
		return connection;
	}

	@Override
	public List<Fournisseur> extraire() throws SQLException {
		Connection connection = connectionBase();
		List<Fournisseur> listeFournisseurs = new ArrayList<>();
		try (Statement st = connection.createStatement(); ResultSet rs = st.executeQuery("SELECT * FROM FOURNISSEUR")) {
			while (rs.next()) {
				Fournisseur fournisseur = new Fournisseur(rs.getInt("id"), rs.getString("nom"));
				listeFournisseurs.add(fournisseur);
			}
		}
		return listeFournisseurs;
	}

	@Override
	public void insert(Fournisseur fournisseur) throws SQLException {
		Connection connection = connectionBase();
		String rqInsert = "INSERT INTO FOURNISSEUR(nom) VALUES(\"" + fournisseur.getNom() + "\")";
//		String rqInsert = "INSERT INTO FOURNISSEUR(nom) VALUES(" + fournisseur.getNom() + ")";
		try (Statement st = connection.createStatement()) {
			int nb = st.executeUpdate(rqInsert);
			System.out.println("Insertion réussie de " + nb + " fournisseur(s)");
			
			if (nb >= 1) {
				System.out.println("le fournisseur " + fournisseur.getNom() + " a été inséré avec succès !");
			} else {
				System.out.println("aucun fournisseur n'a été inséré !");
			}

		}

	}

	@Override
	public int update(String ancienNom, String nouveauNom) throws SQLException {
		Connection connection = connectionBase();
		String rqUpdate = "UPDATE FOURNISSEUR SET nom = ? WHERE nom = ?";

		try (PreparedStatement st = connection.prepareStatement(rqUpdate)) {
			st.setString(1, nouveauNom);
			st.setString(2, ancienNom);

			int nb = st.executeUpdate();
			
			if (nb >= 1) {
				System.out.println("mise à jour réussie de " + nb + " fournisseur(s)");
				System.out.println(ancienNom + " --> " + nouveauNom);
			} else {
				System.out.println("aucun fournisseur n'a été mis à jour !");
			}
		}
		return 0;
	}

	@Override
	public boolean delete(Fournisseur fournisseur) throws SQLException {
		Connection connection = connectionBase();
		String rqUpdate = "DELETE FROM FOURNISSEUR WHERE nom = ?";

		try (PreparedStatement st = connection.prepareStatement(rqUpdate)) {
			st.setString(1, fournisseur.getNom());

			int nb = st.executeUpdate();
			
			
			if (nb >= 1) {
				System.out.println("suppression réussie de " + nb + " fournisseur(s)");
				System.out.println(fournisseur.getNom() + " supprimé ! ");
			}else {
				System.out.println("aucun fournisseur n'a pu être supprimé, " + fournisseur.getNom() + " inconnu !" );
			}
		}
		return false;
	}

}
