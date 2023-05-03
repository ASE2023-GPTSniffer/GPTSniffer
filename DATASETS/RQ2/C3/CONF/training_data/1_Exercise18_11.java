

import java.util.Scanner;


public class Exercise18_11 {
    static int sum;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        long num = in.nextInt();
        System.out.println("Sum of the digits in " + num + " is " + sumDigits(num));

    }

    public static int sumDigits(long n) {
        if (n == 0) {
            return sum;
        }
        long i = n % 10;
        sum += i;
        n /= 10;
      return sumDigits(n);
    }
}
