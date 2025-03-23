package model;

import java.util.Comparator;

/*сравнение происходит по всем полям. начинаем с марки авто*/
public interface CarComparator extends Comparator<Car> {
    @Override
    default int compare(Car car1, Car car2) {

        int compareModel = car1.getModel().compareTo(car2.getModel());
        if (compareModel != 0) {
            return compareModel; /*если модель разная - возвращаем результат, если нет - идем дальше*/
        }

        int comparePower = car1.getPower() - car2.getPower();
        if (comparePower != 0) {
            return comparePower; /*если мощность разная - возвращаем результат, если нет - идем дальше*/
        }

        int compareYear = car1.getYear() - car2.getYear();
        if (compareYear != 0) {
            return compareYear; /*сравниваем год*/
        }
        return 0;
    }
}

/*пример использования*/
/*    public static void main(String[] args) throws Exception {

        model.CarComparator comp = new model.CarComparator() {
            @Override
            public int compare(model.Car car1, model.Car car2) {
                return model.CarComparator.super.compare(car1, car2);
                }
            };

        List<model.Car> cars = List.of();

        cars.stream()
                 .sorted(comp)
                 .forEach(System.out::println);
    }*/
