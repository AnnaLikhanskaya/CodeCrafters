package ru.home.strategy.inputbook;
package main.java.ru.home.utill.strategy.inputbook;

import main.java.ru.home.utill.CustomArrayList;
import main.java.ru.home.utill.model.Book;
import main.java.ru.home.utill.model.Car;
import main.java.ru.home.utill.strategy.DataValidator;
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
//        scanner.nextLine();

        for (int i = 0; i < count; i++) {
            Book book = new Book.Builder().build().createFromInput(scanner);
            String author = book.getAuthor();
            String title = book.getTitle();
            int pages = book.getPages();

            if (DataValidator.validateBookData(author, title, pages)) {
                list.add(book);
            } else {
                System.out.println("Некорректные данные. Повторите ввод.");
                i--;
            }
        }
//        scanner.close();
        return list;
    }
}