package ru.home.strategy.inputcar;

import ru.home.model.Car;
import ru.home.model.validator.DataValidator;
import ru.home.strategy.interfaces.DataInputStrategy;
import ru.home.util.CustomArrayList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;


public class FileInputCar implements DataInputStrategy<Car> {
    private String filePath;

    public FileInputCar() {
        this.filePath = "C:\\Users\\andre\\IdeaProjects\\CodeCrafters\\src\\car.txt";
    }

    @Override
    public CustomArrayList<Car> inputData() {
        CustomArrayList<Car> list = new CustomArrayList<>();
        File file = new File(filePath);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                int power = Integer.parseInt(scanner.nextLine().trim());
                String model = scanner.nextLine().trim();
                int year = Integer.parseInt(scanner.nextLine().trim());

                Car car = new Car.Builder()
                        .power(power)
                        .model(model)
                        .year(year)
                        .build();

                list.add(car);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + filePath);
            e.printStackTrace();
        }

        return list;
    }
}