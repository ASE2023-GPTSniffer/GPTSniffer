public class PrimeNumbers {
    public static void main(String[] args) {
        StackOfIntegers stack = new StackOfIntegers();
        for (int i = 2; i < 120; i++) {
            if (isPrime(i)) {
                stack.push(i);
            }
        }
        System.out.println("Prime numbers less than 120 in decreasing order:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
