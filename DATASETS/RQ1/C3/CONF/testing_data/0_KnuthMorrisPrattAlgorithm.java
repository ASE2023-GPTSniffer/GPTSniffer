public class KMPAlgorithm {
    public static int[] computeLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        int j = 0;
        for (int i = 1; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(j) != pattern.charAt(i)) {
                j = lps[j - 1];
            }
            if (pattern.charAt(j) == pattern.charAt(i)) {
                j++;
            }
            lps[i] = j;
        }
        return lps;
    }

    public static List<Integer> search(String text, String pattern) {
        List<Integer> matches = new ArrayList<>();
        int[] lps = computeLPS(pattern);
        int i = 0, j = 0;
        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                if (j == pattern.length()) {
                    matches.add(i - j);
                    j = lps[j - 1];
                }
            } else if (j > 0) {
                j = lps[j - 1];
            } else {
                i++;
            }
        }
        return matches;
    }
}


public class KMPExample {
    public static void main(String[] args) {
        String text = "ABCABCABCABDABCABCDABCABCABCABCD";
        String pattern = "ABCABCABCD";
        List<Integer> matches = KMPAlgorithm.search(text, pattern);
        System.out.println("Matches found at positions: " + matches);
    }
}
