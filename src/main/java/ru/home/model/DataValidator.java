package main.java.ru.home.model;

public interface DataValidator<T> {
    boolean isValid(T data);
}