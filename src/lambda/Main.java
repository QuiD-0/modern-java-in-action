package lambda;

import behaviorParameterization.Apple;

import java.util.Comparator;
import java.util.List;

import static behaviorParameterization.Color.GREEN;
import static behaviorParameterization.Color.RED;

public class Main {

    public static void main(String[] args) {

        Comparator<Apple> byWeight = (Apple a1, Apple a2) -> a1.weight() - a2.weight();
        Comparator<Apple> byWeight2 = (a1, a2) -> a1.weight() - a2.weight();
//        Comparator<Apple> byWeight = Comparator.comparingInt(Apple::weight);
//        Comparator<Apple> byWeight2 = Comparator.comparingInt(Apple::weight);

        Apple apple1 = new Apple(RED, 100);
        Apple apple2 = new Apple(GREEN, 200);

        System.out.println("TEST 1 :" + byWeight.compare(apple1, apple2));
        System.out.println("TEST 2 :" + byWeight2.compare(apple1, apple2));

        String message = "Hello World";
        List<Printer> printers = List.of(
            new Printer.StandardPrinter(),
            new Printer.ErrorPrinter(),
            System.out::println,
            (msg) -> System.err.println("Custom Printer : " + msg)
        );

        printers.forEach(printer -> printer.print(message));


    }
}
