package org.example.sec04;

import org.example.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec01Handle {
    public static void main(String[] args) {
        // handle = filter + map
//        Flux.range(1,20)
//                .handle((integer, synchronousSink) -> {
//                    if (integer % 2 == 0) // filter
//                        synchronousSink.next(integer);
//                    else
//                        synchronousSink.next(integer + "a"); //map
//                })
//                .subscribe(Util.subscriber());

//        Flux.range(1,20)
//                .handle((integer, synchronousSink) -> {
//                    if (integer == 7)
//                        synchronousSink.complete();
//                    else
//                        synchronousSink.next(integer);
//                })
//                .subscribe(Util.subscriber());

        Flux.generate(synchronousSink -> {
            String country = Util.faker().country().name();
            synchronousSink.next(country);
        })
                .handle((o, synchronousSink) -> {
                    if (o.toString().equalsIgnoreCase("canada"))
                        synchronousSink.complete();
                    else synchronousSink.next(o);
                })
                .subscribe(Util.subscriber());
    }
}
