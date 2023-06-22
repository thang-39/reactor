package org.example.sec04;

import org.example.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec04LimitRate {
    public static void main(String[] args) {
        Flux.range(1,1000)
                .log()
                .limitRate(100, 0)
                .subscribe(Util.subscriber());
    }
}
