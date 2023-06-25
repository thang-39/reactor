package org.example.sec09;

import org.example.courseutil.Util;
import org.example.sec09.assignment.OrderProcessor;
import org.example.sec09.assignment.OrderService;
import org.example.sec09.assignment.ProductOrder;
import reactor.core.publisher.Flux;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class Lec06Assignment {

    public static void main(String[] args) {
        Map<String, Function<Flux<ProductOrder>, Flux<ProductOrder>>> map = Map.of(
                "Kids", OrderProcessor.kidsProcessingWithMono(),
                "Automotive", OrderProcessor.automotiveProcessing()
        );

        Set<String> setKey = map.keySet();

        OrderService.orderStream()
                .filter(p -> setKey.contains(p.getCategory()))
                .groupBy(ProductOrder::getCategory)
                .flatMap(gf -> map.get(gf.key()).apply(gf))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }
}
