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

    @Override
    public RootCrop createFromInput(Scanner scanner) {
        String type;
        while (true) {
            System.out.println("Введите тип корнеплода:");
            type = scanner.next().trim();
            if (!type.isEmpty() && type.matches("[a-zA-Z\\s]+")) {
                break;
            } else {
                System.out.println("Тип корнеплода должен содержать только буквы. Пожалуйста, повторите ввод.");
            }
        }

        double weight;
        while (true) {
            System.out.println("Введите вес корнеплода:");
            String weightInput = scanner.next().trim();
            try {
                weight = Double.parseDouble(weightInput);
                if (weight > 0) {
                    break;
                } else {
                    System.out.println("Вес должен быть больше нуля.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Введите числовое значение:");
            }
        }

        String color;
        while (true) {
            System.out.println("Введите цвет корнеплода:");
            color = scanner.next().trim();
            if (!color.isEmpty() && color.matches("[a-zA-Z\\s]+")) {
                break;
            } else {
                System.out.println("Цвет должен содержать только буквы. Пожалуйста, повторите ввод.");
            }
        }

        return new RootCrop.Builder().type(type).weight(weight).color(color).build();
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
}