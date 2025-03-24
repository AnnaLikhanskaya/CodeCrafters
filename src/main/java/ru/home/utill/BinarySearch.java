package main.java.ru.home.utill;

import main.java.ru.home.utill.CustomArrayList;

import java.util.Scanner;

public class BinarySearch<T extends Comparable<T> & Searchable<T>> {

    public void binSearch(CustomArrayList<T> list, Scanner scanner) {
        if (list == null || list.size() == 0) {
            System.out.println("Список пуст. Поиск невозможен.");
            return;
        }

        T firstElement = list.get(0);
        if (firstElement == null) {
            System.out.println("Первый элемент списка равен null. Поиск невозможен.");
            return;
        }

        T findObject = firstElement.createFromInput(scanner);

        if (findObject != null) {
            int index = search(list, findObject);
            check(index, list);
        } else {
            System.out.println("Неверный тип данных для поиска.");
        }
    }

    private int search(CustomArrayList<T> list, T key) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            T midVal = list.get(mid);
            int cmp = midVal.compareTo(key);

            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private void check(int index, CustomArrayList<T> list) {
        if (index != -1) {
            System.out.println("Элемент найден на позиции: " + index + " - " + list.get(index).toString());
        } else {
            System.out.println("Элемент не найден");
        }
    }
}