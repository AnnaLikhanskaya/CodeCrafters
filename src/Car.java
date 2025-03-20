
public class Car {

    private final int power;
    private final String model;
    private final int year;

    private Car(int power, String model, int year) {
        this.power = power;
        this.model = model;
        this.year = year;
    }

    public int getPower() {return power;}
    public String getModel() {return model;}
    public int getYear() {return year;}

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("Car [brand=").append(model)
                .append(", power=").append(power)
                .append(", year=").append(year)
                .append("]");
        return stringBuilder.toString();
    }

    public static CarBuilder carBuilder() {
        return carBuilder();
    }

    public static class CarBuilder {

        private int power;
        private String model;
        private int year;


        public CarBuilder power(int power) {
            this.power = power;
            return this;
        }

        public CarBuilder model(String model) {
            this.model = model;
            return this;
        }

        public CarBuilder year(int year) {
            this.year = year;
            return this;
        }

        public Car build() {
            return new Car(power, model, year);
        }
    }
}
