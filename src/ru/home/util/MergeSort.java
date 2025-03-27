package ru.home.util;


import ru.home.strategy.interfaces.DataInputStrategy;

import java.util.Scanner;

public class MergeSort<T extends Comparable<T>> {

    public <T extends Comparable<T>> CustomArrayList<T> sorting(CustomArrayList<T> list, DataInputStrategy<T> obj) {


        list = obj.inputData();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введенный список: " + list);
        System.out.println("Хотите выполнить сортировку? (1 - Да, 2 - Нет):");
        int sort = scanner.nextInt();
        scanner.nextLine();
        if (sort == 1) {
            MergeSort<T> sorter = new MergeSort<>();
            sorter.sort(list);
            System.out.println("Отсортированный список: " + list);
        } else {
            return null;
        }
        return list;
    }

    public void sort(CustomArrayList<T> list) {
        if (list.size() > 1) {
            CustomArrayList<T> left = new CustomArrayList<>();
            CustomArrayList<T> right = new CustomArrayList<>();
            int middle = list.size() / 2;

            for (int i = 0; i < middle; i++) {
                left.add(list.get(i));
            }

            for (int i = middle; i < list.size(); i++) {
                right.add(list.get(i));
            }
            sort(left);
            sort(right);
            merge(list, left, right);
        }
    }

    private void merge(CustomArrayList<T> list, CustomArrayList<T> left, CustomArrayList<T> right) {
        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).compareTo(right.get(j)) <= 0) {
                list.set(k++, left.get(i++));
            } else {
                list.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) {
            list.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            list.set(k++, right.get(j++));
        }
    }
}