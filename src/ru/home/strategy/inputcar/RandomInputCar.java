package ru.home.strategy.inputcar;

import ru.home.model.Car;
import ru.home.strategy.interfaces.DataInputStrategy;
import ru.home.util.CustomArrayList;

import java.util.List;
import java.util.Random;

public class RandomInputCar implements DataInputStrategy<Car> {

    static Random random = new Random();

    @Override
    public CustomArrayList<Car> inputData() {
        CustomArrayList<Car> carCustomArrayList = new CustomArrayList<>();

        int lenListCars = random.nextInt(6) + 10;
        for (int i = 0; i < lenListCars; i++) {

            int power = random.nextInt(1, 1001);
            int year = random.nextInt(1900, 2026);

            String[] mylist = {"Trough", "Toyota", "Nissan", "BMW", "Lada", "Mazda", "Kia", "Vedrover"};
            String model = mylist[random.nextInt(mylist.length)];

            carCustomArrayList.add(new Car.Builder().power(power).model(model).year(year).build());
            }
        return carCustomArrayList;
    }
}
