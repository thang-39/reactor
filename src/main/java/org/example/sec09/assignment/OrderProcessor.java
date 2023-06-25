package org.example.sec09.assignment;

import reactor.core.publisher.Flux;

import java.util.function.Function;

public class OrderProcessor {

    public static Function<Flux<ProductOrder>, Flux<ProductOrder>> automotiveProcessing() {
        return flux -> flux
                .doOnNext(p -> p.setPrice(1.1 * p.getPrice()))
                .doOnNext(p -> p.setName("{{ " + p.getName() + "}}"));
    }

    public static Function<Flux<ProductOrder>, Flux<ProductOrder>> kidsProcessing() {
        return flux -> flux
                .doOnNext(p -> p.setPrice(.5 * p.getPrice()))
                .flatMap(p -> Flux.just(p, getFreeKidsOrder()));
    }

    private static ProductOrder getFreeKidsOrder() {
        ProductOrder productOrder = new ProductOrder();
        productOrder.setPrice((double) 0);
        productOrder.setName("FREE - " + productOrder.getName());
        productOrder.setCategory("Kids");
        return productOrder;

    }
}
