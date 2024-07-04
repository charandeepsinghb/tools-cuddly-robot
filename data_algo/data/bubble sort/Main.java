import java.util.Arrays;

class Main {

    private static void bubbleSort(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    Integer k = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = k;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {3, 8, 9, 4, 3, 2, 1, 5, 9};

        System.out.println("Arr: " + Arrays.asList(arr));
        bubbleSort(arr);
        System.out.println("Arr: " + Arrays.asList(arr));
    }
}
