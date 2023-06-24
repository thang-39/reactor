package org.example.sec08;

import org.example.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;

public class Lec04Zip {

    public static void main(String[] args) {

        Flux.zip(getBody(),getTire(),getEngine())
                .doOnNext(tuple3 -> System.out.println(Arrays.toString(tuple3.toArray())))
                .subscribe(Util.subscriber());
    }

    private static Flux<String> getBody() {
        return Flux.range(1,5)
                .map(i -> "body");
    }

    private static Flux<String> getEngine() {
        return Flux.range(1,2)
                .map(i -> "engine");
    }

    private static Flux<String> getTire() {
        return Flux.range(1,6)
                .map(i -> "tires");
    }
}
