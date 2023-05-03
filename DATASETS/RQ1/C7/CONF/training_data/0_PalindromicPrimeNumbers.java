public class PalindromicPrimes {
    
    public static void main(String[] args) {
        int count = 0;
        int number = 2;
        
        while (count < 100) {
            if (isPalindrome(number) && isPrime(number)) {
                System.out.print(number + " ");
                count++;
                
                if (count % 10 == 0) {
                    System.out.println();
                }
            }
            
            number++;
        }
    }
    
    
    public static boolean isPalindrome(int number) {
        int reversed = 0;
        int n = number;
        
        while (n > 0) {
            reversed = reversed * 10 + n % 10;
            n /= 10;
        }
        
        return reversed == number;
    }
    
    
    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}

