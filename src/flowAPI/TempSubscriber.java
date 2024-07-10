package flowAPI;

import java.util.concurrent.Flow.Subscriber;

import static java.util.concurrent.Flow.Subscription;

public class TempSubscriber implements Subscriber<TempInfo> {

    @Override
    public void onSubscribe(Subscription subscription) {
        subscription.request(1);
    }

    @Override
    public void onNext(TempInfo item) {
        System.out.println(item);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println(throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("Done!");
    }
}
