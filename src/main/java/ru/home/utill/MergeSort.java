package main.java.ru.home.utill;

public class MergeSort<T extends Comparable<T>> {

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