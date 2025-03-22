package main.java.ru.home;

import main.java.ru.home.data.*;
import main.java.ru.home.sort.MergeSort;
import main.java.ru.home.search.BinarySearch;
import main.java.ru.home.collection.CustomArrayList;
import main.java.ru.home.file.FileHandler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Main {

    private static final Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileHandler fileHandler = new FileHandler();

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Sort Cars");
            System.out.println("2. Sort Books");
            System.out.println("3. Sort RootCrops");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    processSorting(scanner, fileHandler, Car.class, new CarValidator());
                    break;
                case 2:
                    processSorting(scanner, fileHandler, Book.class, new BookValidator());
                    break;
                case 3:
                    processSorting(scanner, fileHandler, RootCrop.class, new RootCropValidator());
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static <T extends Comparable<T>> void processSorting(Scanner scanner, FileHandler fileHandler, Class<T> clazz, DataValidator<T> validator) {
        System.out.println("Enter list size:");
        int size = scanner.nextInt();
        scanner.nextLine();

        CustomArrayList<T> data = new CustomArrayList<>();

        System.out.println("Choose input method:");
        System.out.println("1. From file");
        System.out.println("2. Random");
        System.out.println("3. Manual");

        int inputChoice = scanner.nextInt();
        scanner.nextLine();

        switch (inputChoice) {
            case 1:
                System.out.println("Enter file path:");
                String filePath = scanner.nextLine();
                List<T> fileData = fileHandler.readFromFile(filePath, clazz); // Implement reading
                if (fileData != null) {
                    for (T item : fileData) {
                        if (validator.isValid(item)) {
                            data.add(item);
                        } else {
                            System.out.println("Invalid data in file, skipping: " + item);
                        }
                    }
                }
                break;
            case 2:
                data = generateRandomData(size, clazz);
                break;
            case 3:
                data = getManualData(size, clazz, scanner);
                break;
            default:
                System.out.println("Invalid input choice.");
                return;
        }

        //Sort
        MergeSort<T> mergeSort = new MergeSort<>();
        mergeSort.sort(convertCustomListToArrayList(data));

        //Search
        System.out.println("Enter element to search for:");
        T target = createTargetElement(scanner, clazz);
        BinarySearch<T> binarySearch = new BinarySearch<>();
        int index = binarySearch.search(convertCustomListToArrayList(data), target);

        if(index != -1){
            System.out.println("Found at index:" + index);
        } else {
            System.out.println("Not Found");
        }

        //Write
        System.out.println("Enter file path to write to:");
        String writePath = scanner.nextLine();
        System.out.println("Append [true/false]");
        boolean append = scanner.nextBoolean();

        fileHandler.writeToFile(writePath, convertCustomListToArrayList(data), append);

        System.out.println("Operation Complete");
    }

    private static <T extends Comparable<T>> CustomArrayList<T> generateRandomData(int size, Class<T> clazz) {
        CustomArrayList<T> data = new CustomArrayList<>();
        if (clazz == Car.class) {
            for (int i = 0; i < size; i++) {
                int power = random.nextInt(300) + 50; // Мощность от 50 до 350
                String model = "Model-" + random.nextInt(100); // Случайная модель
                int year = random.nextInt(50) + 1970; // Год от 1970 до 2019
                Car car = new Car.CarBuilder().power(power).model(model).productionYear(year).build();
                data.add((T) car);
            }
        } else if (clazz == Book.class) {
            for (int i = 0; i < size; i++) {
                String author = "Author-" + random.nextInt(50);
                String title = "Title-" + random.nextInt(100);
                int pageCount = random.nextInt(500) + 50; // Страницы от 50 до 550
                Book book = new Book.BookBuilder().author(author).title(title).pageCount(pageCount).build();
                data.add((T) book);
            }
        } else if (clazz == RootCrop.class) {
            for (int i = 0; i < size; i++) {
                String type = "Type-" + random.nextInt(10);
                int weight = random.nextInt(500) + 100; // Вес от 100 до 600
                String color = "Color-" + random.nextInt(20);
                RootCrop crop = new RootCrop.RootCropBuilder().type(type).weight(weight).color(color).build();
                data.add((T) crop);
            }
        }
        return data;
    }

    private static <T extends Comparable<T>> CustomArrayList<T> getManualData(int size, Class<T> clazz, Scanner scanner) {
        CustomArrayList<T> data = new CustomArrayList<>();
        if (clazz == Car.class) {
            for (int i = 0; i < size; i++) {
                System.out.println("Car:" + i);
                System.out.println("Power:");
                int power = Integer.parseInt(scanner.nextLine());
                System.out.println("Model:");
                String model = scanner.nextLine();
                System.out.println("ProductionYear:");
                int year = Integer.parseInt(scanner.nextLine());

                Car car = new Car.CarBuilder().power(power).model(model).productionYear(year).build();
                CarValidator validator = new CarValidator();
                if (validator.isValid(car)){
                    data.add((T) car);
                } else {
                    System.out.println("NOT Valid, skipped");
                }

            }

        }
        if (clazz == Book.class) {
            for (int i = 0; i < size; i++) {
                System.out.println("Book:" + i);
                System.out.println("Author:");
                String author = scanner.nextLine();
                System.out.println("Model:");
                String title = scanner.nextLine();
                System.out.println("Page Count:");
                int pageCount = Integer.parseInt(scanner.nextLine());

                Book book = new Book.BookBuilder().author(author).title(title).pageCount(pageCount).build();
                BookValidator validator = new BookValidator();
                if (validator.isValid(book)){
                    data.add((T) book);
                } else {
                    System.out.println("NOT Valid, skipped");
                }

            }

        }
        if (clazz == RootCrop.class) {
            for (int i = 0; i < size; i++) {
                System.out.println("RootCrop:" + i);
                System.out.println("Type:");
                String type = scanner.nextLine();
                System.out.println("Weight:");
                int weight = Integer.parseInt(scanner.nextLine());
                System.out.println("Color:");
                String color = scanner.nextLine();

                RootCrop crop = new RootCrop.RootCropBuilder().type(type).weight(weight).color(color).build();
                RootCropValidator validator = new RootCropValidator();
                if (validator.isValid(crop)){
                    data.add((T) crop);
                } else {
                    System.out.println("NOT Valid, skipped");
                }

            }

        }
        return data;
    }

    private static <T extends Comparable<T>> T createTargetElement(Scanner scanner, Class<T> clazz) {
        if (clazz == Car.class) {
            System.out.println("Enter Car details for search:");
            System.out.println("Power:");
            int power = Integer.parseInt(scanner.nextLine());
            System.out.println("Model:");
            String model = scanner.nextLine();
            System.out.println("Production Year:");
            int year = Integer.parseInt(scanner.nextLine());
            return (T) new Car.CarBuilder().power(power).model(model).productionYear(year).build();
        } else if (clazz == Book.class) {
            System.out.println("Enter Book details for search:");
            System.out.println("Author:");
            String author = scanner.nextLine();
            System.out.println("Title:");
            String title = scanner.nextLine();
            System.out.println("Page Count:");
            int pageCount = Integer.parseInt(scanner.nextLine());
            return (T) new Book.BookBuilder().author(author).title(title).pageCount(pageCount).build();
        } else if (clazz == RootCrop.class) {
            System.out.println("Enter RootCrop details for search:");
            System.out.println("Type:");
            String type = scanner.nextLine();
            System.out.println("Weight:");
            int weight = Integer.parseInt(scanner.nextLine());
            System.out.println("Color:");
            String color = scanner.nextLine();
            return (T) new RootCrop.RootCropBuilder().type(type).weight(weight).color(color).build();
        } else {
            System.out.println("Unsupported class for manual data input.");
            return null;
        }
    }

    private static <T> List<T> convertCustomListToArrayList(CustomArrayList<T> customList) {
        List<T> arrayList = new ArrayList<>();
        for (int i = 0; i < customList.size(); i++) {
            arrayList.add(customList.get(i));
        }
        return arrayList;
    }
}