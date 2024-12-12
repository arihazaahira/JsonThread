package DAO;


import Models.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDAO {

    public static void insertOrder(Order order) {
        String query = "INSERT INTO `order` (id, date, amount, customer_id) VALUES (?, ?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, order.getId());
            statement.setDate(2, java.sql.Date.valueOf(order.getDate()));
            statement.setBigDecimal(3, order.getAmount());
            statement.setInt(4, order.getCustomerId());

            statement.executeUpdate();
            System.out.println("Commande insérée avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
