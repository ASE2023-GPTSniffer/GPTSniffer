class TriangleArea {
    public static double triangleArea(double a, double b, double c) {
        double s = (a + b + c) / 2;
        double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        return area;
    }

    public static void main(String[] args) {
        double a = 3;
        double b = 4;
        double c = 5;
        System.out.println("Area of triangle with sides " + a + ", " + b + ", " + c + " is " + triangleArea(a, b, c));
    }
}
