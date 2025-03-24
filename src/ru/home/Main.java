package ru.home;

import ru.home.input.DataInputStrategy;
import ru.home.model.Book;
import ru.home.model.Car;
import ru.home.model.RootCrop;

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


            //   Сортировка
            if (car != null) {
                listCar = sorting(listCar, car, scanner);
            }
            if (book != null) {
                listBook = sorting(listBook, book, scanner);
            }
            if (rootVegetable != null) {
                listRoot = sorting(listRoot, rootVegetable, scanner);
            }

            // Бинарный поиск
            System.out.println("Хотите выполнить бинарный поиск? (1 - Да, 2 - Нет):");
            int searchChoice = scanner.nextInt();
            if (searchChoice == 1) {
                if (listCar != null) {
                    binarySearch(listCar, scanner);
                }
                if (listBook != null) {
                    binarySearch(listBook, scanner);
                }
                if (listRoot != null) {
                    binarySearch(listRoot, scanner);
                }
            }


            System.out.println("Хотите выйти? (1 - Да, 2 - Нет):");
            int exitChoice = scanner.nextInt();
            if (exitChoice == 1) {
                scanner.close();
                System.out.println("The End.");
                break;
            }
        }
    }

    private static <T extends Comparable<T>> void check(int index, CustomArrayList<T> list) {
        if (index != -1) {
            System.out.println("Элемент найден на позиции: " + index + " - " + list.get(index).toString());
        } else {
            System.out.println("Элемент не найден");
        }
    }

    public static <T extends Comparable<T>> CustomArrayList<T> sorting(CustomArrayList<T> list, DataInputStrategy<T> car, Scanner scanner) {
        list = car.inputData();
        System.out.println("Введенный список: " + list);
        System.out.println("Хотите выполнить сортировку? (1 - Да, 2 - Нет):");
        int sort = scanner.nextInt();
        scanner.nextLine();
        if (sort == 1) {
            MergeSort<T> sorter = new MergeSort<>();
            sorter.sort(list);
            System.out.println("Отсортированный список: " + list);
        } else if (sort != 2) {
            System.out.println("Неверный ввод. Сортировка не выполнена.");
        }
        return list;
    }

    public static <T extends Comparable<T> & Searchable<T>> void binarySearch(CustomArrayList<T> list, Scanner scanner) {
        if (list == null || list.size() == 0) {
            System.out.println("Список пуст. Поиск невозможен.");
            return;
        }

        T findObject = list.get(0).createFromInput(scanner);

        if (findObject != null) {
            BinarySearch<T> binarySearch = new BinarySearch<>();
            int index = binarySearch.search(list, findObject);
            check(index, list);
        } else {
            System.out.println("Неверный тип данных для поиска.");
        }
    }

}