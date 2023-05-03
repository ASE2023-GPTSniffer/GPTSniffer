import java.util.Scanner;

public class InvestmentValue {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("The amount invested: ");
        double investmentAmount = input.nextDouble();
        
        System.out.print("Annual interest rate: ");
        double annualInterestRate = input.nextDouble();
        
        
        double monthlyInterestRate = annualInterestRate / 1200;
        
        System.out.println("Years  Future Value");
        
        
        for (int years = 1; years <= 30; years++) {
            double futureValue = futureInvestmentValue(investmentAmount, monthlyInterestRate, years);
            System.out.printf("%-5d  $%9.2f\n", years, futureValue);
        }
    }
    
    
    public static double futureInvestmentValue(double investmentAmount, double monthlyInterestRate, int years) {
        return investmentAmount * Math.pow(1 + monthlyInterestRate, years * 12);
    }

}
