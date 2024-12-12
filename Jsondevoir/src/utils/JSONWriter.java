package utils;

import Models.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JSONWriter {


    public static void writeOrdersToFile(String filePath, List<Order> orders) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT); // Pour un format JSON lisible

        objectMapper.writeValue(new File(filePath), orders);
    }
}
