
public class CurrentDateTime {
    public static void main(String[] args) {
        
        long currentTimeInMillis = System.currentTimeMillis();

        
        Date currentDate = new Date(currentTimeInMillis);

        
        System.out.println("Current date and time is " + currentDate);
    }
}
