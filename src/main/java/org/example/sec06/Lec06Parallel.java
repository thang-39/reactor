package org.example.sec06;

import org.example.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;

public class Lec06Parallel {
    public static void main(String[] args) {

        Flux.range(1,20)
                .parallel(4)
                .runOn(Schedulers.boundedElastic())
                .doOnNext(i -> printThreadName("next " + i))
                .sequential()
                .publishOn(Schedulers.parallel())
                .subscribe(v -> printThreadName("sub " + v));

        Util.sleepSeconds(5);
    }

    private static void printThreadName(String msg) {
        System.out.println(msg + "\t\t: Thread : " +Thread.currentThread().getName());
    }
}
