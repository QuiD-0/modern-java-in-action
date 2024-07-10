package flowAPI;

public class Main {
    public static void main(String[] args) {
        TempSubscriber subscriber = new TempSubscriber();
        TempSubscription subscription = new TempSubscription(subscriber, "New York");

        subscriber.onSubscribe(subscription);
    }
}
