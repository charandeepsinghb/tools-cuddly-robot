package quickSort.algo;

public class QuickSort {

    /**
     * Quick Sort Algorithm
     * 
     * @param arr Array of Integers
     */
    public static void quickSort(Integer[] arr) {

        // Main calling function
        // Lomuto.quickSort(arr, 0, arr.length - 1);
        Hoare.sort(arr, 0, arr.length - 1);
    }
}
