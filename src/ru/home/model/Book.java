package ru.home.model;

import ru.home.strategy.interfaces.Searchable;

import java.util.Scanner;

public class Book implements Comparable<Book>, Searchable<Book> {
    private String author; // Автор
    private String title; // Название
    private int pages; // Количество страниц

    private Book(Builder builder) {
        this.author = builder.author;
        this.title = builder.title;
        this.pages = builder.pages;
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

    @Override
    public Book createFromInput(Scanner scanner) {
        String author;
        while (true) {
            System.out.println("Введите автора:");
            author = scanner.nextLine().trim();
            if (!author.isEmpty() && author.matches("[a-zA-Z\\s]+")) {
                break;
            } else {
                System.out.println("Автор должен содержать только буквы. Пожалуйста, введите автора.");
            }
        }

        String title;
        while (true) {
            System.out.println("Введите название:");
            title = scanner.nextLine().trim();
            if (!title.isEmpty() && title.matches("[a-zA-Z\\s]+")) {
                break;
            } else {
                System.out.println("Название должно содержать только буквы. Пожалуйста, введите название.");
            }
        }

        int pages;
        while (true) {
            System.out.println("Введите количество страниц:");
            while (!scanner.hasNextInt()) {
                System.out.println("Некорректный ввод. Введите число:");
                scanner.nextLine();
            }
            pages = scanner.nextInt();
            scanner.nextLine();
            if (pages > 0) {
                break;
            } else {
                System.out.println("Количество страниц должно быть положительным числом.");
            }
        }

        return new Book.Builder().author(author).title(title).pages(pages).build();
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