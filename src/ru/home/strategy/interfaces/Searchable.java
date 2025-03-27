package ru.home.strategy.interfaces;

import java.util.Scanner;

public interface Searchable<T> {
    T createFromInput(Scanner scanner);
}