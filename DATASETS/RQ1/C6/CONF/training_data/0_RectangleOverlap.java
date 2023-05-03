import java.util.Scanner;

public class RectangleOverlapExample {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        
        System.out.println("Enter the center x-coordinate, center y-coordinate, width, and height of the first rectangle (separated by spaces):");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        double w1 = scanner.nextDouble();
        double h1 = scanner.nextDouble();

        
        System.out.println("Enter the center x-coordinate, center y-coordinate, width, and height of the second rectangle (separated by spaces):");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
        double w2 = scanner.nextDouble();
        double h2 = scanner.nextDouble();

        
        double x1Min = x1 - w1 / 2;
        double y1Min = y1 - h1 / 2;
        double x1Max = x1 + w1 / 2;
        double y1Max = y1 + h1 / 2;
        double x2Min = x2 - w2 / 2;
        double y2Min = y2 - h2 / 2;
        double x2Max = x2 + w2 / 2;
        double y2Max = y2 + h2 / 2;

        
        String overlapStatus;
        if (x1Min <= x2Max && x1Max >= x2Min && y1Min <= y2Max && y1Max >= y2Min) {
            
            overlapStatus = "Overlap";
        } else if (x1Min >= x2Min && x1Max <= x2Max && y1Min >= y2Min && y1Max <= y2Max) {
            
            overlapStatus = "Rectangle 1 is contained in Rectangle 2";
        } else if (x2Min >= x1Min && x2Max <= x1Max && y2Min >= y1Min && y2Max <= y1Max) {
            
            overlapStatus = "Rectangle 2 is contained in Rectangle 1";
        } else {
            
            overlapStatus = "No overlap";
        }

        
        System.out.println("Rectangle 1: (" + x1 + ", " + y1 + "), width=" + w1 + ", height=" + h1);
        System.out.println("Rectangle 2: (" + x2 + ", " + y2 + "), width=" + w2 + ", height=" + h2);
        System.out.println("Overlap status: " + overlapStatus);
    }
}

