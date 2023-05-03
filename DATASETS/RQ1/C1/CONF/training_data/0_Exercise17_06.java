import java.io.Serializable;

public class Loan implements Serializable {

    private static final long serialVersionUID = 1L;

    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    
    public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
    }
    
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }
    
    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }
    
    public int getNumberOfYears() {
        return numberOfYears;
    }
    
    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }
    
    public double getLoanAmount() {
        return loanAmount;
    }
    
    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }
    
    public double getMonthlyPayment() {
        // calculate monthly payment
    }
    
    public double getTotalPayment() {
        // calculate total payment
    }
    
    public String getLoanDate() {
        // return loan date
    }
}
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) {
        // create Loan objects
        Loan loan1 = new Loan(0.05, 10, 10000);
        Loan loan2 = new Loan(0.07, 15, 20000);
        Loan loan3 = new Loan(0.03, 5, 5000);
        Loan loan4 = new Loan(0.06, 20, 30000);
        Loan loan5 = new Loan(0.08, 25, 40000);
        
        // store Loan objects in file
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Exercise17_06.dat"))) {
            output.writeObject(loan1);
            output.writeObject(loan2);
            output.writeObject(loan3);
            output.writeObject(loan4);
            output.writeObject(loan5);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
