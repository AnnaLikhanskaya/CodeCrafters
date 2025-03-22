package main.java.ru.home.data;

public interface DataValidator<T> {
    boolean isValid(T data);
}