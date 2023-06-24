package org.example.sec09.helper;

import lombok.Getter;
import lombok.ToString;
import org.example.courseutil.Util;

@Getter
@ToString
public class BookOrder {
    private String title;
    private String author;
    private String category;
    private Double price;

    public BookOrder() {
        this.title = Util.faker().book().title();
        this.author = Util.faker().book().author();
        this.category = Util.faker().book().genre();
        this.price = Double.parseDouble(Util.faker().commerce().price());
    }
}
