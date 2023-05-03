import java.util.Scanner;

public class Gratuity {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the sub-total: $");
        double subtotal = input.nextDouble();
        System.out.print("Enter the gratuity rate (as a percentage): ");
        double gratuityRate = input.nextDouble();
        
        // Calculate the gratuity and total
        double gratuity = subtotal * (gratuityRate / 100);
        double total = subtotal + gratuity;
        
        // Display the result
        System.out.printf("The gratuity is $%.2f and the total is $%.2f.%n", gratuity, total);
    }
}