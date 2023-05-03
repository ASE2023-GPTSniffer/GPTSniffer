import java.util.*;

public class UnsafeBanks {
    static double[][] borrowers;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double limit = scanner.nextDouble();
        borrowers = new double[n][n];

        // Read the input
        double[] balances = new double[n];
        int[] numBorrowers = new int[n];
        for (int i = 0; i < n; i++) {
            balances[i] = scanner.nextDouble();
            numBorrowers[i] = scanner.nextInt();
            for (int j = 0; j < numBorrowers[i]; j++) {
                int borrower = scanner.nextInt();
                double amount = scanner.nextDouble();
                borrowers[i][borrower] = amount;
            }
        }

        boolean[] isUnsafe = new boolean[n];
        Arrays.fill(isUnsafe, false);

        // Check the safety of all banks
        for (int i = 0; i < n; i++) {
            if (!isUnsafe[i]) {
                checkSafety(i, isUnsafe, balances, limit);
            }
        }

        // Print the unsafe banks
        System.out.print("Unsafe banks are ");
        boolean first = true;
        for (int i = 0; i < n; i++) {
            if (isUnsafe[i]) {
                if (!first) {
                    System.out.print(" ");
                }
                System.out.print(i);
                first = false;
            }
        }
        System.out.println();
    }

    public static boolean checkSafety(int bank, boolean[] isUnsafe, double[] balances, double limit) {
        // If the bank is already marked as unsafe, return true
        if (isUnsafe[bank]) {
            return true;
        }

        double totalAssets = balances[bank];
        boolean allBorrowersSafe = true;
        for (int i = 0; i < borrowers[bank].length; i++) {
            if (borrowers[bank][i] > 0) {
                totalAssets += borrowers[bank][i];
                if (!checkSafety(i, isUnsafe, balances, limit)) {
                    allBorrowersSafe = false;
                } else {
                    borrowers[bank][i] = 0;
                }
            }
        }

        // Mark the bank as unsafe if its total assets are less than the limit
        if (totalAssets < limit) {
            isUnsafe[bank] = true;
            return false;
        }

        // Mark the bank as unsafe if any of its borrowers are unsafe
        if (!allBorrowersSafe) {
            isUnsafe[bank] = true;
            return false;
        }

        return true;
    }
}