


public class nan {
    public static void main(String[] args) {

        Rectangle r1 = new Rectangle(10.15, 11.55);
        Rectangle r2 = new Rectangle(31.22, 12.44);

        System.out.println("The larger of the two rectangles is the one:");
        System.out.println("\n" + Rectangle.max(r1, r2));

        Circle c1 = new Circle(13.45);
        Circle c2 = new Circle(10.15);

        System.out.println("\nThe larger of the two circles is the one:");
        System.out.println("\n" + Circle.max(c1, c2));

    }
}
