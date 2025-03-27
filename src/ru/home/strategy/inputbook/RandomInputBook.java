package ru.home.strategy.inputbook;

import ru.home.model.Book;
import ru.home.strategy.interfaces.DataInputStrategy;
import ru.home.util.CustomArrayList;

import java.util.Random;

public class RandomInputBook implements DataInputStrategy<Book> {
    private Random random;

    public RandomInputBook() {
        this.random = new Random();
    }


    @Override
    public CustomArrayList<Book> inputData() {
        CustomArrayList<Book> list = new CustomArrayList<>();

        int count = random.nextInt(10) + 1;

        for (int i = 0; i < count; i++) {
            String[] authors = {"J.K. Rowling", "George Orwell", "J.R.R. Tolkien", "Agatha Christie", "Stephen King"};
            String author = authors[random.nextInt(authors.length)];

            String[] titles = {"The Great Gatsby", "1984", "The Hobbit", "Murder on the Orient Express", "The Shining"};
            String title = titles[random.nextInt(titles.length)];

            int pages = random.nextInt(901) + 100;

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