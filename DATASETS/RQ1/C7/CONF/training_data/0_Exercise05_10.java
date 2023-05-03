public class DivisibleBy5And6 {
    public static void main(String[] args) {
        final int LOWER_LIMIT = 100;
        final int UPPER_LIMIT = 1000;
        final int NUMBERS_PER_LINE = 10;

        int count = 0;
        for (int i = LOWER_LIMIT; i <= UPPER_LIMIT; i++) {
            if (i % 5 == 0 && i % 6 == 0) {
                System.out.print(i + " ");
                count++;
                if (count % NUMBERS_PER_LINE == 0) {
                    System.out.println();
                }
            }
        }
    }
}
