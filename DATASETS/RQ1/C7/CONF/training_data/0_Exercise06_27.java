public class EmirpNumbers {
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int reverse(int number) {
        int reverse = 0;
        while (number != 0) {
            int digit = number % 10;
            reverse = reverse * 10 + digit;
            number /= 10;
        }
        return reverse;
    }

    public static boolean isEmirp(int number) {
        int reverse = reverse(number);
        return number != reverse && isPrime(number) && isPrime(reverse);
    }

    public static void main(String[] args) {
        int count = 0;
        int number = 13;
        while (count < 100) {
            if (isEmirp(number)) {
                System.out.print(number + " ");
                count++;
                if (count % 10 == 0) {
                    System.out.println();
                }
            }
            number++;
        }
    }
}
