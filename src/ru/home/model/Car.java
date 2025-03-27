package ru.home.model;

import ru.home.strategy.interfaces.Searchable;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Car implements Comparable<Car>, Searchable<Car> {
    private int power;
    private String model;
    private int year;

    private Car(Builder builder) {
        this.power = builder.power;
        this.model = builder.model;
        this.year = builder.year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "power=" + power +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }


    @Override
    public int compareTo(Car other) {
        if (this.power != other.power) {
            return Integer.compare(this.power, other.power);
        } else if (!this.model.equals(other.model)) {
            return this.model.compareTo(other.model);
        } else {
            return Integer.compare(this.year, other.year);
        }
    }

    @Override
    public Car createFromInput(Scanner scanner) {
        System.out.println("Введите мощность:");
        int power = getValidatedIntInput(scanner, "Некорректный ввод. Введите число:");

        System.out.println("Введите модель:");
        String model;
        while (true) {
            model = scanner.nextLine().trim();
            if (!model.isEmpty() && isValidModel(model)) {
                break;
            } else {
                System.out.println("Некорректный ввод. Модель должна содержать только буквы. Повторите ввод.");
            }
        }

        System.out.println("Введите год выпуска:");
        int year = getValidatedIntInput(scanner, "Некорректный ввод. Введите число:");

        return new Car.Builder().power(power).model(model).year(year).build();
    }

    private int getValidatedIntInput(Scanner scanner, String errorMessage) {
        while (!scanner.hasNextInt()) {
            System.out.println(errorMessage);
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    private boolean isValidModel(String model) {
        return Pattern.matches("[a-zA-Z\\s]+", model);
    }

    public static class Builder {
        private int power;
        private String model;
        private int year;

        public Builder power(int power) {
            this.power = power;
            return this;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder year(int year) {
            this.year = year;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }

    public int getPower() {
        return power;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }
}