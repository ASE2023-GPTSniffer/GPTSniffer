

import java.util.Scanner;


public class Feet2Meters {
    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);

        System.out.println("Enter a value for number of feet now: ");

        double numFeet = input.nextDouble();
        double numMeters = numFeet * 0.305;


        System.out.println(numFeet + " feet is equal to " + numMeters + " meters");
    }
}
