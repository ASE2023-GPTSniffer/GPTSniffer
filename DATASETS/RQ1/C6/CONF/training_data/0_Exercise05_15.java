public class ASCIICharacters {
    public static void main(String[] args) {
        int count = 0;  
        
        for (char c = '!'; c <= '~'; c++) {
            System.out.print(c + " ");
            count++;
            
            if (count == 10) {  
                System.out.println();  
                count = 0;  
            }
        }
    }
}
