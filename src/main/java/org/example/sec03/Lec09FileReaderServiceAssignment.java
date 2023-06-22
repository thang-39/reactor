package org.example.sec03;

import org.example.courseutil.Util;
import org.example.sec03.assignment.FileReaderService;

public class Lec09FileReaderServiceAssignment {
    public static void main(String[] args) {

        FileReaderService.read("file01.txt")
                .map(s -> {
                    Integer integer = Util.faker().random().nextInt(0,10);
                    if (integer > 8)
                        throw new RuntimeException("poop");
                    return s;
                })
                .take(12)
                .subscribe(Util.subscriber());


    }
}
