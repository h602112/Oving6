import java.util.Random;

public class SortedArray {
    public static void main(String[] args) {
        Random random = new Random();
        int n = 55000;
        int number = 10;

        Integer[] a = new Integer[n];

        for (int i = 0; i < n; i++) {
            a[i] = random.nextInt();
        }


        long start = System.currentTimeMillis();
        for (int i = 0; i < number; i++) {
            insertionSort(a, n);
        }
        long end = System.currentTimeMillis();
        long timeElapsed = end-start;
        System.out.println(timeElapsed);

    }
    public static <T extends Comparable<? super T>> void insertionSort(T[] a, int n) {
        insertionSort(a, 0, n-1);
    }

    public static <T extends Comparable<? super T>> void insertionSort(T[] a, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            T temp = a[i];
            int j = i-1;
            boolean done = false;
            while (!done && j >= 0) {
                if (temp.compareTo(a[j]) < 0) {
                    a[j + 1] = a[j];
                    j--;
                } else {
                    done = true;
                }
            }
            a[j+1] = temp;
        }
    }

}


