package functional;

import java.util.function.Function;

public class IsOver50Text implements Function<String, Boolean> {

    public static void main(String[] args) {
        IsOver50Text isOver50Text = new IsOver50Text();
        System.out.println(isOver50Text.apply("This is a long text that is over 50 characters long"));
        System.out.println(isOver50Text.apply("This is a short text"));
    }

    @Override
    public Boolean apply(String s) {
        return s.length() > 50;
    }
}
