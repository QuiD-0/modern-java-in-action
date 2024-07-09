package completableFuture;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

import static java.util.concurrent.Executors.newVirtualThreadPerTaskExecutor;

public class CompletableFutureExample {
    public static void main(String[] args) {
        Task task1 = new Task("Task 1", 2000);
        Task task2 = new Task("Task 2", 1000);
        Task task3 = new Task("Task 3", 3000);

        List<String> stringStream = Stream.of(task1, task2, task3)
            .map(task -> CompletableFuture.supplyAsync(task::run, newVirtualThreadPerTaskExecutor()))
            .parallel()
            .map(CompletableFuture::join)
            .toList();

        System.out.println("All tasks are submitted");
        System.out.println("stringStream = " + stringStream);
    }
}
