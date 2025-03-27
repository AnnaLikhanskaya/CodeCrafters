package ru.home.model;

import ru.home.strategy.interfaces.Searchable;

import java.util.Scanner;

import static ru.home.model.validator.DataValidator.validateVegetableData;

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
        System.out.println("Введите тип корнеплода:");
        String type = scanner.next();
        System.out.println("Введите вес корнеплода:");
        while(!scanner.hasNextInt()){
            System.out.println("Введите числовое значение!");
        }
        int weight = scanner.nextInt();
        System.out.println("Введите цвет корнеплода:");
        String color = scanner.next();

        while(!validateVegetableData(type, weight, color)) {
            System.out.println("Введите правильные данные!");
            System.out.println("Вес должен бытьт больше нуля.");
            System.out.println("А тип и цвет не может быть пустой строкой.");
            System.out.println();
            System.out.println("Введите тип корнеплода:");
            type = scanner.next();
            System.out.println("Введите вес корнеплода:");
            while(!scanner.hasNextInt()){
                System.out.println("Введите числовое значение!");
            }
            weight = scanner.nextInt();
            System.out.println("Введите цвет корнеплода:");
            color = scanner.next();
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