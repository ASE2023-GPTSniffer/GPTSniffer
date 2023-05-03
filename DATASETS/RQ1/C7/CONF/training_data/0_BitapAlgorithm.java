 public class BitapAlgorithm {
    private static final int ALPHABET_SIZE = 256;

    public static List<Integer> search(String pattern, String text) {
        List<Integer> positions = new ArrayList<>();

        int m = pattern.length();
        int[] R = new int[ALPHABET_SIZE];
        int[] D = new int[m + 1];
        int[] prevD = new int[m + 1];

        int matchMask = 1 << (m - 1);
        Arrays.fill(R, 0);
        for (int i = 0; i < m; i++) {
            R[pattern.charAt(i)] |= 1 << i;
        }

        for (int i = 1; i <= m; i++) {
            D[i] = 1 << (i - 1);
        }

        for (int i = 0; i < text.length(); i++) {
            int oldD = D[0];
            int letter = text.charAt(i);
            D[0] = ((D[0] << 1) | 1) & R[letter];
            for (int j = 1; j <= m; j++) {
                int tmp = D[j];
                D[j] = ((prevD[j - 1] & (D[j - 1] << 1)) | (D[j] << 1) | 1) & R[pattern.charAt(j - 1)];
                prevD[j - 1] = tmp;
            }

            if ((D[m] & matchMask) != 0) {
                positions.add(i - m + 1);
            }

            if ((D[0] & 1) == 0) {
                break;
            }
        }

        return positions;
    }
}

