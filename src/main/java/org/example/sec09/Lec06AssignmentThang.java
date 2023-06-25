package org.example.sec09;

import org.example.courseutil.Util;
import org.example.sec09.assignment.ProductOrder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class Lec06AssignmentThang {
    public static void main(String[] args) {
        orderStream()
                .groupBy(i -> i.getCategory())

                .subscribe(gf -> process(gf,gf.key()));

        Util.sleepSeconds(60);
    }

    private static Flux<ProductOrder> orderStream() {
        return Flux.interval(Duration.ofMillis(100))
                .map(i -> new ProductOrder());
    }

    private static void process(Flux<ProductOrder> flux, String key) {
        if (key.equals("Kids")) {
            flux
                    .doOnNext((i) -> System.out.println(new ProductOrder()))
                    .subscribe(i -> {
                  System.out.println("Key : " + i.getCategory() + ". Price with 50% discount : " + i.getPrice()/2);

            });
        } else if (key.equals("Automotive")) {
            flux.subscribe(i -> {
                System.out.println("Key : " + i.getCategory() + ". Price with 10% tax : " + i.getPrice()*1.1);
                System.out.println(i.getName() + " is packed");
            });
        }
    }

    private static Mono<ProductOrder> freeGift() {
        return Mono.just(new ProductOrder());
    }

}
