package ru.home.strategy.inputcar;

import ru.home.model.Car;
import ru.home.model.validator.DataValidator;
import ru.home.strategy.interfaces.DataInputStrategy;
import ru.home.util.CustomArrayList;

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
            Car car = new Car.Builder().build().createFromInput(scanner);
            int power = car.getPower();
            String model = car.getModel();
            int year = car.getYear();

            if (DataValidator.validateCarData(power, model, year)) {
                list.add(car);
            } else {
                System.out.println("Некорректные данные. Повторите ввод.");
                i--;
            }
        }
        return list;
    }
}
