
public class HeapSort {

    public static <E extends Comparable<E>> void heapSort(E[] list) {
        int n = list.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(list, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            E temp = list[0];
            list[0] = list[i];
            list[i] = temp;
            heapify(list, i, 0);
        }
    }

    public static <E> void heapSort(E[] list, Comparator<? super E> comparator) {
        int n = list.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(list, n, i, comparator);
        }

        for (int i = n - 1; i >= 0; i--) {
            E temp = list[0];
            list[0] = list[i];
            list[i] = temp;
            heapify(list, i, 0, comparator);
        }
    }

    private static <E extends Comparable<E>> void heapify(E[] list, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && list[left].compareTo(list[largest]) > 0) {
            largest = left;
        }

        if (right < n && list[right].compareTo(list[largest]) > 0) {
            largest = right;
        }

        if (largest != i) {
            E temp = list[i];
            list[i] = list[largest];
            list[largest] = temp;
            heapify(list, n, largest);
        }
    }

    private static <E> void heapify(E[] list, int n, int i, Comparator<? super E> comparator) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && comparator.compare(list[left], list[largest]) > 0) {
            largest = left;
        }

        if (right < n && comparator.compare(list[right], list[largest]) > 0) {
            largest = right;
        }

        if (largest != i) {
            E temp = list[i];
            list[i] = list[largest];
            list[largest] = temp;
            heapify(list, n, largest, comparator);
        }
    }

}
