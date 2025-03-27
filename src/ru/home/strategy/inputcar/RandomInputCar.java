package ru.home.strategy.inputcar;

import ru.home.model.Car;
import ru.home.strategy.interfaces.DataInputStrategy;
import ru.home.util.CustomArrayList;

import java.util.Random;

public class RandomInputCar implements DataInputStrategy<Car> {

    private final Random random;

    public RandomInputCar() {
        this.random = new Random();
    }

    @Override
    public CustomArrayList<Car> inputData() {
        CustomArrayList<Car> list = new CustomArrayList<>();

        int count = random.nextInt(10) + 1;

        for (int i = 0; i < count; i++) {
            String[] models = {"Toyota", "Honda", "Ford", "Chevrolet", "BMW", "Audi", "Mercedes", "Tesla"};
            String model = models[random.nextInt(models.length)];

            int power = random.nextInt(501) + 100;

            int year = random.nextInt(24) + 2000;

            Car car = new Car.Builder()
                    .model(model)
                    .power(power)
                    .year(year)
                    .build();

            list.add(car);
        }

        return list;
    }
}
