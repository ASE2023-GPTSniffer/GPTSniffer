



import java.io.*;
import java.util.Arrays;


public class LoanHandler {
    
    public static void main(String[] args) {
        String[] packageParts = Exercise17_01.class.getPackage().getName().split("\\.");
        String path = packageParts[0] + File.separator + packageParts[1] + File.separator +
                        "Exercise17_06" +
                        ".dat";


        File outFile = new File(path);

        Loan[] loans = new Loan[5];
        loans[0] = new Loan(6.5, 10, 1000);
        loans[1] = new Loan(4.7, 10, 1000);
        loans[2] = new Loan(3.9, 10, 1000);
        loans[3] = new Loan(11.5, 10, 1000);
        loans[4] = new Loan(2.5, 10, 1000);
        boolean success = false;

        try {
            writeLoansToFile(outFile, loans);
            success = true;
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
            System.out.println("File not found.");
        }
        if (success) {
            testLoanObjects(new File(path), loans);
        }

    }

    
    public static void testLoanObjects(File file, Loan... loans) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            Loan[] pLoans = (Loan[]) objectInputStream.readObject();
            System.out.println("Reading loans... these are the loans that were read: ");
            Arrays.asList(pLoans).forEach(ploan -> System.out.println(ploan.toString()));

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception reading file.");
        }
    }

    
    public static void writeLoansToFile(File file, Loan... loans) throws FileNotFoundException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            outputStream.writeObject(loans);
            System.out.println("Wrote these loans to file: ");
            Arrays.asList(loans).forEach(loan -> System.out.println(loan.toString()));

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}