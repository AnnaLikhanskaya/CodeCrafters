package ru.home.strategy.inputRootCrop;

import ru.home.model.RootCrop;
import ru.home.strategy.interfaces.DataInputStrategy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static ru.home.model.validator.DataValidator.validateVegetableData;

public class FileInputRootCrop implements DataInputStrategy<RootCrop> {
    String filePath;

    public FileInputRootCrop() {
        this.filePath = "C:\\CodeCrafters\\car.txt";
    }

    @Override
    public CustomArrayList<RootCrop> inputData() {
        CustomArrayList<RootCrop> rootCrops = new CustomArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                RootCrop rootCrop = parseRootCropFromLine(line);
                if (rootCrop != null) {
                    rootCrops.Add(rootCrop);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return rootCrops;
    }

    private static RootCrop parseRootCropFromLine(String line) {
        String[] parts = line.split(","); // Предполагаем, что данные разделены запятыми
        if (parts.length != 3) {
            System.err.println("Invalid line format: " + line);
            return null;
        }

        try {
            String type = parts[0].trim();
            int weight = Integer.parseInt(parts[1].trim());
            String color = parts[2].trim();

            if (validateVegetableData(type, weight, color)){
                return new RootCrop.Builder()
                        .type(type)
                        .weight(weight)
                        .color(color)
                        .build();
            }else{
                return null;
            }

        } catch (NumberFormatException e) {
            System.err.println("Invalid number format in line: " + line);
            return null;
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid argument: " + line);
            return null;
        }
    }

}
