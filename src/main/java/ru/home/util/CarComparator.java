package java.ru.home.util;

import java.ru.home.model.Car;
import java.util.Comparator;

public class CarComparator implements Comparator<Car> {
    @Override
    public int compare(Car car1, Car car2) {
        return Integer.compare(car1.getPower(), car2.getPower());
    }
}