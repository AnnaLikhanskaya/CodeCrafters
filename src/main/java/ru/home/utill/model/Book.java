package main.java.ru.home.utill.model;

// Класс Книга
public class Book implements Comparable<Book> {
    private String author; // Автор
    private String title; // Название
    private int pages; // Количество страниц

    private Book(Builder builder) {
        this.author = builder.author;
        this.title = builder.title;
        this.pages = builder.pages;
    }

    public static class Builder {
        private String author;
        private String title;
        private int pages;

        public Builder author(String author) {
            this.author = author;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder pages(int pages) {
            this.pages = pages;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }

    @Override
    public int compareTo(Book other) {
        if (!this.author.equals(other.author)) return this.author.compareTo(other.author);
        if (!this.title.equals(other.title)) return this.title.compareTo(other.title);
        return Integer.compare(this.pages, other.pages);
    }

    @Override
    public String toString() {
        return "Book{author='" + author + "', title='" + title + "', pages=" + pages + "}";
    }
}