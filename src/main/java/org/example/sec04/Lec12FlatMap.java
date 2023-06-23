package org.example.sec04;

import org.example.courseutil.Util;
import org.example.sec04.helper.OrderService;
import org.example.sec04.helper.UserService;

public class Lec12FlatMap {
    public static void main(String[] args) {
        UserService.getUser()
                .flatMap(user -> OrderService.getOrders(user.getUserId()))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }
}
