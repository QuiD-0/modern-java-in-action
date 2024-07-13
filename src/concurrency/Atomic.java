package concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Atomic {
    public static void main(String[] args) {

        Counter counter = new Counter();
        NonAtomicCounter nonAtomicCounter = new NonAtomicCounter();

        IntStream.range(0, 1000)
            .parallel()
            .forEach(i -> {
                counter.increment();
                nonAtomicCounter.increment();
            });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Atomic counter: " + counter.getCount());
        System.out.println("Non-atomic counter: " + nonAtomicCounter.getCount());

    }

    static class Counter {
        private final AtomicInteger count = new AtomicInteger(0);

        public void increment() {
            count.incrementAndGet();
        }

        public int getCount() {
            return count.get();
        }
    }

    static class NonAtomicCounter {
        private int count = 0;

        public void increment() {
            ++count;
        }

        public int getCount() {
            return count;
        }
    }
}
