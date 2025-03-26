package ru.home.strategy.inputcar;

import java.util.Scanner;
import ru.home.model.Car;
import ru.home.model.validator.DataValidator;
import ru.home.strategy.interfaces.DataInputStrategy;
import ru.home.util.CustomArrayList;

public class ManualInputCar implements DataInputStrategy<Car> {

//    public static Car inputKeyboardCar() {
//
//        Scanner scanner = new Scanner(System.in);
//
//        boolean flag = false;
//
//        int power = 0;
//        String model = null;
//        int year = 0;
//
//        while (!flag) {
//            System.out.println("Введите мощность (от 1 до 1000)");
//            if (!scanner.hasNextInt()) {
//                System.out.println("Введите число от 1 до 1000");
//            }
//            power = scanner.nextInt();
//            scanner.nextLine();
//
//            System.out.println("Введите марку авто");
//            model = scanner.nextLine();
//
//            System.out.println("Введите год выпуска авто");
//            if (!scanner.hasNextInt()) {
//                System.out.println("Введите число от 1900 до 2025");
//            }
//            year = scanner.nextInt();
//
//            if (!(DataValidator.validateCarData(power, model, year))) {
//                System.out.println("Объект не создан - вы допустили ошибку в параметрах");
//                System.out.println("Проверьте параметры и введите их заново");
//            } else {
//                flag = true;
//            }
//        }
//        return new Car.Builder().power(power).model(model).year(year).build();
//    }

    @Override
    public CustomArrayList<Car> inputData() {
        Scanner scanner = new Scanner(System.in);

        CustomArrayList<Car> carCustomArrayList = new CustomArrayList<>();
        Car car = new Car.Builder().build().createFromInput(scanner);
        carCustomArrayList.add(car);

        int answer = 0;

        while (answer != 2) {
            System.out.println("Создать ещё один автомобиль?");
            System.out.println("Да - 1, Нет - 2");
            answer = scanner.nextInt();

        switch (answer) {
            case 1: Car car1 = new Car.Builder().build().createFromInput(scanner);
                carCustomArrayList.add(car1);
                break;
            }
        }
        return carCustomArrayList;
    }

    public static void main(String[] args) {
        CustomArrayList<Car> list = new ManualInputCar().inputData();
        System.out.println(list);
    }
}
