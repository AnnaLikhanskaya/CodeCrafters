package ru.home;

import ru.home.model.Book;
import ru.home.model.Car;
import ru.home.model.RootCrop;
import ru.home.strategy.inputRootCrop.FileInputRootCrop;
import ru.home.strategy.inputRootCrop.ManualInputRootCrop;
import ru.home.strategy.inputRootCrop.RandomInputRootCrop;
import ru.home.strategy.inputbook.FileInputBook;
import ru.home.strategy.inputbook.ManualInputBook;
import ru.home.strategy.inputbook.RandomInputBook;
import ru.home.strategy.inputcar.FileInputCar;
import ru.home.strategy.inputcar.ManualInputCar;
import ru.home.strategy.inputcar.RandomInputCar;
import ru.home.strategy.interfaces.DataInputStrategy;
import ru.home.util.BinarySearch;
import ru.home.util.CustomArrayList;
import ru.home.util.MergeSort;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearch<Car> carBinarySearch = new BinarySearch<>();
        BinarySearch<Book> bookBinarySearch = new BinarySearch<>();
        BinarySearch<RootCrop> rootVegetableBinarySearch = new BinarySearch<>();
        MergeSort<Car> mergeCar = new MergeSort<>();
        MergeSort<Car> mergeBook = new MergeSort<>();
        MergeSort<Car> mergeVegetable = new MergeSort<>();
        while (true) {
            System.out.println("Выберите тип данных (1 - Автомобиль, 2 - Книга, 3 - Корнеплод):");
            int type = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Выберите способ ввода данных (1 - Вручную, 2 - Из файла, 3 - Случайно):");
            int inputMethod = scanner.nextInt();
            DataInputStrategy<Car> car = null;
            DataInputStrategy<Book> book = null;
            DataInputStrategy<RootCrop> rootCrop = null;
            CustomArrayList<Car> listCar = null;
            CustomArrayList<RootCrop> listRoot = null;
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
                        rootCrop = new ManualInputRootCrop(scanner);
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
                        rootCrop = new FileInputRootCrop();
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
                        rootCrop = new RandomInputRootCrop();
                    }
                    break;

                default:
                    System.out.println("Неверный выбор");
                    continue;
            }


            //   Сортировка
            if (car != null) {
                listCar = mergeCar.sorting(listCar, car);
                if (listCar == null) {
                    continue;
                }
            }
            if (book != null) {
                listBook = mergeBook.sorting(listBook, book);
                if (listBook == null) {
                    continue;
                }
            }
            if (rootCrop != null) {
                listRoot = mergeVegetable.sorting(listRoot, rootCrop);
                if (listRoot == null) {
                    continue;
                }
            }

            // Бинарный поиск
            System.out.println("Хотите выполнить бинарный поиск? (1 - Да, 2 - Нет):");
            int searchChoice = scanner.nextInt();
            if (searchChoice == 1) {
                if (listCar != null) {
                    carBinarySearch.binSearch(listCar, scanner);
                }
                if (listBook != null) {
                    bookBinarySearch.binSearch(listBook, scanner);
                }
                if (listRoot != null) {
                    rootVegetableBinarySearch.binSearch(listRoot, scanner);
                }
            }

            System.out.println("Хотите выйти? (1 - Да, 2 - Нет):");
            int exitChoice = scanner.nextInt();
            if (exitChoice == 1) {
                System.out.println("The End.");
                break;
            }
        }
    }
}