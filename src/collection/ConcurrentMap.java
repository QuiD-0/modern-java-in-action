package collection;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentMap {
    public static void main(String[] args) {
        var map = new ConcurrentHashMap<String, Integer>();
        map.put("A", 0);
        map.put("B", 1);
        map.forEach((key, value) -> System.out.println(key + " : " + value));

        Integer reduce = map.reduce(1, (key, value) -> value, Integer::sum);
        System.out.println("Reduce : " + reduce);

        Integer sum = map.reduceValues(1, Integer::sum);
        System.out.println("Sum : " + sum);

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                map.computeIfPresent("A", (key, value) -> value + 1);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                map.computeIfPresent("A", (key, value) -> value + 1);
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Map : " + map);

    }
}
