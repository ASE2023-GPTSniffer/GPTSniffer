
public class PolygonAreaCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        
        double[][] vertices = new double[4][2];
        System.out.print("Enter x1, y1, x2, y2, x3, y3, x4, y4: ");
        for (int i = 0; i < 4; i++) {
            vertices[i][0] = input.nextDouble();
            vertices[i][1] = input.nextDouble();
        }

        
        double[] areas = new double[4];
        areas[0] = getTriangleArea(vertices[0], vertices[1], vertices[2]);
        areas[1] = getTriangleArea(vertices[0], vertices[1], vertices[3]);
        areas[2] = getTriangleArea(vertices[1], vertices[2], vertices[3]);
        areas[3] = getTriangleArea(vertices[2], vertices[3], vertices[0]);

        
        java.util.Arrays.sort(areas);

        
        System.out.print("The areas are ");
        for (double area : areas) {
            System.out.printf("%.2f ", area);
        }
        System.out.println();
    }

    public static double getTriangleArea(double[] p1, double[] p2, double[] p3) {
        
        double a = distance(p1, p2);
        double b = distance(p2, p3);
        double c = distance(p3, p1);
        double s = (a + b + c) / 2;
        double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        return area;
    }

    public static double distance(double[] p1, double[] p2) {
        double dx = p2[0] - p1[0];
        double dy = p2[1] - p1[1];
        double distance = Math.sqrt(dx * dx + dy * dy);
        return distance;
    }
}
