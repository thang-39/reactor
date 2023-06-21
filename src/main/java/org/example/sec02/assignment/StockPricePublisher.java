package org.example.sec02.assignment;

import org.example.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class StockPricePublisher {
    public static Random rand = new Random();
    public Flux<Integer> publishPrice() {
        return Flux.interval(Duration.ofSeconds(1))
                .map(i -> rand.nextInt(200));
    }

    public static Flux<Integer> getPrice() {
        AtomicInteger atomicInteger = new AtomicInteger(100);
        return Flux.interval(Duration.ofSeconds(1))
                .map(i -> atomicInteger.getAndAccumulate(
                        Util.faker().random().nextInt(-5,5),
                        (a, b) -> a + b
                ));
    }
}
