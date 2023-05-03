

import java.util.ArrayList;
import java.util.Arrays;


public class ArrayListSorter{
    public static void main(String[] args) {
        
        ArrayList<Double> doubleList =
                new ArrayList<>(Arrays.asList(5.0, 7.0, 1.0, 9.0, 10.0, 6.0, 2.0, 4.0, 3.0, 8.0));
        
        ArrayList<Integer> integerList =
                new ArrayList<>(Arrays.asList(55, 99, 66, 33, 100, 11, 77, 44, 88, 22));

        System.out.println("Before sorting the ArrayList of Doubles is: " + doubleList);
        sort(doubleList);
        System.out.println("After performing Generic sort: " + doubleList);

        System.out.println("Before sorting the ArrayList of Integers is: " + integerList);
        sort(integerList);
        System.out.println("After performing Generic sort: " + integerList);
    }

    public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
        boolean loop = true;
        while (loop) {
            loop = false;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                    loop = true;
                    E temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                }
            }
        }
    }
}
