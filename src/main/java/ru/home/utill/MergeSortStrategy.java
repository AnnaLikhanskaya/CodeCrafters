package main.java.ru.home.utill;

public class MergeSortStrategy<T extends Comparable<T>> implements SortStrategy<T> {
    private MergeSort<T> mergeSort = new MergeSort<>();

    @Override
    public void sort(CustomArrayList<T> list) {
        mergeSort.sort(list);
    }

}