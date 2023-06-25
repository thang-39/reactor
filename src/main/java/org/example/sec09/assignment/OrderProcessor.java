package org.example.sec09.assignment;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

    public static Function<Flux<ProductOrder>, Flux<ProductOrder>> kidsProcessingWithMono() {
        return flux -> flux
                .doOnNext(p -> p.setPrice(.5 * p.getPrice()))
                .flatMap(p -> Flux.concat(Mono.just(p), getFreeKidsOrderMono()));
    }

    private static Mono<ProductOrder> getFreeKidsOrderMono() {
        return Mono.fromSupplier(() -> {
            ProductOrder productOrder = new ProductOrder();
            productOrder.setPrice((double) 0);
            productOrder.setName("FREE - " + productOrder.getName());
            productOrder.setCategory("Kids");
            return productOrder;
        });
    }

    private static ProductOrder getFreeKidsOrder() {
        ProductOrder productOrder = new ProductOrder();
        productOrder.setPrice((double) 0);
        productOrder.setName("FREE - " + productOrder.getName());
        productOrder.setCategory("Kids");
        return productOrder;
    }
}
