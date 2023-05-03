

import java.util.Arrays;
import java.util.Comparator;


public class QuickSort{

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{23, 25, 7, 14, 85, 65};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));

        Integer[] arr2 = new Integer[]{3, 2, 7, 4, 8, 6, 1, 7};
        quickSort(arr2, Integer::compareTo);
        System.out.println(Arrays.toString(arr2));

    }

    
    public static <E extends Comparable<E>> void quickSort(E[] list) {
        quickSort(list, 0, list.length - 1);
    }

    public static <E extends Comparable<E>> void quickSort(E[] list, int first, int last) {
        if (last > first) {
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, last);
        }
    }

    public static <E extends Comparable<E>> int partition(E[] list, int first, int last) {
        E pivot = list[first]; 
        int low = first + 1; 
        int high = last; 

        while (high > low) {
            
            while (low <= high && list[low].compareTo(pivot) <= 0) low++;

            
            while (low <= high && list[high].compareTo(pivot) > 0) high--;

            
            if (high > low) {
                E temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }

        while (high > first && list[high].compareTo(pivot) >= 0)
            high--;

        
        if (pivot.compareTo(list[high]) > 0) {
            list[first] = list[high];
            list[high] = pivot;
            return high;
        } else {
            return first;
        }
    }

    
    public static <E> void quickSort(E[] list,
                                     Comparator<? super E> comparator) {
        quickSort(list, 0, list.length - 1, comparator);


    }

    
    public static <E> void quickSort(E[] list, int first, int last,
                                     Comparator<? super E> comparator) {
        if (last > first) {
            int pivotIndex;
            
            E pivot = list[first]; 
            int low = first + 1; 
            int high = last; 

            while (high > low) {
                
                while (low <= high && comparator.compare(list[low], pivot) <= 0) low++;

                
                while (low <= high && comparator.compare(list[high], pivot) > 0) high--;

                
                if (high > low) {
                    E temp = list[high];
                    list[high] = list[low];
                    list[low] = temp;
                }
            }

            while (high > first && comparator.compare(list[high], pivot) >= 0)
                high--;

            
            if (comparator.compare(pivot, list[high]) > 0) {
                list[first] = list[high];
                list[high] = pivot;
                pivotIndex = high;
            } else {
                pivotIndex = first;
            }

            quickSort(list, first, pivotIndex - 1, comparator);
            quickSort(list, pivotIndex + 1, last, comparator);
        }
    }

}
