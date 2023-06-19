package org.example.sec01;

import org.example.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec08MonoFromRunnable {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("");

        Mono.fromRunnable(timeConsumingProcess())
                .subscribe(Util.onNext(),
                        Util.onError(),
                        () -> {
                            System.out.println("process is done. Sending email ...");
                        });
    }

    private static Runnable timeConsumingProcess() {
        return () -> {
            Util.sleepSeconds(3);
            System.out.println("Operation completed");
        };
    }


}
