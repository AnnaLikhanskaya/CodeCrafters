package main.java.ru.home.utill.strategy.inputbook;

import main.java.ru.home.utill.CustomArrayList;
import main.java.ru.home.utill.model.Book;
import main.java.ru.home.utill.strategy.interfaces.DataInputStrategy;

import java.util.Scanner;

public class ManualInputBook implements DataInputStrategy<Book> {
    private final Scanner scanner;

    public ManualInputBook(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public CustomArrayList<Book> inputData() {
        CustomArrayList<Book> list = new CustomArrayList<>();
        System.out.println("Введите количество книг:");
        int count = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < count; i++) {
            System.out.println("Введите автора:");
            String author = scanner.nextLine();

            System.out.println("Введите название:");
            String title = scanner.nextLine();

            System.out.println("Введите количество страниц:");
            int pages = scanner.nextInt();
            scanner.nextLine();

            Book book = new Book.Builder()
                    .author(author)
                    .title(title)
                    .pages(pages)
                    .build();
            list.add(book);
        }

        return list;
    }
}