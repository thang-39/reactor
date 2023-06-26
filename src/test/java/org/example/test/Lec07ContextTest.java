package org.example.test;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import reactor.test.StepVerifierOptions;
import reactor.util.context.Context;

public class Lec07ContextTest {

    @Test
    public void test1() {
        StepVerifier.create(getWelcomeMessage())
                .verifyError(RuntimeException.class);
    }

    @Test
    public void test2() {

        StepVerifierOptions opt = StepVerifierOptions.create().withInitialContext(Context.of("user", "sam"));

        StepVerifier.create(getWelcomeMessage(),opt)
                .expectNext("Welcome sam")
                .verifyComplete();
    }



    private Mono<String> getWelcomeMessage() {
        return Mono.deferContextual(ctx -> {
            if (ctx.hasKey("user")) {
                return Mono.just("Welcome " + ctx.get("user"));
            } else
                return Mono.error(new RuntimeException("unauthenticated"));
        });
    }
}
