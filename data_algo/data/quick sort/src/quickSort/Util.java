package quickSort;

public class Util {
    
    /**
     * Log information for dev level
     * 
     * @param str Print message
     */
    public static void devLog(String str) {
        System.out.println(str);
    }

    /**
     * Log information for info level
     * 
     * @param str Print message
     */
    public static void infoLog(String str) {
        System.out.println(str);
    }

    /**
     * Swap variables in array of Integers
     * 
     * @param arr Array of Integers
     * @param a First position
     * @param b Second position
     */
    public static void swap(Integer[] arr, int a, int b) {
        int t = arr[b];
        arr[b] = arr[a];
        arr[a] = t;
    }
}
