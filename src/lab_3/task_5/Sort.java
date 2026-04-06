package lab_3.task_5;

public class Sort {

    private Sort() {}

    public static <T extends Comparable<T>> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        if (arr == null || arr.length < 2) return;
        int n = arr.length;
        for (int pass = 0; pass < n - 1; pass++) {
            boolean swapped = false;
            for (int i = 0; i < n - 1 - pass; i++) {
                if (arr[i].compareTo(arr[i + 1]) > 0) {
                    swap(arr, i, i + 1);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
}