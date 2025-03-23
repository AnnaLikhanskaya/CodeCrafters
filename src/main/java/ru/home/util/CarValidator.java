package java.ru.home.util;

import java.ru.home.model.Car;

public class CarValidator {
    public static boolean validate(Car car) {
        return car.getPower() > 0 && car.getYear() > 1885 && car.getModel() != null && !car.getModel()
                .isEmpty();
    }
}

