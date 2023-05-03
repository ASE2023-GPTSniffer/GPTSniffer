public class QuadraticEquation {  private double a;  private double b;  private double c;    public QuadraticEquation(double a, double b, double c) {    this.a = a;    this.b = b;    this.c = c;  }    public double getA() {    return a;  }    public double getB() {    return b;  }    public double getC() {    return c;  }    public double getDiscriminant() {    return b * b - 4 * a * c;  }    public double getRoot1() {    if (getDiscriminant() < 0) {      return 0;    }    return (-b + Math.sqrt(getDiscriminant())) / (2 * a);  }    public double getRoot2() {    if (getDiscriminant() < 0) {      return 0;    }    return (-b - Math.sqrt(getDiscriminant())) / (2 * a);  }    public static void main(String[] args) {    Scanner input = new Scanner(System.in);        System.out.print("Enter a, b, c: ");    double a = input.nextDouble();    double b = input.nextDouble();    double c = input.nextDouble();        QuadraticEquation equation = new QuadraticEquation(a, b, c);        double discriminant = equation.getDiscriminant();        if (discriminant > 0) {      double root1 = equation.getRoot1();      double root2 = equation.getRoot2();      System.out.println("The roots are " + root1 + " and " + root2);    } else if (discriminant == 0) {      double root = -b / (2 * a);      System.out.println("The root is " + root);    } else {      System.out.println("The equation has no roots.");    }  }}