class QuadraticEquation {
    public static void findRoots(double a, double b, double c) {
        double discriminant = b * b - 4 * a * c;
        double root1, root2;
        if (discriminant > 0) {
            root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("Roots are real and different, Root 1 = " + root1 + " and Root 2 = " + root2);
        } else if (discriminant == 0) {
            root1 = root2 = -b / (2 * a);
            System.out.println("Roots are real and same, Root 1 = Root 2 = " + root1);
        } else {
            double realPart = -b / (2 * a);
            double imaginaryPart = Math.sqrt(-discriminant) / (2 * a);
            System.out.println("Roots are complex, Root 1 = " + realPart + "+i" + imaginaryPart);
            System.out.println("Root 2 = " + realPart + "-i" + imaginaryPart);
        }
    }

    public static void main(String[] args) {
        double a = 1;
        double b = -5;
        double c = 6;
        findRoots(a, b, c);
    }
}
