package behaviorParameterization;

import java.util.function.Predicate;

public class AppleColorPredictor implements Predicate<Apple> {

    @Override
    public boolean test(Apple apple) {
        return apple.color() == Color.RED;
    }
}
