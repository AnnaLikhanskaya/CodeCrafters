package main.java.ru.home.data;

public class CarValidator implements DataValidator<Car> {
    @Override
    public boolean isValid(Car car) {
        return car.getPower() > 0 &&
                car.getModel() != null && !car.getModel().isEmpty() &&
                car.getProductionYear() > 1900 && car.getProductionYear() <= 2025; //Обновить
    }
}