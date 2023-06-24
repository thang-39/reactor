package org.example.sec09;

        import org.example.courseutil.Util;
        import reactor.core.publisher.Flux;

        import java.time.Duration;

public class Lec02OverlapAndDrop {
    public static void main(String[] args) {
        eventStream()
                .buffer(3,1)

                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }

    private static Flux<String> eventStream() {
        return Flux.interval(Duration.ofMillis(300))
//                .take(3)
                .map(i -> "event" + i);
    }
}
