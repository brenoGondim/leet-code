import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {6, 10, 2, 7, 8, 9, 1, 3, 5};
        int n = arr.length;

        int[] sorted = quickSort(arr, 0, n - 1);

        System.out.println(Arrays.toString(sorted));
    }
    private static int[] quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partitionAndSort(arr, low, high);

            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
        return arr;
    }
    private static int partitionAndSort(int[] arr, int low, int high) {
        int i = low - 1;
        for(int j = low; j < high; j++) {
            if (arr[j] < arr[high]) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}