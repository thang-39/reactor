package org.example.sec08;

import org.example.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntBinaryOperator;

public class Lec06AssignmentCarPriceOverTime {
    public static void main(String[] args) {
//        Flux.combineLatest(getCarPrice(), demand(), (i, d) -> (double) i * d)
//                .subscribe(Util.subscriber());

        final int carPrice = 10000;
        Flux.combineLatest(monthStream(), demand(), (month, demand) -> {
            return (carPrice - (month * 100)) * demand;
        }).subscribe(Util.subscriber());


//        monthStream().subscribe(Util.subscriber());

        Util.sleepSeconds(30);

    }

    private static Flux<Long> monthStream() {
        return Flux.interval(Duration.ZERO, Duration.ofSeconds(1));
    }

    private static Flux<Integer> getCarPrice() {
        AtomicInteger atomicInteger = new AtomicInteger(9000);
        return Flux.interval(Duration.ofSeconds(1))
                .map(i -> atomicInteger.getAndAdd(-100));
    }

    private static Flux<Double> demand() {
        return Flux.interval(Duration.ofSeconds(3))
                .map(i -> Util.faker().random().nextInt(8,12) / 10D)
                .startWith(1D);
    }
}
