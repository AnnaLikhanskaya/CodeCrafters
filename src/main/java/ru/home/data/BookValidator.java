package main.java.ru.home.data;

public class BookValidator implements DataValidator<Book> {
    @Override
    public boolean isValid(Book book) {
        return book.getAuthor() != null && !book.getAuthor().isEmpty() &&
                book.getTitle() != null && !book.getTitle().isEmpty() &&
                book.getPageCount() > 0;
    }
}