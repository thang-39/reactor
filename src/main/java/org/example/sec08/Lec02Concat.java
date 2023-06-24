package org.example.sec08;

import org.example.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec02Concat {
    public static void main(String[] args) {

        Flux<String> flux1 = Flux.just("a","b");
        Flux<String> flux2 = Flux.error(new RuntimeException("oops"));
        Flux<String> flux3 = Flux.just("c","d","e");


//        Flux<String> flux = flux1.concatWith(flux2);
        Flux<String> flux = Flux.concatDelayError(flux1, flux2, flux3);
        flux.subscribe(Util.subscriber());

    }
}
