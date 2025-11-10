package com.parrino.riccardo.vavr;

import io.vavr.Function2;
import io.vavr.Function3;
import io.vavr.control.Option;

public class Example {
    public static void main(String[] args) {
        LiftingExample.example();
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