import java.util.GregorianCalendar;

public class MyDateTest {
    public static void main(String[] args) {
        MyDate date1 = new MyDate();
        MyDate date2 = new MyDate(34355555133101L);

        System.out.println("Date 1: " + date1.getYear() + "/" + date1.getMonth() + "/" + date1.getDay());
        System.out.println("Date 2: " + date2.getYear() + "/" + date2.getMonth() + "/" + date2.getDay());
    }
}

class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate() {
        GregorianCalendar cal = new GregorianCalendar();
        this.year = cal.get(GregorianCalendar.YEAR);
        this.month = cal.get(GregorianCalendar.MONTH) + 1;
        this.day = cal.get(GregorianCalendar.DAY_OF_MONTH);
    }

    public MyDate(long elapsedTime) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTimeInMillis(elapsedTime);
        this.year = cal.get(GregorianCalendar.YEAR);
        this.month = cal.get(GregorianCalendar.MONTH) + 1;
        this.day = cal.get(GregorianCalendar.DAY_OF_MONTH);
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }
}
