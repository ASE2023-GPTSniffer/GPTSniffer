
public class LinearEquationSolver {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        
        System.out.print("Enter a, b, c, d, e, f: ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        double d = input.nextDouble();
        double e = input.nextDouble();
        double f = input.nextDouble();

        
        double denominator = a * d - b * c;
        double x = (e * d - b * f) / denominator;
        double y = (a * f - e * c) / denominator;

        
        if (denominator == 0) {
            System.out.println("The equation has no solution.");
        } else {
            System.out.printf("x is %.2f and y is %.2f%n", x, y);
        }
    }
}
