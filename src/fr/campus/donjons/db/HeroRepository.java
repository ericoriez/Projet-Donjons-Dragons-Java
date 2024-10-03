package fr.campus.donjons.db;
import fr.campus.donjons.equipements.EquipementOffensif;
import fr.campus.donjons.equipements.Sort;
import fr.campus.donjons.personnages.GuerrierSpecial;
import fr.campus.donjons.personnages.Guerriers;
import fr.campus.donjons.personnages.Magiciens;
import fr.campus.donjons.personnages.Personnage;

import java.sql.*;

public class HeroRepository {

    public void getAllHeroes() throws SQLException {
        String query = "SELECT * FROM Hero";
        try (Connection connection = Database.getConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                String nom = resultSet.getString("Nom");
                String type = resultSet.getString("Type");
                int niveauVie = resultSet.getInt("NiveauVie");
                int niveauForce = resultSet.getInt("NiveauForce");

                System.out.println("ID: " + id + ", Nom: " + nom + ", Type: " + type +
                        ", Niveau de Vie: " + niveauVie + ", Niveau de Force: " + niveauForce);

            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Personnage getHeroById(int id) {
        String query = "SELECT * FROM Hero WHERE Id = ?";
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String nom = resultSet.getString("Nom");
                String type = resultSet.getString("Type");
                int niveauVie = resultSet.getInt("NiveauVie");
                int niveauForce = resultSet.getInt("NiveauForce");

                Personnage personnage;
                if (type.equalsIgnoreCase("Guerriers")) {
                    personnage = new Guerriers(nom, niveauVie, niveauForce);
                } else if (type.equalsIgnoreCase("Magiciens")) {
                    personnage = new Magiciens(nom, niveauVie, niveauForce);
                } else if (type.equalsIgnoreCase("GuerrierSpecial")) {
                    personnage = new GuerrierSpecial(nom, niveauVie, niveauForce);
                } else {
                    System.out.println("Type de personnage inconnu : " + type);
                    return null;
                }

                personnage.setId(id); // Assigner l'ID récupéré au personnage
                return personnage;

            } else {
                System.out.println("Aucun personnage trouvé avec l'ID spécifié.");
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // CREATE PERSO
    public void createHero(Personnage personnage){
        String query = "INSERT INTO Hero (Nom, Type, NiveauVie, NiveauForce) VALUES (?, ?, ?, ?)";

        try (Connection connection = Database.getConnection();
        PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
            statement.setString(1, personnage.getNom());
            statement.setString(2, personnage.getClass().getSimpleName());
            statement.setInt(3, personnage.getNiveauDeVie());
            statement.setInt(4, personnage.getForceAttaque());


            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Hero crée ");
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    personnage.setId(generatedId);
                    }
                }
            }else {
                System.out.println("Hero non crée");
            }

        }catch (SQLException e){
            System.out.println(" Erreur lors de la sauvegarde du personnage:  " + e.getMessage());
            e.printStackTrace();
        }

    }

    public boolean editHero(Personnage personnage) {
        String query = "UPDATE Hero SET Nom = ?, NiveauVie = ?, NiveauForce = ?, EquipementOffensifId = ? WHERE Id = ?";

        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, personnage.getNom());  // Nouveau nom
            statement.setInt(2, personnage.getNiveauDeVie());  // Nouveau niveau de vie
            statement.setInt(3, personnage.getForceAttaque());  // Nouvelle force d'attaque

            if (personnage.getEquipementOffensif() != null) {
                statement.setInt(4, personnage.getEquipementOffensif().getId());  // ID de l'équipement offensif
            } else {
                statement.setNull(4, java.sql.Types.INTEGER);  // Pas d'équipement offensif
            }

            statement.setInt(5, personnage.getId());  // Utiliser l'ID pour la condition WHERE

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Hero updated successfully");
                return true;
            } else {
                System.out.println("Failed to update hero");
            }

        } catch (SQLException e) {
            System.out.println("Error while updating hero: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public EquipementOffensif getSortById(int id) {
        String query = "SELECT * FROM Sorts WHERE Id = ?";
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String type = resultSet.getString("Type");
                String nom = resultSet.getString("Nom");
                int puissance = resultSet.getInt("Puissance");

                return new Sort(id, type, nom, puissance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }




    public void changeLifePoints(Personnage personnage) {
        if (personnage.getId() == 0) {
            System.out.println("Error: Attempting to update life points for a character with an invalid ID.");
            return;
        }

        String query = "UPDATE Hero SET NiveauVie = ? WHERE Id = ?";
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, personnage.getNiveauDeVie());
            statement.setInt(2, personnage.getId());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
//                System.out.println("Life points updated successfully");
            } else {
//                System.out.println("Failed to update life points");
            }

        } catch (SQLException e) {
            System.out.println("Error while updating life points: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
