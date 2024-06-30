package stream;

import java.util.List;


public class ParallelStream {
    public static void main(String[] args) {
        List<Dish> menu = getDishes();

        // 1. 병렬 스트림
        List<Dish> parallelMenu = menu.parallelStream()
            .filter(dish -> dish.getCalories() > 300)
            .toList();
        System.out.println("Parallel Menu : " + parallelMenu);

        // 2. 병렬 스트림 성능
        long start = System.currentTimeMillis();
        List<Dish> parallelMenu2 = menu.parallelStream()
            .filter(dish -> dish.getCalories() > 300)
            .toList();
        System.out.println("Parallel Menu 2 : " + parallelMenu2);
        System.out.println("Elapsed Time : " + (System.currentTimeMillis() - start) + "ms");

        start = System.currentTimeMillis();
        List<Dish> sequentialMenu = menu.stream()
            .filter(dish -> dish.getCalories() > 300)
            .toList();
        System.out.println("Sequential Menu : " + sequentialMenu);
        System.out.println("Elapsed Time : " + (System.currentTimeMillis() - start) + "ms");
    }

    private static List<Dish> getDishes() {
        return List.of(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH)
        );
    }
}
