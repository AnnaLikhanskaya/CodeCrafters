package ru.home.strategy.interfaces;

import ru.home.util.CustomArrayList;

public interface DataInputStrategy<T> {
    CustomArrayList<T> inputData();
}