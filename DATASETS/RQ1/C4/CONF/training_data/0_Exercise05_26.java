import java.math.BigDecimal;

public class ApproximateE {
    public static void main(String[] args) {
        int[] iValues = {10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000, 100000};
        for (int i : iValues) {
            BigDecimal sum = BigDecimal.ONE;
            BigDecimal factorial = BigDecimal.ONE;
            for (int j = 1; j <= i; j++) {
                factorial = factorial.multiply(BigDecimal.valueOf(j));
                sum = sum.add(BigDecimal.ONE.divide(factorial));
            }
            System.out.println("e for i = " + i + " is: " + sum);
        }
    }
}