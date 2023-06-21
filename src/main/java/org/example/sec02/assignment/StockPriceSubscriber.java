package org.example.sec02.assignment;

import org.example.courseutil.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StockPriceSubscriber {
    public static void main(String[] args) {
        StockPricePublisher pub = new StockPricePublisher();
        Stack<Integer> list = new Stack<>();

        while (true) {
            pub.publishPrice().subscribe(
                    price -> {
                        if (price > 100) {
                            System.out.println(price);
                            list.push(price);

                        }
                    },
                    Util.onError(),
                    Util.onComplete()
            );
            if (!list.empty() && list.peek() > 100) {
                return;
            }

            Util.sleepSeconds(100);
        }



    }
}
