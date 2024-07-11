package functional;

import completableFuture.Task;

import java.util.List;
import java.util.stream.Stream;

public class Lazy {
    public static void main(String[] args) {
        Task task1 = new Task("Task 1", 2000);
        Task task2 = new Task("Task 2", 1000);

        Stream<String> stringStream = Stream.of(task1, task2)
            .peek(System.out::println)
            .map(Task::run);

        System.out.println("stream is not executed yet");

        List<String> list = stringStream.toList();
        System.out.println("stream is executed now");
    }
}
