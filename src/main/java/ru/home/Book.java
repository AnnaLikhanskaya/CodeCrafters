package main.java.ru.home;

public class Book implements Comparable<Book> {
    private String author;
    private String title;
    private int pages;


    private Book(Builder builder){

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
    public String toString(){
        return author + title + pages;

    }

    public int compareTo(Book o) {
        return this.getPages() - o.getPages();
    }
    public static class Builder{
        private static String author;
        private static String title;
        private static int pages;

        public Builder setAuthor(String author) {
            this.author = author;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setPages(int pages) {
            this.pages = pages;
            return this;
        }
        public Book build() {
            return new Book(this);

        }
    }


}

