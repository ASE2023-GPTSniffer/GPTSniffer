



public class FileToTest {
    public static void main(String[] args) { // public static void
        String KEY_WORDS = "abstract assert boolean break";
        for (int i = 6; i >= 0; i--) {
            System.out.println("args[0]: " + args[0]);
            if (args[i] == null) {
                break;
            }
        }
        System.out.print(KEY_WORDS); /* null null null */
    }

}
