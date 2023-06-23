package org.example.sec05;

import org.example.courseutil.Util;
import org.example.sec05.assignment.InventoryService;
import org.example.sec05.assignment.OrderService;
import org.example.sec05.assignment.RevenueService;

public class Lec06Assignment {
    public static void main(String[] args) {

        OrderService orderService = new OrderService();
        RevenueService revenueService = new RevenueService();
        InventoryService inventoryService = new InventoryService();

        //revenue and inventory - observe the order service
        orderService.orderStream().subscribe(revenueService.subscribeOrderStream());
        orderService.orderStream().subscribe(inventoryService.subscribeOrderStream());

        inventoryService.inventoryStream()
                .subscribe(Util.subscriber("inventory"));
        revenueService.revenueStream()
                .subscribe(Util.subscriber("revenue"));

        Util.sleepSeconds(60);
    }
}
