

import java.util.Scanner;


public class nan{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a String: ");
        String s = in.next().trim();
        reverseDisplay(s, s.length() - 1);
    }

    public static void reverseDisplay(String value, int high) {
        if (!(value.length() == 0)) {
            System.out.print(value.charAt(high));
            value = value.substring(0, high);
            reverseDisplay(value, value.length() - 1);
        }
    }
}
