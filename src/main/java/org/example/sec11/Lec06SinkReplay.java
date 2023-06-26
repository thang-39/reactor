package org.example.sec11;

import org.example.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class Lec06SinkReplay {
    public static void main(String[] args) {
        Sinks.Many<Object> sink = Sinks.many().replay().all();

        // handle through subscribers will receive items
        Flux<Object> flux = sink.asFlux();




        sink.tryEmitNext("hi");
        sink.tryEmitNext("how are you");

        flux.subscribe(Util.subscriber("sam"));
        flux.subscribe(Util.subscriber("mike"));
        sink.tryEmitNext("?");

        flux.subscribe(Util.subscriber("jake"));
        sink.tryEmitNext("new msg");
    }
}
