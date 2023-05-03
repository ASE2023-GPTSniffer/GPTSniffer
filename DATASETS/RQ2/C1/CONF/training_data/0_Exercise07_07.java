import java.util.Random;

public class CountSingleDigits {
    public static void main(String[] args) {
        int[] counts = new int[10]; // initialize an array to store the counts

        Random rand = new Random(); // create a new Random object
        for (int i = 0; i < 100; i++) {
            int num = rand.nextInt(10); // generate a random integer between 0 and 9
            counts[num]++; // increment the count for that integer
        }

        // display the counts for each number
        for (int i = 0; i < 10; i++) {
            System.out.printf("Count for %d: %d\n", i, counts[i]);
        }
    }
}