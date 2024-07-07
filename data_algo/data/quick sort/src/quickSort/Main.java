package quickSort;

import java.util.Arrays;

import quickSort.algo.QuickSort;

public class Main {

    public static void main(String[] args) {
        
        Integer[] arr = {3, 8, 9, 4, 3, 2, 1, 5, 9};

        Util.infoLog("Arr: " + Arrays.asList(arr));
        QuickSort.quickSort(arr);
        Util.infoLog("Arr: " + Arrays.asList(arr));
    }
}


/*
 * Run by:
 * 
 * javac -d .\target\ .\src\quicksort\Main.java .\src\quicksort\Util.java .\src\quicksort\algo\Lomuto.java .\src\quickSort\algo\QuickSort.java
 * 
 * inside target:
 * java quickSort.Main
 */