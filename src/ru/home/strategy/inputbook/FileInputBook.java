package ru.home.strategy.inputbook;

package main.java.ru.home.utill.strategy.inputbook;

import main.java.ru.home.utill.CustomArrayList;
import main.java.ru.home.utill.model.Book;
import main.java.ru.home.utill.strategy.interfaces.DataInputStrategy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class FileInputBook implements DataInputStrategy<Book> {
    private String filePath;

    public FileInputBook(){
        this.filePath = "C:\\CodeCrafters\\book.txt";
    }

    @Override
    public CustomArrayList<Book> inputData() {
        CustomArrayList<Book> list = new CustomArrayList<>();
        File file = new File(filePath);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String author = scanner.nextLine().trim();
                String title = scanner.nextLine().trim();
                int pages = Integer.parseInt(scanner.nextLine().trim());

                Book book = new Book.Builder()
                        .author(author)
                        .title(title)
                        .pages(pages)
                        .build();

                list.add(book);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + filePath);
            e.printStackTrace();
        }

        return list;
    }
}