package org.example.sec05.assignment;

import lombok.Data;
import org.example.sec05.assignment.PurchaseOrder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.time.Duration;
import java.util.*;

@Data
public class OrderService {
    private Flux<PurchaseOrder> flux;

    public Flux<PurchaseOrder> orderStream() {
        if (Objects.isNull(flux))
            flux = getOrderStream();
        return flux;
    }
    private Flux<PurchaseOrder> getOrderStream() {
        return Flux.interval(Duration.ofMillis(100))
                .map(i -> new PurchaseOrder())
                .publish()
                .refCount(2);
    }
}
