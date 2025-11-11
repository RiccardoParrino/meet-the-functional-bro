package com.parrino.riccardo.vavr;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import io.vavr.Function2;
import io.vavr.Function3;
import io.vavr.control.Option;

public class Example {
    public static void main(String[] args) {
        System.out.println(OptionalJavaClassExample.exampleWithOptional2(10));
    }
}

class OptionalJavaClassExample {

    public static void example() {
        Optional<String> maybeFoo = Optional.ofNullable("temp");
        maybeFoo.ifPresent(value -> System.out.println(value));
        System.out.println(maybeFoo.orElse("notemp"));
        System.out.println(maybeFoo.orElseGet(() -> "1"));
        Optional<String> upper = Optional.of("java").map(String::toUpperCase);
    }

    public static Integer exampleWithoutOptional(Integer integer) {
        if (integer != null) {
            return integer + 3;
        }
        return null;
    }

    public static Integer exampleWithOptional(Integer integer) {
        return Optional.ofNullable(integer)
                .map((i) -> i + 3)
                .orElse(null);
    }

    public static Optional<Integer> exampleWithOptional2(Integer integer) {
        List<Integer> temps = new ArrayList<>();
        temps.add(1);
        temps.add(2);
        temps.add(3);
        temps.add(4);
        return Optional.ofNullable(
                temps.indexOf(integer) < 0 ? null : temps.indexOf(integer))
                .map((s) -> 2 * s);
    }

    public static Integer exampleWithOptional3(Integer integer) {
        List<Integer> temps = new ArrayList<>();
        temps.add(1);
        temps.add(2);
        temps.add(3);
        temps.add(4);
        return List.of((temps.indexOf(integer) < 0 ? null : temps.indexOf(integer)))
                .stream()
                .map((s) -> 2 * s)
                .collect(Collectors.toList())
                .get(0);
    }

}

class FunctionNExample {

    public static void f2example() {
        Function2<Integer, Integer, Integer> sum = (a, b) -> a + b;
        System.out.println(sum.apply(10, 11));
    }

    public static void f3example() {
        Function3<Integer, Integer, Integer, Integer> sum = (a, b, c) -> a + b + c;
        System.out.println(sum.apply(1, 2, 3));
    }

}

class LiftingExample {

    public static void example() {
        Function2<Integer, Integer, Integer> divide = (a, b) -> a / b;
        Function2<Integer, Integer, Option<Integer>> safeDivide = Function2.lift(divide);
        Option<Integer> i1 = safeDivide.apply(1, 0);
        Option<Integer> i2 = safeDivide.apply(4, 2);
        System.out.println(i1.isEmpty());
        System.out.println(i2.get());
    }

}