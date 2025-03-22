package main.java.ru.home.utill.strategy.interfaces;

import main.java.ru.home.utill.CustomArrayList;

public interface DataInputStrategy<T> {
    CustomArrayList<T> inputData();
}