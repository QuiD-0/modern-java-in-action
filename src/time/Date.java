package time;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;

public class Date {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now().with(ChronoField.DAY_OF_MONTH, 1);
        System.out.println("First day of the month : " + date);

        LocalDate date2 = LocalDate.now().with(lastDayOfMonth());
        System.out.println("Last day of the month : " + date2);

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("Zoned Date Time : " + zonedDateTime);
    }
}
