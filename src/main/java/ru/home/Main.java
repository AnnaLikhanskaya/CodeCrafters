package java.ru.home;

import java.awt.print.Book;
import java.ru.home.input.DataInputStrategy;
import java.ru.home.model.Car;
import java.ru.home.model.RootCrop;
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
            DataInputStrategy<RootCrop> rootVegetable = null;
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
                    Book bookFind = new Book.Builder().author("Lev").title("War and peace").pages(500).build();
                    int index = binarySearch.search(listBook, bookFind);
                    check(index);
                }
                if (listRoot != null) {
                    BinarySearch<RootCrop> binarySearch = new BinarySearch<>();
                    RootCrop rootFind = new RootCrop.Builder().type("Carrot").weight(2).color("orange").build();
                    int index = binarySearch.search(listRoot, rootFind);
                    check(index);
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