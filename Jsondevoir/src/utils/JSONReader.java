package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import Models.Order;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JSONReader {

    public static List<Order> readOrdersFromFile(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(filePath), new TypeReference<List<Order>>() {});
    }
}
