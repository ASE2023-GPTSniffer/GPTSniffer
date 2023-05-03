import java.util.*;

public class MatrixExplorer {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size for the matrix: ");
        int n = input.nextInt();

        // Create a new n x n matrix and fill it with 0s and 1s
        int[][] matrix = new int[n][n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt(2);
            }
        }

        // Print the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

        // Check rows for all 0s or 1s
        for (int i = 0; i < n; i++) {
            boolean allZeros = true;
            boolean allOnes = true;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    allZeros = false;
                } else {
                    allOnes = false;
                }
            }
            if (allZeros) {
                System.out.println("All 0s on row " + (i + 1));
            } else if (allOnes) {
                System.out.println("All 1s on row " + (i + 1));
            }
        }

        // Check columns for all 0s or 1s
        for (int j = 0; j < n; j++) {
            boolean allZeros = true;
            boolean allOnes = true;
            for (int i = 0; i < n; i++) {
                if (matrix[i][j] == 1) {
                    allZeros = false;
                } else {
                    allOnes = false;
                }
            }
            if (allZeros) {
                System.out.println("All 0s on column " + (j + 1));
            } else if (allOnes) {
                System.out.println("All 1s on column " + (j + 1));
            }
        }

        // Check major diagonal for same numbers
        boolean allZeros = true;
        boolean allOnes = true;
        for (int i = 0; i < n; i++) {
            if (matrix[i][i] == 1) {
                allZeros = false;
            } else {
                allOnes = false;
            }
        }
        if (allZeros) {
            System.out.println("All 0s on the major diagonal");
        } else if (allOnes) {
            System.out.println("All 1s on the major diagonal");
        }

        // Check sub-diagonal for same numbers
        allZeros = true;
        allOnes = true;
        for (int i = 0; i < n; i++) {
            if (matrix[i][n - i - 1] == 1) {
                allZeros = false;
            } else {
                allOnes = false;
            }
        }
        if (allZeros) {
            System.out.println("All 0s on the sub-diagonal");
        } else if (allOnes) {
            System.out.println("All 1s on the sub