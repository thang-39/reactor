package org.example.sec01;

import org.example.courseutil.Util;
import org.example.sec01.assignment.FileService;

public class Lec09AssignmentDemo {
    public static void main(String[] args) {
        FileService.read("file03.txt")
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());
//        FileService.write("file03.txt", "This is file3")
//                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());
        FileService.delete("file03.txt")
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());

    }
}
