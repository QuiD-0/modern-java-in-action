package behaviorParameterization;

import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Apple apple = new Apple(Color.RED, 100);
        AppleColorPredictor appleColorPredictor = new AppleColorPredictor();
        System.out.println("TEST 1 :" + appleColorPredictor.test(apple));

        List<Apple> apples = List.of(
            new Apple(Color.RED, 100),
            new Apple(Color.GREEN, 200),
            new Apple(Color.RED, 300)
        );

        List<Apple> list = apples.stream()
            .filter(appleColorPredictor)
            .toList();
        System.out.println("TEST 2 :" + list);

        List<Apple> list2 = apples.stream()
            .filter(apple1 -> apple1.color() == Color.RED)
            .toList();
        System.out.println("TEST 3 :" + list2);

        List<Apple> list3 = apples.stream()
            .filter(new Predicate<Apple>() {
                @Override
                public boolean test(Apple apple) {
                    return apple.weight() > 150;
                }
            })
            .toList();
        System.out.println("TEST 4 :" + list3);
    }
}
