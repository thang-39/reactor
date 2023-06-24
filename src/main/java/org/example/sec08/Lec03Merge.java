package org.example.sec08;

import org.example.courseutil.Util;
import org.example.sec08.helper.AmericaAirlines;
import org.example.sec08.helper.Emirates;
import org.example.sec08.helper.Qatar;
import reactor.core.publisher.Flux;

public class Lec03Merge {
    public static void main(String[] args) {
        Flux<String> merge = Flux.merge(
                Qatar.getFlights(),
                Emirates.getFlights(),
                AmericaAirlines.getFlights()
        );

        merge.subscribe(Util.subscriber());
        Util.sleepSeconds(10);
    }
}
