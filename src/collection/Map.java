package collection;

public class Map {
    public static void main(String[] args) {
        // 1. 맵
        new java.util.HashMap<String, Integer>() {{
            put("A", 1);
            put("B", 2);
            put("C", 3);
        }}.forEach((key, value) -> System.out.println(key + " : " + value));

        // 2. 맵의 기본 연산
        java.util.Map<String, Integer> map = new java.util.HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        System.out.println("Map : " + map);
        System.out.println("Map Size : " + map.size());
        System.out.println("Map Contains Key A : " + map.containsKey("A"));
        System.out.println("Map Contains Value 1 : " + map.containsValue(1));
        System.out.println("Map Get A : " + map.get("A"));
        System.out.println("Map Remove A : " + map.remove("A"));
        System.out.println("Map : " + map);
        map.clear();
        System.out.println("Map : " + map);

        // 3. ifAbsent
        map.put("A", 1);
        System.out.println("Map : " + map);
        System.out.println("Map GetOrDefault B : " + map.getOrDefault("B", 2));
        System.out.println("Map GetOrDefault A : " + map.getOrDefault("A", 2));
        System.out.println("Map : " + map);
        map.put("B", 2);
        System.out.println("Map : " + map);
        System.out.println("Map PutIfAbsent B : " + map.putIfAbsent("B", 3));
        System.out.println("Map : " + map);
        System.out.println("Map PutIfAbsent C : " + map.putIfAbsent("C", 3));
        System.out.println("Map : " + map);

        // 4. replace
        System.out.println("Map Replace A : " + map.replace("A", 1, 4));
        System.out.println("Map : " + map);

        // 5. compute
        System.out.println("Map Compute A : " + map.computeIfPresent("A", (key, value) -> value + 1));
        System.out.println("Map : " + map);
        System.out.println("Map Compute B : " + map.computeIfPresent("B", (key, value) -> value + 1));
        System.out.println("Map : " + map);

    }
}
