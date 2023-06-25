package org.example.sec09.assignment;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.courseutil.Util;
@Getter
@Setter
@ToString
public class ProductOrder {
    private String name;
    private String category;
    private Double price;

    public ProductOrder() {
        this.name = Util.faker().commerce().productName();
        this.category = Util.faker().commerce().department();
        this.price = Double.parseDouble(Util.faker().commerce().price());
    }
}
