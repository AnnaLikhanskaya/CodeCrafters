package main.java.ru.home;

import main.java.ru.home.utill.BinarySearch;
import main.java.ru.home.utill.MergeSortStrategy;
import main.java.ru.home.utill.SortStrategy;
import main.java.ru.home.utill.Car;
import main.java.ru.home.utill.CustomArrayList;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        CustomArrayList<Car> cars = new CustomArrayList<>();
//        SortStrategy<Car> strategy = new MergeSortStrategy<>();
//        cars.add(new Car.Builder().power(500).model("Mazda").year(2000).build());
//        cars.add(new Car.Builder().power(200).model("Audi").year(2005).build());
//        cars.add(new Car.Builder().power(300).model("BMW").year(2015).build());
//        System.out.println(cars);
//        strategy.sort(cars);
//        System.out.println(cars);
//        BinarySearch<Car> binarySearch = new BinarySearch<>();
//        System.out.println(cars.get(binarySearch.search(cars,new Car.Builder().power(500).model("Mazda").year(2000).build())));

        Scanner scanner = new Scanner(System.in);
        CustomArrayList<Car> cars = new CustomArrayList<>();
        SortStrategy<Car> strategy = new MergeSortStrategy<>();

        while (true) {
            System.out.println("1. Add Car |  2. Sort Car |  3. Search Car |  4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter power, model, year:");
                    String product = scanner.nextLine();
                    String[] split = product.split(", ");
                    int power = Integer.parseInt(split[0]);
                    String model = split[1];
                    int year = Integer.parseInt(split[2]);
                    cars.add(new Car.Builder().power(power).model(model).year(year).build());
                    System.out.println("Car added: " + cars);
                    break;
                case 2:
                    System.out.println("Sorting");
                    strategy.sort(cars);
                    for (int i = 0; i < cars.size(); i++) {
                        System.out.println(cars.get(i));
                    }
                    break;
                case 3:
                    System.out.println("Enter model to search:");
                    String prod = scanner.nextLine();
                    String[] spl = prod.split(", ");
                    int p = Integer.parseInt(spl[0]);
                    String m = spl[1];
                    int y = Integer.parseInt(spl[2]);
                    BinarySearch<Car> binarySearch = new BinarySearch<>();
                    Car car = cars.get(binarySearch
                            .search(cars, new Car.Builder().power(p).model(m).year(y).build()));
                    System.out.println(car);
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

}