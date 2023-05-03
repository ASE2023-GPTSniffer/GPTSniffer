

import java.util.Scanner;


public class SavingsAccount{
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the amount you would like to invest each month: ");

        double investment = input.nextDouble();

        System.out.print("Enter the annual interest rate(e.g. 5,10,20): ");

        double interestRate = input.nextDouble();

        interestRate = interestRate / 100;

        System.out.println("Enter the number of months: ");

        int numberOfMonths = input.nextInt();

        double total = 0;

        for (int i = 1; i <= numberOfMonths; i++) {


            total = (investment + total) * (1 + (interestRate / 12));

        }


        System.out.println("After the " + numberOfMonths + "th month, " + "the account value is " + total);


    }

}
