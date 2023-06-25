package org.example.sec09;

import org.example.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec05GroupBy {
    public static void main(String[] args) {
        Flux.range(1,30)
                .delayElements(Duration.ofSeconds(1))
                .groupBy(i -> i % 2) // key 0, 1
                .subscribe(groupFlux -> process(groupFlux, groupFlux.key()));

        Util.sleepSeconds(40);
    }

    private static void process(Flux<Integer> flux, int key) {
        System.out.println("Called");
        flux.subscribe(i -> System.out.println("Key : " + key + ". Item : " + i));
    }
}
