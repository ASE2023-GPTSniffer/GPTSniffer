
public class PasswordChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        
        System.out.print("Enter a password: ");
        String password = input.nextLine();

        
        if (checkPassword(password)) {
            System.out.println("Valid Password");
        } else {
            System.out.println("Invalid Password");
        }
    }

    public static boolean checkPassword(String password) {
        
        if (password.length() < 8) {
            return false;
        }

        
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (!Character.isLetterOrDigit(ch)) {
                return false;
            }
        }

        
        int count = 0;
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isDigit(ch)) {
                count++;
            }
        }
        if (count < 2) {
            return false;
        }

        
        return true;
    }
}
