import java.util.Scanner;

public class SavingsAccount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        System.out.print("Enter the initial amount: $");
        double amount = scanner.nextDouble();
        System.out.print("Enter the annual interest rate (as a percentage): ");
        double annualRate = scanner.nextDouble();
        System.out.print("Enter the number of months: ");
        int months = scanner.nextInt();
        
        
        double monthlyRate = annualRate / 1200.0;  
        
        
        for (int i = 1; i <= months; i++) {
            amount = amount + (100 * monthlyRate) + 100;  
        }
        
        
        System.out.printf("The balance after %d months is: $%.2f", months, amount);
    }
}