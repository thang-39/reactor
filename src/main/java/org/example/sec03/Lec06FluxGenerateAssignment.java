package org.example.sec03;

import org.example.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

public class Lec06FluxGenerateAssignment {
    public static void main(String[] args) {

        // canada
        // max = 10
        // subscriber cancels - exit

        AtomicInteger atomicInteger = new AtomicInteger(0);

        Flux.generate(synchronousSink -> {
            String country = Util.faker().country().name();
            System.out.println("emitting " + country);
            synchronousSink.next(country);
            atomicInteger.incrementAndGet();
            if (country.equalsIgnoreCase("canada"))
                synchronousSink.complete();
        }).subscribe(Util.subscriber());
    }
}
