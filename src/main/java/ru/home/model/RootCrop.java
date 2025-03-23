package java.ru.home.model;

import java.util.Objects;

public class RootCrop implements Comparable<RootCrop> {
    private String type;
    private double weight;
    private String color;

    private RootCrop(Builder builder) {
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

        public RootCrop build() {
            return new RootCrop(this);
        }
    }

    @Override
    public int compareTo(RootCrop other) {
        return Double.compare(this.weight, other.weight);
    }

    @Override
    public String toString() {
        return "RootCrop{" +
                "type='" + type + '\'' +
                ", weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RootCrop rootCrop = (RootCrop) o;
        return Double.compare(weight, rootCrop.weight) == 0 && Objects.equals(type, rootCrop.type) && Objects.equals(color, rootCrop.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, weight, color);
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
// Getters, toString, equals, hashCode
}