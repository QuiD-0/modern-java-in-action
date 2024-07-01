package time;

import java.time.Instant;

public class Time {
    public static void main(String[] args) {
        Instant instance = Instant.now();
        System.out.println("Current Time : " + instance);

        Instant instance2 = Instant.ofEpochSecond(3);
        System.out.println("Instant 2 : " + instance2);

        Instant instance3 = Instant.ofEpochSecond(3, 0);
        System.out.println("Instant 3 : " + instance3);
    }
}
