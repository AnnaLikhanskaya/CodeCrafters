package main.java.ru.home.utill.strategy.inputcar;

import main.java.ru.home.utill.CustomArrayList;
import main.java.ru.home.utill.model.Car;
import main.java.ru.home.utill.strategy.interfaces.DataInputStrategy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileInputCar implements DataInputStrategy<Car> {
    private String filePath;

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