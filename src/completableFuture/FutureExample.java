package completableFuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newVirtualThreadPerTaskExecutor;

public class FutureExample {
    public static void main(String[] args) {
        try (ExecutorService executorService = newVirtualThreadPerTaskExecutor()) {
            Task task1 = new Task("Task 1", 2000);
            Task task2 = new Task("Task 2", 1000);
            Task task3 = new Task("Task 3", 3000);

            java.util.concurrent.Future<String> submit = executorService.submit(task1::run);
            System.out.println("Task 1 is submitted");
            executorService.submit(task2::run);
            System.out.println("Task 2 is submitted");
            executorService.submit(task3::run);

            boolean done = submit.isDone();
            System.out.println("Task 1 is done : " + done);
            submit.get();
            System.out.println("Task 1 is done : " + submit.isDone());

            System.out.println("All tasks are submitted");
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
