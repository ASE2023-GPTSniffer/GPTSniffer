import java.util.*;

public class MaximumIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String str = input.next();
        
        int n = str.length();
        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);
        
        int maxIndex = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (str.charAt(j) < str.charAt(i) && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = maxIndex; i != -1; i = prev[i]) {
            sb.append(str.charAt(i));
        }
        
        System.out.println(sb.reverse().toString());
    }
}
