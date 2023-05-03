import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        short num = input.nextShort();
        String binaryString = Integer.toBinaryString(num & 0xffff);
        System.out.println("The bits are " + pad(binaryString));
    }

    public static String pad(String binaryString) {
        return String.format("%16s", binaryString).replace(' ', '0');
    }
}
