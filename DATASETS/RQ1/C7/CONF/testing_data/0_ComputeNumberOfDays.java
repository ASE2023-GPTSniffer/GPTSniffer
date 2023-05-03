
public class DaysInMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the month (1-12): ");
        int month = scanner.nextInt();

        System.out.print("Enter the year: ");
        int year = scanner.nextInt();

        int days = getDaysInMonth(month, year);

        if (days == -1) {
            System.out.println("Invalid month or year");
        } else {
            System.out.println("Number of days in month " + month + " and year " + year + " is: " + days);
        }
    }

    public static int getDaysInMonth(int month, int year) {
        if (month < 1 || month > 12) {
            return -1;
        }

        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

        switch (month) {
            case 2:
                return isLeapYear ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }
}

public class LunarCalendar {

    public static void main(String[] args) {
        int month = 5;
        int year = 2022;
        int days = getDaysInLunarMonth(month, year);
        System.out.println("Number of days in month " + month + " and year " + year + " of the Lunar Calendar is: " + days);
    }

    public static int getDaysInLunarMonth(int month, int year) {
        if (month < 1 || month > 12) {
            return -1;
        }

        
        
        
        
        
        
        
        
        
        if (month == 1) {
            return 29;
        } else if (month == 12) {
            return 30;
        } else {
            return (year + 8) % 12 == 0 ? 30 : 29;
        }
    }
}

