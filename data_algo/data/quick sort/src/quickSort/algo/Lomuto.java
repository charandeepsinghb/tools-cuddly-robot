package quickSort.algo;

import java.util.Arrays;

import quickSort.Util;

public class Lomuto {
    
    /**
     * Lomuto partition scheme
     * 
     * @param arr Array of Integers
     * @param lo Low
     * @param hi High
     */
    private static int partition(Integer[] arr, int lo, int hi) {
        
        // Last element is partition
        int p = arr[hi];

        int i = lo;

        for (int j = lo; j <= hi - 1; j++) {
            Util.devLog("Arr (dev): " + Arrays.asList(arr) + ", i: " + i + ", j: " + j + ", p: " + p);
            if (arr[j] <= p) {
                Util.swap(arr, i, j);
                i++;
            }
        }

        Util.swap(arr, i, hi);
        return i;
    }

    /**
     * Lomuto partition scheme with little tweak 2
     * 
     * @param arr Array of Integers
     * @param lo Low
     * @param hi High
     */
    private static int quickSortTweakPartition(Integer[] arr, int lo, int hi) {
        
        // Last element is partition
        int p = arr[hi];

        int i = lo - 1;

        for (int j = lo; j <= hi - 1; j++) {
            Util.devLog("Arr (dev): " + Arrays.asList(arr));
            if (arr[j] <= p) {
                i++;
                Util.swap(arr, i, j);
            }
        }

        Util.swap(arr, i + 1, hi);
        return i + 1;
    }

    /**
     * Recursively called quick sort
     * 
     * @param arr Array of Integers
     * @param lo Low
     * @param hi High
     */
    protected static void quickSort(Integer[] arr, int lo, int hi) {
        
        // Smallest sub
        if (lo >= hi || lo < 0) {
            return;
        }

        int splitPoint = partition(arr, lo, hi);

        quickSort(arr, lo, splitPoint - 1);
        quickSort(arr, splitPoint + 1, hi);
    }
}