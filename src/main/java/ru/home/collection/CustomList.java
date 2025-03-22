package main.java.ru.home.collection;

public interface CustomList<T> {
    void add(T element);
    T get(int index);
    void set(int index, T element);
    int size();
    boolean isEmpty();
    void remove(int index);
}