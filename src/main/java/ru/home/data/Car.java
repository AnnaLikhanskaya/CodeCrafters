package main.java.ru.home.data;

public class Car implements Comparable<Car> {
    private final int power;
    private final String model;
    private final int productionYear;

    private Car(CarBuilder builder) {
        this.power = builder.power;
        this.model = builder.model;
        this.productionYear = builder.productionYear;
    }

    public int getPower() {
        return power;
    }

    public String getModel() {
        return model;
    }

    public int getProductionYear() {
        return productionYear;
    }

    @Override
    public String toString() {
        return "Car{" +
                "power=" + power +
                ", model='" + model + '\'' +
                ", productionYear=" + productionYear +
                '}';
    }

    @Override
    public int compareTo(Car other) {
        return Integer.compare(this.power, other.power);
    }

    public static class CarBuilder {
        private int power;
        private String model;
        private int productionYear;

        public CarBuilder power(int power) {
            this.power = power;
            return this;
        }

        public CarBuilder model(String model) {
            this.model = model;
            return this;
        }

        public CarBuilder productionYear(int productionYear) {
            this.productionYear = productionYear;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}