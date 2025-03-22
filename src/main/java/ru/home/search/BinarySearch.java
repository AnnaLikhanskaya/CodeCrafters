package main.java.ru.home.search;

import java.util.List;

public class BinarySearch<T extends Comparable<T>> {

    public int search(List<T> list, T target) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int comparisonResult = target.compareTo(list.get(mid));

            if (comparisonResult == 0) {
                return mid; // Element found
            } else if (comparisonResult < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1; // Element not found
    }
}