package concurrency;

import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

public class Adder {
    public static void main(String[] args) {
        LongAdder adder = new LongAdder();

        IntStream.range(0, 1000)
            .parallel()
            .forEach(i -> adder.add(10));

        System.out.println("Adder: " + adder.sum());

        LongAccumulator accumulator = new LongAccumulator(Long::max, Long.MIN_VALUE);

        IntStream.range(0, 1000)
            .parallel()
            .forEach(accumulator::accumulate);

        System.out.println("Accumulator: " + accumulator.get());
    }
}
