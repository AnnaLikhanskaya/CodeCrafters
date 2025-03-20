package ru.home;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать в приложение сортировки!");

        while (true) {
            System.out.println("Выберите тип объектов:");
            System.out.println("1. Автомобили");
            System.out.println("2. Книги");
            System.out.println("3. Корнеплоды");
            System.out.println("4. Выход");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    handleCarMenu(scanner);
                    break;
                case 2:
                    handleBookMenu(scanner);
                    break;
                case 3:
                    handleRootVegetableMenu(scanner);
                    break;
                case 4:
                    System.out.println("Выход из программы. До свидания!");
                    return;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
            }
        }
    }

    private static void handleCarMenu(Scanner scanner) {
        while (true) {
            System.out.println("Выберите действие для автомобилей:");
            System.out.println("1. Заполнить массив из файла");
            System.out.println("2. Заполнить массив случайными данными");
            System.out.println("3. Заполнить массив вручную");
            System.out.println("4. Бинарный поиск");
            System.out.println("5. Вернуться в главное меню");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Пожалуйста подождите... Идет заполнение массива автомобилей из файла...");
                    // fillFromFile(); скорее всего будет : FileService.fillFromFile
                    break;
                case 2:
                    System.out.println("Пожалуйста подождите... Идет заполнение массива автомобилей случайными данными...");
                    // fillRandom(); скорее всего будет : RandomService
                    break;
                case 3:
                    System.out.println("Пожалуйста подождите... Идет заполнение массива автомобилей вручную...");
                    // fillManually(); скорее всего будет : ManuallyService
                    break;
                case 4:
                    System.out.println("Пожалуйста подождите... Идет выполнение бинарного поиска в массиве автомобилей...");
                    // binarySearch();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
            }
        }
    }

    private static void handleBookMenu(Scanner scanner) {
        while (true) {
            System.out.println("Выберите действие для книг:");
            System.out.println("1. Заполнить массив из файла");
            System.out.println("2. Заполнить массив случайными данными");
            System.out.println("3. Заполнить массив вручную");
            System.out.println("4. Бинарный поиск");
            System.out.println("5. Вернуться в главное меню");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Пожалуйста подождите... Идет заполнение массива книг из файла...");
                    // fillFromFile();
                    break;
                case 2:
                    System.out.println("Пожалуйста подождите... Идет заполнение массива книг случайными данными...");
                    // fillRandom();
                    break;
                case 3:
                    System.out.println("Пожалуйста подождите... Идет заполнение массива книг вручную...");
                    // fillManually();
                    break;
                case 4:
                    System.out.println("Пожалуйста подождите... Идет выполнение бинарного поиска в массиве книг...");
                    // binarySearch();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
            }
        }
    }

    private static void handleRootVegetableMenu(Scanner scanner) {
        while (true) {
            System.out.println("Выберите действие для корнеплодов:");
            System.out.println("1. Заполнить массив из файла");
            System.out.println("2. Заполнить массив случайными данными");
            System.out.println("3. Заполнить массив вручную");
            System.out.println("4. Бинарный поиск");
            System.out.println("5. Вернуться в главное меню");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Пожалуйста подождите... Идет заполнение массива корнеплодов из файла...");
                    // fillFromFile();
                    break;
                case 2:
                    System.out.println("Пожалуйста подождите... Идет заполнение массива корнеплодов случайными данными...");
                    // fillRandom();
                    break;
                case 3:
                    System.out.println("Пожалуйста подождите... Идет заполнение массива корнеплодов вручную...");
                    // fillManually();
                    break;
                case 4:
                    System.out.println("Пожалуйста подождите... Идет выполнение бинарного поиска в массиве корнеплодов...");
                    // binarySearch();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
            }
        }
    }
}
