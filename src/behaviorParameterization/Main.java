package behaviorParameterization;

import java.util.List;

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

        List<Apple> list1 = apples.stream()
            .filter(appleColorPredictor)
            .toList();
        System.out.println("TEST 2 :" + list1);

        List<Apple> list2 = apples.stream()
            .filter(apple1 -> apple1.color() == Color.RED)
            .toList();
        System.out.println("TEST 3 :" + list2);

        List<Apple> list3 = apples.stream()
            .filter(apple12 -> apple12.weight() > 150)
            .toList();
        System.out.println("TEST 4 :" + list3);

        ApplePredictor applePredictor = new ApplePredictor();
        applePredictor.addPredicate(apple1 -> apple1.weight() < 150);
        applePredictor.addPredicate(apple1 -> apple1.color() == Color.RED);
        List<Apple> list4 = apples.stream()
            .filter(applePredictor::test)
            .toList();
        System.out.println("TEST 5 :" + list4);
    }
}
