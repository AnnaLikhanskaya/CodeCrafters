
public class Car implements CarComparator{

    private final int power;
    private final String model;
    private final int year;

    /*стоит ли решать продлему с пустым полем при создании объекта класса ?? */

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
            /*если валидация не пройдена - возвращаем сообщение и null*/
            if (validateCheck()) {
                return new Car(power, model, year);
            }
            System.out.println("Заполните поля правильно");
            return null;
        }
        /* проверяем, что power в диапозоне 1 - 1000, model не пустая строка, year в диапозоне 1901 - 2025*/
        public boolean validateCheck() {
            return ((power > 0 && power < 1001) && (model != null && !model.isEmpty()) && (year < 2026 & year > 1900));
        }
    }
}