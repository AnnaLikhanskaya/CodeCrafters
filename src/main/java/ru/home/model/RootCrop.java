package main.java.ru.home.model;

public class RootCrop implements Comparable<RootCrop> {
    private final String type;
    private final int weight;
    private final String color;

    private RootCrop(RootCropBuilder builder) {
        this.type = builder.type;
        this.weight = builder.weight;
        this.color = builder.color;
    }

    public String getType() {
        return type;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
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
    public int compareTo(RootCrop other) {
        return Integer.compare(this.weight, other.weight);
    }

    public static class RootCropBuilder {
        private String type;
        private int weight;
        private String color;

        public RootCropBuilder type(String type) {
            this.type = type;
            return this;
        }

        public RootCropBuilder weight(int weight) {
            this.weight = weight;
            return this;
        }

        public RootCropBuilder color(String color) {
            this.color = color;
            return this;
        }

        public RootCrop build() {
            return new RootCrop(this);
        }
    }
}