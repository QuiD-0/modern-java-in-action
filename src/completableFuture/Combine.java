package completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Combine {
    public static void main(String[] args) {
        Task task1 = new Task("Task 1", 2000);
        Task task2 = new Task("Task 2", 1000);

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(task1::run);
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(task2::run);

        try {
            String result = future1.thenCombine(future2, (result1, result2) -> {
                System.out.println("Task 1 and Task 2 are done");
                return result1 + " " + result2;
            }).get();

            System.out.println("Combined result: " + result);

        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

    }
}
