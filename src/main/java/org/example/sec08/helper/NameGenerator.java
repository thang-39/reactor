package org.example.sec08.helper;

import org.example.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class NameGenerator {
    private List<String> list = new ArrayList<>();
    public Flux<String> generateName() {
        return Flux.generate(stringSynchronousSink -> {
            System.out.println("Generated fresh");
            Util.sleepSeconds(1);
            String name = Util.faker().name().firstName();
            list.add(name);
            stringSynchronousSink.next(name);
        })
                .cast(String.class)
                .startWith(getFromCache());
    }

    private Flux<String> getFromCache() {
        return Flux.fromIterable(list);
    }
}
