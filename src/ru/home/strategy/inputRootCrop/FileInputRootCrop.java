package ru.home.strategy.inputRootCrop;


import ru.home.model.RootCrop;
import ru.home.strategy.interfaces.DataInputStrategy;
import ru.home.util.CustomArrayList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static ru.home.model.validator.DataValidator.validateVegetableData;

public class FileInputRootCrop implements DataInputStrategy<RootCrop> {
    private String filePath;

    public FileInputRootCrop() {
        this.filePath = "C:\\\\Users\\\\andre\\\\IdeaProjects\\\\CodeCrafters\\\\src\\\\rootcrop.txt";
    }

    @Override
    public CustomArrayList<RootCrop> inputData() {
        CustomArrayList<RootCrop> rootCrops = new CustomArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                RootCrop rootCrop = parseRootCropFromLine(line);
                if (rootCrop != null) {
                    rootCrops.add(rootCrop);
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
        return rootCrops;
    }

    private static RootCrop parseRootCropFromLine(String line) {
        String[] parts = line.split(",");
        if (parts.length != 3) {
            System.err.println("Неверный формат строки: " + line);
            return null;
        }

        try {
            String type = parts[0].trim();
            double weight = Double.parseDouble(parts[1].trim());
            String color = parts[2].trim();

            if (validateVegetableData(type, weight, color)) {
                return new RootCrop.Builder()
                        .type(type)
                        .weight(weight)
                        .color(color)
                        .build();
            } else {
                return null;
            }
        } catch (NumberFormatException e) {
            System.err.println("Неверный формат числа в строке: " + line);
            return null;
        }
    }
}
