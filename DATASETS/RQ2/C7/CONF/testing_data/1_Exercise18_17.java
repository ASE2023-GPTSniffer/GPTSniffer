



public class CharacterCounter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a list of characters in one line: ");
        String line = in.nextLine();
        char[] chars = line.toCharArray();

        System.out.println("Enter a single character: ");
        char ch = in.next().charAt(0);
        System.out.println("The character " + ch + " occurs " + count(chars, ch) + " times.");
        in.close();
    }

    public static int count(char[] chars, char ch) {
        return count(chars, ch, chars.length - 1);
    }

    public static int count(char[] chars, char ch, int high) {
        if (high > 0) {
            return chars[high] == ch ? (1 + count(chars, ch, high - 1)) : (count(chars, ch, high - 1));
        } else {
            return 0;
        }
    }
}
