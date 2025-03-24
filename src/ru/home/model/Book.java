package ru.home.model;

import java.util.Objects;

public class Book implements Comparable<Book> {
    private String author;
    private String title;
    private int pages;

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
        return Integer.compare(this.pages, other.pages);
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", pages=" + pages +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return pages == book.pages && Objects.equals(author, book.author) && Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title, pages);
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getPages() {
        return pages;
    }
}