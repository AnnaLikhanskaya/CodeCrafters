import java.util.Comparator;

public interface CarComparator extends Comparator<Car> {
    @Override
    default int compare(Car car1, Car car2) {

        int compareModel = car1.getModel().compareTo(car2.getModel());
        if (compareModel != 0) {
            return compareModel;
        }

        int comparePower = car1.getPower() - car2.getPower();
        if (comparePower != 0) {
            return comparePower;
        }

        int compareYear = car1.getYear() - car2.getYear();
        if (compareYear != 0) {
            return compareYear;
        }
        return 0;
    }
}
