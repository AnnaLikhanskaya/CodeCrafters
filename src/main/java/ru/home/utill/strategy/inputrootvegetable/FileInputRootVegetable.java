package main.java.ru.home.utill.strategy.inputrootvegetable;

import main.java.ru.home.utill.CustomArrayList;
import main.java.ru.home.utill.model.RootVegetable;
import main.java.ru.home.utill.strategy.interfaces.DataInputStrategy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileInputRootVegetable implements DataInputStrategy<RootVegetable> {
    private String filePath;


    @Override
    public CustomArrayList<RootVegetable> inputData() {
        CustomArrayList<RootVegetable> list = new CustomArrayList<>();
        File file = new File(filePath);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String type = scanner.nextLine().trim();
                double weight = Double.parseDouble(scanner.nextLine().trim());
                String color = scanner.nextLine().trim();

                RootVegetable rootVegetable = new RootVegetable.Builder()
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