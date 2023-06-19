package org.example.sec02;

import org.example.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec01FluxIntro {
    public static void main(String[] args) {

//        Flux<Integer> flux = Flux.just(1,2,3,4);
        Flux<Object> flux = Flux.just(1,2,3,"a",Util.faker().name().fullName());
//        Flux<Integer> flux = Flux.empty();

        flux.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete());

    }
}
