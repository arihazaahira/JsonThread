package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
        private static final String DB_URL = "jdbc:mysql://localhost:3306/jsondevoir";
        private static final String DB_USER = "root";
        private static final String DB_PASSWORD = "";

        public static Connection getConnection() throws SQLException {
            Connection connection = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                System.out.println("Connexion réussie à la base de données !");
            } catch (ClassNotFoundException e) {
                System.err.println("Erreur : Pilote JDBC non trouvé.");
                e.printStackTrace();
                throw new SQLException("Pilote JDBC non chargé", e);
            } catch (SQLException e) {
                System.err.println("Erreur lors de la connexion à la base de données.");
                e.printStackTrace();
                throw e;
            }
            return connection;
        }

        public static void closeConnection(Connection connection) {
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Connexion fermée.");
                } catch (SQLException e) {
                    System.err.println("Erreur lors de la fermeture de la connexion.");
                    e.printStackTrace();
                }
            }
        }
    }


