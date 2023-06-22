package org.example.sec04;

import org.example.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.util.concurrent.Queues;

import java.time.Duration;

public class Lec05Delay {
    public static void main(String[] args) {
        System.setProperty("reactor.bufferSize.x", "9");
        Flux.range(1, 100)
                .log()
                .delayElements(Duration.ofSeconds(1))
                .subscribe(Util.subscriber());
        Util.sleepSeconds(60);
    }
}
