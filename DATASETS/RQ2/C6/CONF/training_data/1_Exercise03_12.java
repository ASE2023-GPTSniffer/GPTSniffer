

import java.util.Scanner;


public class PalindromeNumber{
    public static void main(String[] args) {

        System.out.println("Please enter a three digit integer:");

        Scanner input = new Scanner(System.in);
        int startNum = input.nextInt();

        int numLast = startNum % 10;
        int numFirst = startNum / 100;
        input.close();

        if (numLast == numFirst) {
            System.out.println("This number is a Palindrome!");
        } else
            System.out.println("This number is not a Palindrome :(");

    }

}
