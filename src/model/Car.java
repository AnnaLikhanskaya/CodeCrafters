package model;

public class Car implements Comparable<Car>{

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
                .append("model.Car [brand=").append(model)
                .append(", power=").append(power)
                .append(", year=").append(year)
                .append("]");
        return stringBuilder.toString();
    }

    public static CarBuilder carBuilder() {
        return carBuilder();
    }

    @Override
    public int compareTo(Car o) {
        int compareModel = this.getModel().compareTo(o.getModel());
        if (compareModel != 0) {
            return compareModel; /*если модель разная - возвращаем результат, если нет - идем дальше*/
        }
        int comparePower = this.getPower() - o.getPower();
        if (comparePower != 0) {
            return comparePower; /*если мощность разная - возвращаем результат, если нет - идем дальше*/
        }

        int compareYear = this.getYear() - o.getYear();
        if (compareYear != 0) {
            return compareYear; /*сравниваем год*/
        }
        return 0;
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
            if (validateCheck() == 0) {
                return new Car(power, model, year);
            }
            System.out.println("Заполните поля у всех объектов правильно");
//            return null;
            /*Возвращаем условный объект автомобиля,
            чтобы избежать NullPointerException и остальные объекты создались правильно*/
            return new Car(power = 0, model = "Я ошибка", year = 0);
        }
        /* проверяем, что power в диапозоне 1 - 1000, model не пустая строка, year в диапозоне 1901 - 2025*/
        public int validateCheck() {
            if (!(power > 0 && power < 1001)) {
                System.out.println("Введите корректные данные мощности авто (от 1 до 1000)");
                return 1;
            }
            if (!(model != null && !model.isEmpty())) {
                System.out.println("Поле модель не может быть пустым");
                return 2;
            }
            if (!(year < 2026 & year > 1900)) {
                System.out.println("Поле год. Введите год в диапазоне от 1901 до 2025");
                return 3;
            }
            return 0;
//            return ((power > 0 && power < 1001) && (model != null && !model.isEmpty()) && (year < 2026 & year > 1900));
        }
    }
}