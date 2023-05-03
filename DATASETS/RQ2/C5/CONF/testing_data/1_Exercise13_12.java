

import java.util.Random;


public class SumGeometricObjectAreas {
    static Random randomDbl = new Random(99999);

    public static void main(String[] args) {
        GeometricObject[] test = new GeometricObject[4];
        for (int i = 0; i < 2; i++) {
            test[i] = new Rectangle(randomDbl.nextDouble() * 9, randomDbl.nextDouble() * 9);
            System.out.println("Created a Rectangle with area: " + test[i].getArea());
        }
        for (int i = 2; i < test.length; i++) {
            test[i] = new Circle(randomDbl.nextDouble() * 9);
            System.out.println("Created Circle with area: " + test[i].getArea());
        }
        double sumOfArea = sumArea(test);
        System.out.println("Total area is " + sumOfArea);
    }

    public static double sumArea(GeometricObject[] a) {
        double totalArea = 0.0;
        for (GeometricObject geometricObject : a) {
            totalArea += geometricObject.getArea();
        }
        return totalArea;

    }

}
