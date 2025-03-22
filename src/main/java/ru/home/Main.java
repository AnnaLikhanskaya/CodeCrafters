package main.java.ru.home;//package main.java.ru.home;

import main.java.ru.home.utill.BinarySearch;
import main.java.ru.home.utill.MergeSort;
import main.java.ru.home.utill.model.Book;
import main.java.ru.home.utill.model.Car;
import main.java.ru.home.utill.model.RootVegetable;
import main.java.ru.home.utill.strategy.interfaces.DataInputStrategy;
import main.java.ru.home.utill.CustomArrayList;
import main.java.ru.home.utill.strategy.inputbook.FileInputBook;
import main.java.ru.home.utill.strategy.inputbook.ManualInputBook;
import main.java.ru.home.utill.strategy.inputbook.RandomInputBook;
import main.java.ru.home.utill.strategy.inputcar.FileInputCar;
import main.java.ru.home.utill.strategy.inputcar.ManualInputCar;
import main.java.ru.home.utill.strategy.inputcar.RandomInputCar;
import main.java.ru.home.utill.strategy.inputrootvegetable.FileInputRootVegetable;
import main.java.ru.home.utill.strategy.inputrootvegetable.ManualInputRootVegetable;
import main.java.ru.home.utill.strategy.inputrootvegetable.RandomInputRootVegetable;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите тип данных (1 - Автомобиль, 2 - Книга, 3 - Корнеплод):");
            int type = scanner.nextInt();
            System.out.println("Выберите способ ввода данных (1 - Вручную, 2 - Из файла, 3 - Случайно):");
            int inputMethod = scanner.nextInt();
            DataInputStrategy<Car> car = null;
            DataInputStrategy<Book> book = null;
            DataInputStrategy<RootVegetable> rootVegetable = null;
            CustomArrayList<Car> listCar = null;
            CustomArrayList<RootVegetable> listRoot = null;
            CustomArrayList<Book> listBook = null;
            switch (inputMethod) {
                case 1:
                    if (type == 1) {
                        car = new ManualInputCar(scanner);
                    }
                    if (type == 2) {
                        book = new ManualInputBook(scanner);
                    }
                    if (type == 3) {
                        rootVegetable = new ManualInputRootVegetable(scanner);
                    }
                    break;
                case 2:
                    if (type == 1) {
                        car = new FileInputCar();
                    }
                    if (type == 2) {
                        book = new FileInputBook();
                    }
                    if (type == 3) {
                        rootVegetable = new FileInputRootVegetable();
                    }
                    break;
                case 3:
                    if (type == 1) {
                        car = new RandomInputCar();
                    }
                    if (type == 2) {
                        book = new RandomInputBook();
                    }
                    if (type == 3) {
                        rootVegetable = new RandomInputRootVegetable();
                    }
                    break;

                default:
                    System.out.println("Неверный выбор");
                    continue;
            }


            if (car != null) {
                listCar = car.inputData();
                System.out.println("До сортировки: " + listCar);
                MergeSort<Car> sorter = new MergeSort<>();
                sorter.sort(listCar);
                System.out.println("После сортировки: " + listCar);
            } else if (book != null) {
                listBook = book.inputData();
                System.out.println("До сортировки: " + listBook);
                MergeSort<Book> sorter = new MergeSort<>();
                sorter.sort(listBook);
                System.out.println("После сортировки: " + listBook);
            } else if (rootVegetable != null) {
                listRoot = rootVegetable.inputData();
                System.out.println("До сортировки: " + listRoot);
                MergeSort<RootVegetable> sorter = new MergeSort<>();
                sorter.sort(listRoot);
                System.out.println("После сортировки: " + listRoot);
            }

            System.out.println("Хотите выполнить бинарный поиск? (1 - Да, 2 - Нет):");
            int searchChoice = scanner.nextInt();
            if (searchChoice == 1) {
                System.out.println("Введите элемент для поиска:");
                if (listCar != null) {
                    BinarySearch<Car> binarySearch = new BinarySearch<>();
                    Car carFind = new Car.Builder().power(200).model("Mazda").year(2019).build();
                    int index = binarySearch.search(listCar, carFind);
                    check(index);
                }
                if (listBook != null) {
                    BinarySearch<Book> binarySearch = new BinarySearch<>();
//                    C carFind = new Car.Builder().power(200).model("Mazda").year(2019).build();
//                    int index = binarySearch.search(listBook, bookFind);
//                    check(index);
                }
                if (listRoot != null) {
                    BinarySearch<RootVegetable> binarySearch = new BinarySearch<>();
//                    Car carFind = new Car.Builder().power(200).model("Mazda").year(2019).build();
//                    int index = binarySearch.search(listRoot, rootFind);
//                    check(index);
                }
            }
            System.out.println("Хотите выйти? (1 - Да, 2 - Нет):");
            int exitChoice = scanner.nextInt();
            if (exitChoice == 1) {
                break;
            }
        }
    }

    private static void check(int index) {
        if (index != -1) {
            System.out.println("Элемент найден на позиции: " + index);
        } else {
            System.out.println("Элемент не найден");
        }
    }
}




