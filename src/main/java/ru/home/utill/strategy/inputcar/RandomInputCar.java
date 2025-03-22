package main.java.ru.home.utill.strategy.inputcar;

import main.java.ru.home.utill.CustomArrayList;
import main.java.ru.home.utill.model.Car;
import main.java.ru.home.utill.strategy.interfaces.DataInputStrategy;

import java.util.Random;

public class RandomInputCar implements DataInputStrategy<Car> {
    private Random random;

    public RandomInputCar() {
        this.random = new Random();
    }

    @Override
    public CustomArrayList<Car> inputData() {
        CustomArrayList<Car> list = new CustomArrayList<>();

        // Генерация случайного количества машин (например, от 1 до 10)
        int count = random.nextInt(10) + 1;

        for (int i = 0; i < count; i++) {
            // Генерация случайной мощности (например, от 50 до 500 л.с.)
            int power = random.nextInt(451) + 50;

            // Генерация случайной модели (например, из предопределенного списка)
            String[] models = {"Toyota", "Ford", "BMW", "Audi", "Mercedes"};
            String model = models[random.nextInt(models.length)];

            // Генерация случайного года выпуска (например, от 2000 до 2023)
            int year = random.nextInt(24) + 2000;

            // Создание объекта Car с использованием Builder
            Car car = new Car.Builder()
                    .power(power)
                    .model(model)
                    .year(year)
                    .build();

            list.add(car);
        }

        return list;
    }
}