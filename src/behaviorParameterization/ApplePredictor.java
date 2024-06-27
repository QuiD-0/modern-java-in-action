package behaviorParameterization;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public record ApplePredictor(
    List<Predicate<Apple>> predicates
) {
    public ApplePredictor() {
        this(new ArrayList<>());
    }

    public void addPredicate(Predicate<Apple> predicate) {
        predicates.add(predicate);
    }

    public boolean test(Apple apple) {
        return predicates.stream()
            .allMatch(predicate -> predicate.test(apple));
    }
}
