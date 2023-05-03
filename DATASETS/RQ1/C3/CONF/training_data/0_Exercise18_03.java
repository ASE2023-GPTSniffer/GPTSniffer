public static int gcd(int m, int n) {
    if (m % n == 0) {
        return n;
    } else {
        return gcd(n, m % n);
    }
}


import java.util.Scanner;

public class GCDTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first integer: ");
        int m = input.nextInt();
        System.out.print("Enter the second integer: ");
        int n = input.nextInt();
        int gcdValue = gcd(m, n);
        System.out.println("The GCD of " + m + " and " + n + " is " + gcdValue);
    }
}
