package org.example.sec03;

import org.example.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxGenerate {
    public static void main(String[] args) {
        Flux.generate(synchronousSink -> {
            String country = Util.faker().country().name();

            System.out.println("emitting");
            synchronousSink.next(country);
            if (country.equalsIgnoreCase("canada")) {
                synchronousSink.complete();
            }
            //synchronousSink.complete();
            //synchronousSink.error(new RuntimeException("oop"));

        })
                //.take(2)
                .subscribe(Util.subscriber());
    }
}
