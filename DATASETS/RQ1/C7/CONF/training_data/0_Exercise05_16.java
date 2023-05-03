
public class SmallestFactors {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        
        System.out.print("Enter an integer: ");
        int number = input.nextInt();

        
        System.out.print("The smallest factors of " + number + " are: ");
        int factor = 2;
        while (factor <= number) {
            if (number % factor == 0) {
                System.out.print(factor + " ");
                number /= factor;
            } else {
                factor++;
            }
        }
    }
}
