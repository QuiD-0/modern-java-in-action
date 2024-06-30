package stream;

import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Dish> menu = getDishes();

        // 1. 필터링
        List<Dish> vegetarianDishes = menu.stream()
            .filter(Dish::isVegetarian)
            .toList();
        System.out.println("Vegetarian Dishes : " + vegetarianDishes);

        // 2. 중복 제거
        List<Integer> numbers = List.of(1, 2, 1, 3, 3, 2, 4);
        List<Integer> uniqueNumbers = numbers.stream()
            .distinct()
            .toList();
        System.out.println("Unique Numbers : " + uniqueNumbers);

        // 3. 슬라이싱
        List<Dish> dishesLimit3 = menu.stream()
            .limit(3)
            .toList();
        System.out.println("Dishes Limit 3 : " + dishesLimit3);

        List<Dish> dishesSkip2 = menu.stream()
            .skip(2)
            .toList();
        System.out.println("Dishes Skip 2 : " + dishesSkip2);

        // 4. 매핑
        List<String> dishNames = menu.stream()
            .map(Dish::getName)
            .toList();
        System.out.println("Dish Names : " + dishNames);

        List<Integer> dishNameLengths = menu.stream()
            .map(Dish::getName)
            .map(String::length)
            .toList();
        System.out.println("Dish Name Lengths : " + dishNameLengths);

        // 5. 요소 검색
        if (menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("The menu is (somewhat) vegetarian friendly!!");
        }

        if (menu.stream().allMatch(dish -> dish.getCalories() < 1000)) {
            System.out.println("The menu is healthy!!");
        }

        // 6. takeWhile, dropWhile
        List<Dish> specialMenu = getDishes();

        List<Dish> filteredMenu = specialMenu.stream()
            .takeWhile(dish -> dish.getCalories() < 320)
            .toList();
        System.out.println("Filtered Menu : " + filteredMenu);

        List<Dish> slicedMenu = specialMenu.stream()
            .dropWhile(dish -> dish.getCalories() < 320)
            .toList();
        System.out.println("Sliced Menu : " + slicedMenu);

        // 7. 스트림 연결
        List<Dish> dishes = menu.stream()
            .filter(dish -> dish.getCalories() > 300)
            .toList();
        List<Dish> specialDishes = specialMenu.stream()
            .filter(dish -> dish.getCalories() > 300)
            .toList();
        List<Dish> allDishes = Stream.of(dishes, specialDishes)
            .flatMap(List::stream)
            .toList();
        System.out.println("All Dishes : " + allDishes);

        // 8. 요소의 합
        int calories = menu.stream()
            .map(Dish::getCalories)
            .reduce(0, Integer::sum);
        System.out.println("Total Calories : " + calories);

        int calories2 = menu.stream()
            .mapToInt(Dish::getCalories)
            .sum();
        System.out.println("Total Calories : " + calories2);

        // 9. 최대값과 최소값
        Dish mostCaloricDish = menu.stream()
            .reduce((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2)
            .orElse(null);
        System.out.println("Most Caloric Dish : " + mostCaloricDish);

        // 10. 요소의 개수
        long count = menu.stream()
            .filter(Dish::isVegetarian)
            .count();
        System.out.println("Dish Count : " + count);

        // 11.무한 스트림
        List<Integer> list = Stream.iterate(0, n -> n + 2)
            .limit(10)
            .toList();
        System.out.println("List : " + list);
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
