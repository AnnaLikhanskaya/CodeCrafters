package main.java.ru.home.utill.model;

// Класс Корнеплод
public class RootVegetable implements Comparable<RootVegetable> {
    private String type; // Тип
    private double weight; // Вес
    private String color; // Цвет

    private RootVegetable(Builder builder) {
        this.type = builder.type;
        this.weight = builder.weight;
        this.color = builder.color;
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

        public RootVegetable build() {
            return new RootVegetable(this);
        }
    }

    @Override
    public int compareTo(RootVegetable other) {
        if (!this.type.equals(other.type)) return this.type.compareTo(other.type);
        if (this.weight != other.weight) return Double.compare(this.weight, other.weight);
        return this.color.compareTo(other.color);
    }

    @Override
    public String toString() {
        return "Vegetable{type='" + type + "', weight=" + weight + ", color='" + color + "'}";
    }
}