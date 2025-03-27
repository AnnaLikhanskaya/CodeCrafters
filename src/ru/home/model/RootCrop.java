package ru.home.model;

import ru.home.strategy.interfaces.Searchable;

import java.util.Scanner;

public class RootCrop implements Comparable<RootCrop>, Searchable<RootCrop> {
    private String type;
    private double weight;
    private String color;

    private RootCrop(Builder builder) {
        this.type = builder.type;
        this.weight = builder.weight;
        this.color = builder.color;
    }

    public String getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }


    public static class Builder {
        private String type;
        private double weight;
        private String color;

        public Builder type(String type) {
            this.type = type;
            return this;
        }


        public Builder weight(double weight) {
            this.weight = weight;
            return this;
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public RootCrop build() {
            return new RootCrop(this);
        }
    }

    @Override
    public int compareTo(RootCrop other) {
        if (!this.type.equals(other.type)) return this.type.compareTo(other.type);
        if (this.weight != other.weight) return Double.compare(this.weight, other.weight);
        return this.color.compareTo(other.color);
    }

    @Override
    public String toString() {
        return "Vegetable{type='" + type + "', weight=" + weight + ", color='" + color + "'}";
    }

    @Override
    public RootCrop createFromInput(Scanner scanner) {
        System.out.println("Введите тип корнеплода:");
        String type = "";
        while (type.isEmpty()) {
            type = scanner.nextLine().trim();
            if (type.isEmpty()) {
                System.out.println("Тип не может быть пустым. Пожалуйста, введите тип.");
            }
        }

        System.out.println("Введите вес корнеплода:");
        double weight = 0;
        while (weight <= 0) {
            try {
                weight = Double.parseDouble(scanner.nextLine().trim());
                if (weight <= 0) {
                    System.out.println("Вес должен быть положительным числом. Пожалуйста, введите вес.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Введите число:");
            }
        }

        System.out.println("Введите цвет корнеплода:");
        String color = "";
        while (color.isEmpty()) {
            color = scanner.nextLine().trim();
            if (color.isEmpty()) {
                System.out.println("Цвет не может быть пустым. Пожалуйста, введите цвет.");
            }
        }

        return new RootCrop.Builder().type(type).weight(weight).color(color).build();
    }
}