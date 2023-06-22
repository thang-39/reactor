package org.example.sec04;

import org.example.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec03DoCallBack {
    public static void main(String[] args) {

        Flux.create(fluxSink -> {
            System.out.println("inside create");
            for (int i = 0; i < 5; i++) {
                fluxSink.next(i);
            }
            fluxSink.complete();
//            fluxSink.error(new RuntimeException("oops"));
            System.out.println("--completed");
        })
        .doOnComplete(() -> System.out.println("doOnComplete"))
        .doFirst(() -> System.out.println("doFirst 1"))
        .doOnNext(o -> System.out.println("doOnNext : " + o))
        .doOnSubscribe(s -> System.out.println("doOnSubscribe 1 : " + s))
        .doOnRequest(r -> System.out.println("doOnRequest : " + r))
            .doFirst(() -> System.out.println("doFirst 2"))
        .doOnError(err -> System.out.println("doOnError : " + err.getMessage()))
        .doOnTerminate(() -> System.out.println("doOnTerminate"))
        .doOnCancel(() -> System.out.println("doOnCancel"))
                .doOnSubscribe(s -> System.out.println("doOnSubscribe 2 : " + s))
        .doFinally((signal) -> System.out.println("doFinally 1 : " + signal))
            .doFirst(() -> System.out.println("doFirst 3"))
        .doOnDiscard(Object.class, o -> System.out.println("doOnDiscard : " + o ))
                .take(2)
                .doFinally((signal) -> System.out.println("doFinally 2 : " + signal))
        .subscribe(Util.subscriber());






    }
}
