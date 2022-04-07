import java.util.Random;
import java.util.Formatter;
import java.text.DecimalFormat;

public class SortedArray {
    public static void main(String[] args) {
//        Random random = new Random();
//        int n = 10;
//        int number = 1;
//
//        Integer[] a = new Integer[n];
//
//        for (int i = 0; i < n; i++) {
//            a[i] = random.nextInt();
//        }
//
//        //long startTwo = System.currentTimeMillis();
//        //for (int i = 0; i < number; i++) {
//          //  insertionSortTwoNumbers(a, n);
//        //}
//        //long endTwo = System.currentTimeMillis();
//        //long timeElapsedTwo = endTwo - startTwo;
//        //System.out.println(timeElapsedTwo);
//
//        long start = System.currentTimeMillis();
//        for (int i = 0; i < number; i++) {
//            insertionSort(a, n);
//        }
//        long end = System.currentTimeMillis();
//        long timeElapsed = end - start;
//        System.out.println(timeElapsed);
//        for (Integer i: a) {
//            System.out.println(i);
//        }
//
//        long quickSortStart = System.currentTimeMillis();
//        for (int i = 0; i < number; i++) {
//            quickSort(a, n);
//        }
//        long quickSortEnd = System.currentTimeMillis();
//        long quickSortElapsed = quickSortEnd-quickSortStart;
//        System.out.println(quickSortElapsed);
    	
    	// Making sure the sorting methods gives the correct output
//    	Integer[] a = {5, 6, 1, 8, 4, 2, 7, 3, 0, 9};
//    	int n = 10;
//    	for(int i = 0; i < n; i++) {
//    		System.out.print(a[i] + " ");
//    	}
//    	System.out.println("\n");
//    	selectionSort(a, n);
//    	System.out.println("SelectionSort: ");
//    	for(int i = 0; i < n; i++) {
//    		System.out.print(a[i] + " ");
//    	}
//    	System.out.println("\n");
//    	quickSort(a, n);
//    	System.out.println("QuickSort: ");
//    	for(int i = 0; i < n; i++) {
//    		System.out.print(a[i] + " ");
//    	}
//    	System.out.println("\n");
//    	insertionSort(a, n);
//    	System.out.println("InsertionSort: ");
//    	for(int i = 0; i < n; i++) {
//    		System.out.print(a[i] + " ");
//    	}
//    	System.out.println("\n");
//    	mergeSort(a, n);
//    	System.out.println("MergeSort: ");
//    	for(int i = 0; i < n; i++) {
//    		System.out.print(a[i] + " ");
//    	}
    	
//    	int n = 8;
//    	Integer[] a = populateArrayWithRandomNumbers(n);
//    	for(int i = 0; i < n; i++) {
//    		System.out.print(a[i] + " ");
//    	}
//    	System.out.println("\n");
//    	quickSort(a, n);
//    	for (int i = 0; i < n; i++) {
//    		System.out.print(a[i] + " ");
//    	} 
    	
    	measureTimeForSorting();

    }

    public static void measureTimeForSorting() {
    	Formatter frmt = new Formatter();
    	DecimalFormat dmf = new DecimalFormat("####.##");
    	double avgTime = 0;
    	int numMeasurements = 10;
    	frmt.format("%13s %18s %22s %15s\n", "n", "Antall målinger", "Målt tid (gj.snitt)", "Teoretisk tid");
    	for (int i = 32000; i <= 128000; i = i * 2) {
    		Integer[] list = populateArrayWithRandomNumbers(i);
    		for (int j = 0; j < numMeasurements; j++) {
    			long start = System.nanoTime();
    			insertionSort(list, 10);		// swap the methodcall with the desired sorting method
    			long stop = System.nanoTime();
    			double elapsedTime = (double)((stop - start));
    			avgTime += elapsedTime;
    		}
    		avgTime /= 5;
    		frmt.format("%15s %11s %22s %15s\n", i, numMeasurements, dmf.format(avgTime) + " ns", "");
    	}
    	System.out.println(frmt);
    }

    public static Integer[] populateArrayWithRandomNumbers(int n) {
    	Random random = new Random();
    	Integer[] arr = new Integer[n];
    	for (int i = 0; i < n; i++) {
    		Integer number = random.nextInt(50);
    		arr[i] = number;
    	}
    	return arr;
    }

    public static <T extends Comparable<? super T>> void insertionSort(T[] a, int n) {
        insertionSort(a, 0, n - 1);
    }

    public static <T extends Comparable<? super T>> void insertionSort(T[] a, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            T temp = a[i];
            int j = i - 1;
            boolean done = false;
            while (!done && j >= 0) {
                if (temp.compareTo(a[j]) < 0) {
                    a[j + 1] = a[j];
                    j--;
                } else {
                    done = true;
                }
            }
            a[j + 1] = temp;
        }
    }

    public static <T extends Comparable<? super T>> void insertionSortTwoNumbers(T[] a, int n) {
        insertionSortTwoNumbers(a, 0, n - 1);
    }

    public static <T extends Comparable<? super T>> void insertionSortTwoNumbers(T[] a, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            T temp = a[i];
            int j = i - 1;
            boolean done = false;
            while (!done && j <= 0) {
                if (temp.compareTo(a[end]) > 0) {
                    a[j + 3] = temp;
                }
                if (temp.compareTo(a[j]) < 0) {
                    a[j + 1] = a[j];
                    j--;
                } else {
                    done = true;
                }
            }
            a[j + 1] = temp;
        }
    }
    private static <T extends Comparable<? super T>> int getIndexOfSmallest(T[]a,int first, int last){
        T min = a[first];
        int indexOfMin = first;
        for (int index = first + 1; index <= last; index++) {
            if (a[index].compareTo(min) < 0) {
                min = a[index];
                indexOfMin = index;
            }
        }
        return indexOfMin;
    }
    public static <T extends Comparable<? super T>> void selectionSort(T[] a, int n) {
        for (int index = 0; index < n-1; index++) {
            int indexOfNextSmallest = getIndexOfSmallest(a, index, n-1);
            swap(a, index, indexOfNextSmallest);
        }
    }

    private static void swap(Object[] a, int i, int j) {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static <T extends Comparable<? super T>> void quickSort(T[] a, int n) {
        quickSort(a, 0, n-1);
    }

    public static <T extends Comparable<? super T>> void quickSort(T[] a, int first, int last) {
        final int MIN_SIZE = 10;

        if (last - first + 1 < MIN_SIZE)  {
            insertionSort(a, first, last);
        } else {
            int pivotIndex = partition(a, first, last);
            quickSort(a, first, pivotIndex-1);
            quickSort(a, pivotIndex+1, last);
        }
    }
    private static <T extends Comparable<? super T>> void sortFirstMiddleLast(T[] a, int first, int mid, int last) {
        if (mid < first) {
            swap(a, first, mid);
        } else if (mid > last) {
            swap(a, mid, last);
        }
    }
    private static <T extends Comparable<? super T>> int partition(T[] a, int first, int last) {
        int middle = first + (last-first)/2;
            sortFirstMiddleLast(a, first, middle, last);
            swap(a, middle, last-1);
            int pivotIndex = last-1;
            T pivotValue = a[pivotIndex];
            int indexFromLeft = first+1;
            int indexFromRight = last-2;
            boolean done = false;
            while (!done) {
                while (a[indexFromLeft].compareTo(pivotValue) < 0) {
                    indexFromLeft++;
                }
                while (a[indexFromRight].compareTo(pivotValue) > 0) {
                    indexFromRight--;
                }
                if (indexFromLeft < indexFromRight) {
                    swap(a, indexFromLeft, indexFromRight);
                    indexFromLeft++;
                    indexFromRight--;
                } else {
                    done = true;
                }

            }
            swap(a, pivotIndex, indexFromLeft);
            pivotIndex = indexFromLeft;


        return pivotIndex;
    }
    public static <T extends Comparable<? super T>> void mergeSort(T[] a, int n) {
        mergeSort(a, 0, n-1);
    }
    public static <T extends Comparable<? super T>> void mergeSort(T[] a, int first, int last) {
        @SuppressWarnings("unchecked")
        T[] tempArray = (T[]) new Comparable<?>[a.length];
        mergeSort(a, tempArray, first, last);
    }
    private static <T extends Comparable<? super T>> void mergeSort(T[] a, T[] temptab, int first, int last) {
        if (first < last) {
            int middle = first + (last-first)/2;
            mergeSort(a, first, middle);
            mergeSort(a, middle+1, last);
            merge(a, first, middle, last);
        }
    }
    private static <T extends Comparable<? super T>> void merge(T[] a, int first, int middle, int last) {
        int size = last - first + 1;
        T[] helpArray = (T[]) (new Comparable[size]);
        int firstLeft = first;
        int lastLeft = middle;

        int firstRight = middle + 1;
        int lastRight = last;
        int index = 0;

        while ((firstLeft <= lastLeft) && (firstRight <= lastRight)) {
            if (a[firstLeft].compareTo(a[firstRight]) <= 0) {
                helpArray[index] = a[firstLeft];
                firstLeft++;
            } else {
                helpArray[index] = a[firstRight];
                firstRight++;
            }
            index++;

        }
        while (firstLeft <= lastLeft) {
            helpArray[index] = a[firstLeft];
            firstLeft++;
            index++;
        }

        while (firstRight <= lastRight) {
            helpArray[index] = a[firstRight];
            firstRight++;
            index++;
        }
        index = 0;
        for (int h = first; h <= last; h++) {
            a[h] = helpArray[index];
            index++;
        }
    }

}



