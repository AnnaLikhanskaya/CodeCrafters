package ru.home.util;

import ru.home.model.Book;

public class BookValidator {
    public static boolean validate(Book book) {
        return book.getPages() > 0 && book.getAuthor() != null && !book.getAuthor()
                .isEmpty() && book.getTitle() != null && !book.getTitle().isEmpty();
    }
}