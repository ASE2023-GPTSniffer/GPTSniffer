import java.util.GregorianCalendar;

public class GregorianCalendarDemo {

    public static void main(String[] args) {
        
        // Display the current year, month, and day
        GregorianCalendar current = new GregorianCalendar();
        System.out.println("Current Year: " + current.get(GregorianCalendar.YEAR));
        System.out.println("Current Month: " + current.get(GregorianCalendar.MONTH));
        System.out.println("Current Day: " + current.get(GregorianCalendar.DAY_OF_MONTH));
        
        // Set the elapsed time to 1234567898765L and display the year, month, and day
        GregorianCalendar specific = new GregorianCalendar();
        specific.setTimeInMillis(1234567898765L);
        System.out.println("Specific Year: " + specific.get(GregorianCalendar.YEAR));
        System.out.println("Specific Month: " + specific.get(GregorianCalendar.MONTH));
        System.out.println("Specific Day: " + specific.get(GregorianCalendar.DAY_OF_MONTH));
    }

}