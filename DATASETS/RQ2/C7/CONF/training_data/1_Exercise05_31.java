



public class CDValueCalculator {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the initial deposit amount: ");
        double deposit = input.nextDouble();

        System.out.print("Enter annual percentage yield: ");
        double annualInterestRate = input.nextDouble();
        double monthlyInterestRate = annualInterestRate / 1200.0;

        System.out.print("Enter maturity period in months: ");
        double numberOfMonths = input.nextInt();

        System.out.print("Months\t\t\tCD Value\n");
        double amountInAccount = deposit;
        for (int i = 1; i <= numberOfMonths; i++) {
            amountInAccount *= (1.0D + monthlyInterestRate);
            System.out.printf("%5d%20.2f\n", i, amountInAccount);
        }
    }
}
