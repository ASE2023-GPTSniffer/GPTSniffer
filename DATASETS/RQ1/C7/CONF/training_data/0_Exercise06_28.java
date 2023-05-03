public class MersennePrimes {
    public static void main(String[] args) {
        for (int p = 2; p <= 31; p++) {
            int mersenne = (int)Math.pow(2, p) - 1;
            if (isPrime(mersenne)) {
                System.out.println("Mersenne prime with p = " + p + ": " + mersenne);
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
