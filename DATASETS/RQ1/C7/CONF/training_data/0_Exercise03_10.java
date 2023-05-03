
public class AdditionQuestion {

    public static void main(String[] args) {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int num1 = random.nextInt(100);
        int num2 = random.nextInt(100);
        int answer = num1 + num2;

        System.out.printf("What is %d + %d? ", num1, num2);
        int userAnswer = scanner.nextInt();

        if (userAnswer == answer) {
            System.out.println("Correct!");
        } else {
            System.out.printf("Incorrect. The correct answer is %d.\n", answer);
        }
    }
}
