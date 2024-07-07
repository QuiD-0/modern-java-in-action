package time;

import java.time.Duration;
import java.time.Instant;
import java.time.Period;

import static java.time.temporal.ChronoUnit.DAYS;

public class Time {
    public static void main(String[] args) {
        Instant instance = Instant.now();
        System.out.println("Current Time : " + instance);

        Instant instance2 = Instant.ofEpochSecond(3);
        System.out.println("Instant 2 : " + instance2);

        Instant instance3 = Instant.ofEpochSecond(3, 0);
        System.out.println("Instant 3 : " + instance3);

        Duration duration = Duration.between(instance, instance2);
        System.out.println("Duration : " + duration);

        Duration duration2 = Duration.of(3, DAYS);
        System.out.println("Duration 2 : " + duration2);

        Period period = Period.of(2021, 3, 1);
        System.out.println("Period : " + period);
    }
}
