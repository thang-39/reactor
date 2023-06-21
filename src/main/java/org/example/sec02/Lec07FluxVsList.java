package org.example.sec02;

import org.example.courseutil.Util;
import org.example.sec02.helper.NameGenerator;

import java.util.List;

public class Lec07FluxVsList {
    public static void main(String[] args) {
        List<String> names = NameGenerator.getNames(5);
        System.out.println(names);

        NameGenerator.getNamesFlux(5)
                .subscribe(Util.onNext());

    }
}
