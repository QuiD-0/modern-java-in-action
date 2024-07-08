package completableFuture;

public record Task(String name, int duration) {

    public String run() {
        System.out.println("Task " + name + " is running");
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task " + name + " is done");
        return name;
    }
}
