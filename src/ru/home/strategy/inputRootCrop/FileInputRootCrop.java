package ru.home.strategy.inputRootCrop;


import ru.home.model.RootCrop;
import ru.home.strategy.interfaces.DataInputStrategy;
import ru.home.util.CustomArrayList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileInputRootCrop implements DataInputStrategy<RootCrop> {
    private String filePath;

    public FileInputRootCrop() {
        this.filePath = "C:\\\\Users\\\\andre\\\\IdeaProjects\\\\CodeCrafters\\\\src\\\\rootcrop.txt";
    }

    @Override
    public CustomArrayList<RootCrop> inputData() {
        CustomArrayList<RootCrop> list = new CustomArrayList<>();
        File file = new File(filePath);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String type = scanner.nextLine().trim();
                double weight = Double.parseDouble(scanner.nextLine().trim());
                String color = scanner.nextLine().trim();

                RootCrop rootVegetable = new RootCrop.Builder()
                        .type(type)
                        .weight(weight)
                        .color(color)
                        .build();

                list.add(rootVegetable);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + filePath);
            e.printStackTrace();
        }

        return list;
    }
}