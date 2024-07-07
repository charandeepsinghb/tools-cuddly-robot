package quickSort.algo;

public class Hoare {

    /**
     * Partition function for Hoare
     * 
     * @param arr Array of Integer
     * @param lo Low
     * @param hi High
     */
    private static int partition(Integer[] arr, int lo, int hi) {
        return 0;
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
        if (lo < 0 || hi < 0 || lo >= hi) {
            return;
        }

        int splitPoint = partition(arr, lo, hi);

        quickSort(arr, lo, splitPoint);
        quickSort(arr, splitPoint + 1, hi);
    }
}
