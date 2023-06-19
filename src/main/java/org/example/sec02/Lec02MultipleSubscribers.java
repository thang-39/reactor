package org.example.sec02;

import reactor.core.publisher.Flux;

public class Lec02MultipleSubscribers {
    public static void main(String[] args) {
        Flux<Integer> intFlux = Flux.just(1,2,3,4);

        Flux<Integer> evenFlux = intFlux.filter(i -> i % 2 == 0);

        intFlux
                .subscribe(i -> System.out.println("Sub 1 : " + i));
        evenFlux
                .subscribe(i -> System.out.println("Sub 2 : " + i));
    }
}
