package concurrency;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentMap {
    public static void main(String[] args) {
        var map = new ConcurrentHashMap<String, Integer>();

        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        Integer reduce = map.reduce(1, (k, v) -> v, Integer::sum);
        String keys = map.reduceKeys(1, (k1, k2) -> k1 + k2);

        System.out.println(map);
        System.out.println("Reduce: " + reduce);
        System.out.println("Reduce keys: " + keys);

        map.forEach(1, (k, v) -> System.out.println(k + " -> " + v));
        String search = map.search(1, (k, v) -> v == 2 ? k : null);

        System.out.println("Search: " + search);
    }
}
