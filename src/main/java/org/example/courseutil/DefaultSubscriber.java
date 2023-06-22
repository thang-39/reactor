package org.example.courseutil;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
@NoArgsConstructor
public class DefaultSubscriber implements Subscriber<Object> {

    private String name = "";

    public DefaultSubscriber(String name) {
        this.name = name+ " - ";
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        subscription.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(Object o) {
        String thread = Thread.currentThread().getName();
        System.out.println(name + "(" + thread + ") " + "Received : " + o);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println(name + "ERROR : " + throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println(name + "Completed");
    }
}
