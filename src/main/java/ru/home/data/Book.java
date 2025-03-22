package main.java.ru.home.data;

public class Book implements Comparable<Book> {
    private final String author;
    private final String title;
    private final int pageCount;

    private Book(BookBuilder builder) {
        this.author = builder.author;
        this.title = builder.title;
        this.pageCount = builder.pageCount;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getPageCount() {
        return pageCount;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", pageCount=" + pageCount +
                '}';
    }

    @Override
    public int compareTo(Book other) {
        return Integer.compare(this.pageCount, other.pageCount);
    }

    public static class BookBuilder {
        private String author;
        private String title;
        private int pageCount;

        public BookBuilder author(String author) {
            this.author = author;
            return this;
        }

        public BookBuilder title(String title) {
            this.title = title;
            return this;
        }

        public BookBuilder pageCount(int pageCount) {
            this.pageCount = pageCount;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }
}