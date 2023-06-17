package org.example.NumberFinder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberFinder {
    public static void main(String[] args) {
        Integer[][] numbers = {{1000, 6, 3}, {9, 100, 6}, {71, 8, 119}};
        System.out.println(lowestNumberFinder(numbers).getLowestNumber());
    }

    public static <T extends Comparable<T>> SortedNumbers<T> lowestNumberFinder(T[][] numbers) {

        if (numbers == null || numbers.length == 0 || numbers[0].length == 0) {
            throw new RuntimeException("Array is empty");
        }

        List<SortedNumbers<T>> result = new ArrayList<>();
        for (T[] array : numbers) {
            quickSort(array);
            SortedNumbers<T> sortedNumbers = new SortedNumbers<>();
            sortedNumbers.setLowestNumber(array[0]);
            sortedNumbers.setSortedNumbers(Arrays.asList(array));
            result.add(sortedNumbers);
        }

        SortedNumbers<T> lowestNumber = result.get(0);
        for (SortedNumbers<T> sortedNumbers : result) {
            if (sortedNumbers.getLowestNumber().compareTo(lowestNumber.getLowestNumber()) < 0) {
                lowestNumber = sortedNumbers;
            }
        }
        return lowestNumber;
    }

    private static <T extends Comparable<T>> void quickSort(T[] array) {
        recursiveQuickSort(array, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> void recursiveQuickSort(T[] array, int startIndex, int endIndex) {
        int index = partition(array, startIndex, endIndex);

        if (startIndex < index - 1) {
            recursiveQuickSort(array, startIndex, index - 1);
        }

        if (endIndex > index) {
            recursiveQuickSort(array, index, endIndex);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] array, int left, int right) {
        T pivot = array[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, right);
        return i + 1;
    }

    private static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static final class SortedNumbers<T> {

        private T lowestNumber;
        private List<T> sortedNumbers;

        public T getLowestNumber() {
            return lowestNumber;
        }

        public void setLowestNumber(T lowestNumber) {
            this.lowestNumber = lowestNumber;
        }

        public List<T> getSortedNumbers() {
            return sortedNumbers;
        }

        public void setSortedNumbers(List<T> sortedNumbers) {
            this.sortedNumbers = sortedNumbers;
        }
    }
}
