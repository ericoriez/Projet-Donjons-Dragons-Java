package fr.campus.donjons.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/DonjonsEtDragons";
    private static final String USER = "root";
    private static final String PASSWORD = "oceane11";

    public static Connection getConnection() {

        Connection connection = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
//            System.out.println("Connected to database");
        }catch (SQLException e) {
            System.out.println("Error connecting to database"+e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void main(String[] args) {
        Connection connection = getConnection();
        if (connection != null) {
            System.out.println("La connexion est active");
        } else {
            System.out.println("La connexion a échoué");
        }
    }
}
