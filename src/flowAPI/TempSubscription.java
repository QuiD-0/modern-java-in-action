package flowAPI;

import java.util.concurrent.Flow.Subscription;
import java.util.stream.LongStream;

public class TempSubscription implements Subscription {

    private final TempSubscriber subscriber;
    private final String town;

    public TempSubscription(TempSubscriber subscriber, String town) {
        this.subscriber = subscriber;
        this.town = town;
    }

    @Override
    public void request(long n) {
        LongStream.range(0, n)
            .mapToObj(i -> TempInfo.fetch(town))
            .forEach(subscriber::onNext);
    }

    @Override
    public void cancel() {
        subscriber.onComplete();
    }
}
