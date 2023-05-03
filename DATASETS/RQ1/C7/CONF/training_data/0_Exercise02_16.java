
public class HexagonArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter the side length of the hexagon: ");
        double side = scanner.nextDouble();

        
        double area = (3 * Math.sqrt(3) / 2) * Math.pow(side, 2);

        
        System.out.printf("The area of the hexagon is %.2f", area);
    }
}
