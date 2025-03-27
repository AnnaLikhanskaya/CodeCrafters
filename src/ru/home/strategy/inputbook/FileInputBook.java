package ru.home.strategy.inputbook;

import ru.home.model.Book;
import ru.home.strategy.interfaces.DataInputStrategy;
import ru.home.util.CustomArrayList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class FileInputBook implements DataInputStrategy<Book> {
    private String filePath;

    public FileInputBook() {
        this.filePath = "C:\\Users\\andre\\IdeaProjects\\CodeCrafters\\src\\book.txt";
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