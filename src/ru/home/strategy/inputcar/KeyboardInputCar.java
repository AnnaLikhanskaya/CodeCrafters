package ru.home.strategy.inputcar;

import java.util.Scanner;
import ru.home.model.Car;

public class KeyboardInputCar {

//    Scanner scanner = new Scanner(System.in);

    public Car inputKeyboardCar(Scanner scanner) {

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

        return new Car.Builder().power(power).model(model).year(year).build();
    }

    public static void main(String[] args) {
        Car car = new KeyboardInputCar().inputKeyboardCar(new Scanner(System.in));

        System.out.println(car);
    }

}
