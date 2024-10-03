package fr.campus.donjons.db;
import fr.campus.donjons.equipements.Arme;
import fr.campus.donjons.equipements.Bouclier;
import fr.campus.donjons.equipements.EquipementOffensif;
import fr.campus.donjons.equipements.Sort;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;


public class EquipementRepository {

    private Random random = new Random();
    public  Arme getArmeById(int id){

        String query = "SELECT * FROM Armes WHERE Id = ?";
        try(Connection connection = Database.getConnection();
        PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                String type = resultSet.getString("Type");
                String nom = resultSet.getString("Nom");
                int puissance = resultSet.getInt("Puissance");
                return new Arme(id, type, nom, puissance);
            }else {
                System.out.println("Aucune arme trouvée avec l'id");
                return null;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public Sort getSortById(int id){
        String query = "SELECT * FROM Sort WHERE Id = ?";
        try (Connection connection = Database.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)){

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                String type = resultSet.getString("Type");
                String nom = resultSet.getString("Nom");
                int puissance = resultSet.getInt("Puissance");


                return new Sort(id, type, nom, puissance);
            }else {
                System.out.println("Aucune sort trouvée avec l'id");
                return null;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }


    public Bouclier getBouclierById(int id){
        String query = "SELECT * FROM Boucliers WHERE Id = ?";
        try (Connection connection = Database.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                String type = resultSet.getString("Type");
                String nom = resultSet.getString("Nom");
                int defense = resultSet.getInt("Defence");

                return new Bouclier(id, type, nom, defense);
            }else {
                System.out.println("Aucun bouclier avec l'id");
                return null;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    // Méthode pour récupérer une arme aléatoire
    public Arme getRandomArme() {
        String query = "SELECT * FROM Armes ORDER BY RAND() LIMIT 1"; // Utilisation de RAND() pour obtenir un résultat aléatoire
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            if (resultSet.next()) {
                int id = resultSet.getInt("Id");
                String type = resultSet.getString("Type");
                String nom = resultSet.getString("Nom");
                int puissance = resultSet.getInt("Puissance");

                return new Arme(id, type, nom, puissance);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération de l'arme : " + e.getMessage());
            e.printStackTrace();
        }
        return null; // Retourner null si aucune arme n'est trouvée
    }

    // Méthode pour récupérer un sort aléatoire
    public Sort getRandomSort() {
        String query = "SELECT * FROM Sorts ORDER BY RAND() LIMIT 1"; // Utilisation de RAND() pour obtenir un résultat aléatoire
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            if (resultSet.next()) {
                int id = resultSet.getInt("Id");
                String type = resultSet.getString("Type");
                String nom = resultSet.getString("Nom");
                int puissance = resultSet.getInt("Puissance");

                return new Sort(id, type, nom, puissance);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération du sort : " + e.getMessage());
            e.printStackTrace();
        }
        return null; // Retourner null si aucun sort n'est trouvé
    }


    public Bouclier getRandomBouclier() {
        String query = "SELECT * FROM Boucliers ORDER BY RAND() LIMIT 1"; // Utilisez 'Boucliers' pour obtenir un bouclier aléatoire
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String type = resultSet.getString("type");
                String nom = resultSet.getString("nom");
                int defense = resultSet.getInt("defense");

                return new Bouclier(id, type, nom, defense);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération du bouclier : " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

}
