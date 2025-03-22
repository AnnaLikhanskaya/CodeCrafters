package main.java.ru.home.file;

import java.io.*;
import java.util.List;

public class FileHandler {

    public <T> List<T> readFromFile(String filePath, Class<T> clazz) {
        // TODO: Implement file reading and parsing logic based on the class type
        return null; // Placeholder
    }

    public <T> void writeToFile(String filePath, List<T> data, boolean append) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, append))) {
            for (T item : data) {
                writer.write(item.toString()); // Assuming toString() gives a suitable string representation
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}