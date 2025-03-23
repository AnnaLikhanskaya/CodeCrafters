package main.java.ru.home.model;

import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.title;
import static main.java.ru.home.model.Book.Builder.author;

public class BookValidator {
    public static boolean isValid(Book book) {

        if (!isValidAuthor(book.getAuthor())) {
        System.out.println("Имя автора не может быть пустым");
        return false;
    }
    if (!isValidTitle(book.getTitle())) {
        System.out.println("Название книги не может быть пустым");
        return false;
    }
    if (!isValidPages(book.getPages())) {
        System.out.println("Число страниц должно быть больше 0");
        return false;
    }
    return true;
}

    private static boolean isValidAuthor(String author) {
        return author != null && !author.isEmpty();

    }

    private static boolean isValidTitle(String title) {
        return title != null && !title.isEmpty();
    }
    private static boolean isValidPages(int pages) {
        return pages > 0;
    }
    }
