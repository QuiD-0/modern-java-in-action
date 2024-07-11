package functional;

import java.util.stream.IntStream;

public class StreamConsume {
    public static void main(String[] args) {
        var stream = IntStream.range(0, 10).filter(i -> i % 2 == 0);

        stream.forEach(System.out::println);
        try {
            stream.forEach(System.out::println);
        } catch (IllegalStateException e) {
            System.out.println("IllegalStateException: " + e.getMessage());
        }
    }
}
