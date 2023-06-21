package org.example.sec03;

import org.example.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec01FluxCreate {
    public static void main(String[] args) {
//        Flux.create(fluxSink -> {
//
//            fluxSink.next(1);
//            fluxSink.next(2);
//            fluxSink.complete();
//
//        }).subscribe(Util.subscriber());

        Flux.create(fluxSink -> {
            String country;
            do {
                country = Util.faker().country().name();
                fluxSink.next(country);
            } while (!country.equalsIgnoreCase("canada"));
            fluxSink.complete();
        }).subscribe(Util.subscriber());
    }
}
