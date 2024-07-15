package concurrency;

import java.util.List;
import java.util.Map;
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

        List<Request> requests = List.of(
            new Request("A", 10),
            new Request("B", 20),
            new Request("A", 30),
            new Request("B", 40),
            new Request("A", 50),
            new Request("B", 60),
            new Request("A", 70),
            new Request("B", 80),
            new Request("A", 90)
        );

        Map<String, Integer> totalMap = new ConcurrentHashMap<>();

        requests.stream()
            .parallel()
            .forEach(it -> totalMap.merge(it.name(), it.amount(), Integer::sum));

        System.out.println(totalMap);
    }

    private record Request(String name, int amount) {}

}
