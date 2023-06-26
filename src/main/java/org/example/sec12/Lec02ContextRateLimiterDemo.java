package org.example.sec12;

import org.example.courseutil.Util;
import org.example.sec12.helper.BookService;
import org.example.sec12.helper.UserService;
import reactor.util.context.Context;

public class Lec02ContextRateLimiterDemo {
    public static void main(String[] args) {

        BookService.getBook()
                .repeat(2)
                .contextWrite(UserService.userCategoryContext())
                .contextWrite(Context.of("user","sam"))
                .subscribe(Util.subscriber());
    }
}
