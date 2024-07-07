package quickSort.algo;

import java.util.Arrays;

import quickSort.Util;

public class Hoare {

    /**
     * Partition function for Hoare
     * 
     * @param arr Array of Integer
     * @param lo Low
     * @param hi High
     */
    private static int partition(Integer[] arr, int lo, int hi) {
        int p = arr[lo];

        int i = lo - 1;
        int j = hi;

        while (true) {
            Util.devLog("Arr (dev): " + Arrays.asList(arr) + ", i: " + i + ", j: " + j + ", p: " + p);
            do {
                i = i + 1;
            } while (arr[i] < p);
            do {
                j = j - 1;
            } while (arr[j] > p);
            if (i >= j) {
                return j;
            }
            Util.swap(arr, i, j);
        }
    }
    
    /**
     * Recursively called quick sort
     * 
     * @param arr Array of Integers
     * @param lo Low
     * @param hi High
     */
    protected static void sort(Integer[] arr, int lo, int hi) {
        
        // Smallest sub
        if (lo < 0 || hi < 0 || lo >= hi) {
            return;
        }

        int splitPoint = partition(arr, lo, hi);

        sort(arr, lo, splitPoint);
        sort(arr, splitPoint + 1, hi);
    }
}
