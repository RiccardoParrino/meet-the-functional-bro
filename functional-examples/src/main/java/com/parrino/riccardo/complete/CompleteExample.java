package com.parrino.riccardo.complete;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.List;

public class CompleteExample {

    public static void main(String[] args) {
        Factorial.example();
    }

}

class Factorial {

    public static void example() {
        Function<Integer, Integer> identity = (n) -> {
            return n;
        };
        Function<Integer, Integer> doubled = (n) -> {
            return 2 * n;
        };
        BiFunction<Integer, Integer, Integer> sum = (a, b) -> a + b;

        System.out.println(sum.apply(10, 20));
        System.out.println(identity.apply(doubled.apply(sum.apply(10, 20))));
    }

    // haskell code is cleaner
    // identity n = n
    // doubled n = 2 * n
    // sumAB a b = a + b

    // main = do
    // print (sumAB 10 20)
    // print ((identity . doubled) (sumAB 10 20))

}

class MyExample {

    public static void example() {

        Supplier<String> mySupplier = () -> {
            return "temp";
        };

        Supplier<String> mySupplier2 = new Supplier<String>() {

            @Override
            public String get() {
                return new String("mySupplier2");
            }

        };

        mySupplier.get();

    }

}

class MyStreamExample {

    public static void example() {
        Integer integer = 3;
        List.of(1, 2).stream();
    }

}