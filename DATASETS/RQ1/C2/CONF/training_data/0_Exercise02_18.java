public class PowerTable {

    public static void main(String[] args) {
        
        System.out.println("a\tb\tpow(a, b)");

        for (int a = 1; a <= 5; a++) {
            for (int b = a + 1; b <= a + 2; b++) {
                int result = (int) Math.pow(a, b);
                System.out.println(a + "\t" + b + "\t" + result);
            }
        }
    }
}