package main.java.ru.home.utill.strategy.inputcar;

import main.java.ru.home.utill.CustomArrayList;
import main.java.ru.home.utill.model.Car;
import main.java.ru.home.utill.strategy.interfaces.DataInputStrategy;

import java.util.Scanner;

public class ManualInputCar implements DataInputStrategy<Car> {
    private final Scanner scanner;

    public ManualInputCar(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public CustomArrayList<Car> inputData() {
        CustomArrayList<Car> list = new CustomArrayList<>();
        System.out.println("Введите количество машин:");
        int count = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < count; i++) {
            System.out.println("Введите мощность:");
            int power = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Введите модель:");
            String model = scanner.nextLine();

            System.out.println("Введите год выпуска:");
            int year = scanner.nextInt();
            scanner.nextLine();

            Car car = new Car.Builder().power(power).model(model).year(year).build();
            list.add(car);
        }

        return list;
    }
}