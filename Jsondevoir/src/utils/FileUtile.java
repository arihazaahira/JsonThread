package utils;

import Models.Order;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtile {

    public static void appendToFile(String filePath, Order order) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(order.toString() + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
