import java.util.Random;

public class RandomDemo {
    public static void main(String[] args) {
        Random random = new Random(1000); // create a Random object with seed 1000
        for (int i = 0; i < 50; i++) {
            System.out.print(random.nextInt(100) + " "); // generate and display a random integer between 0 and 100
        }
    }
}