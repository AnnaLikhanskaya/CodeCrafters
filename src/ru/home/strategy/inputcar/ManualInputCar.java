package ru.home.strategy.inputcar;

import java.util.Scanner;
import ru.home.model.Car;
import ru.home.model.validator.DataValidator;
import ru.home.strategy.interfaces.DataInputStrategy;
import ru.home.util.CustomArrayList;

public class ManualInputCar implements DataInputStrategy<Car> {

    public static Car inputKeyboardCar() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите мощность (от 1 до 1000)");
        if (!scanner.hasNextInt()) {
            System.out.println("Введите число от 1 до 1000");
        }
        int power = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Введите марку авто");
        String model = scanner.nextLine();

        System.out.println("Введите год выпуска авто");
        if (!scanner.hasNextInt()) {
            System.out.println("Введите число от 1900 до 2025");
        }
        int year = scanner.nextInt();

        if (!(DataValidator.validateCarData(power, model, year))) {
            System.out.println("Объект не создан - вы допустили ошибку в параметрах");
            System.out.println("Проверьте параметры и введите их заново");
            return  inputKeyboardCar();
        }
        return new Car.Builder().power(power).model(model).year(year).build();
    }

    @Override
    public CustomArrayList<Car> inputData() {

        CustomArrayList<Car> carCustomArrayList = new CustomArrayList<>();
        Car car = inputKeyboardCar();
        carCustomArrayList.add(car);

        Scanner scanner = new Scanner(System.in);
        int answer = 0;

        while (answer != 2) {
            System.out.println("Создать ещё один автомобиль?");
            System.out.println("Да - 1, Нет - 2");
            answer = scanner.nextInt();

        switch (answer) {
            case 1: Car car1 = inputKeyboardCar();
                carCustomArrayList.add(car1);
                break;
            }
        }
        return carCustomArrayList;
    }
}
