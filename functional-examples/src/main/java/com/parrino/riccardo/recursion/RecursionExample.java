package com.parrino.riccardo.recursion;

import java.util.function.Function;

public class RecursionExample {

    public static void main(String[] args) {
        SelfReferencingLambda.example();
    }

}

class RecursionProblemExample {

    // public static void example() {
    // Function<Integer, Integer> factorial = (n) -> {
    // if (n == 1 || n == 0)
    // return n;
    // else
    // return n * factorial.apply(n - 1);
    // };
    // }

}

class YCombinatorRecursionTrick {

    @FunctionalInterface
    interface RecursiveFunction<T, R> {
        public R apply(RecursiveFunction<T, R> self, T t);
    }

    public static void example() {
        RecursiveFunction<Integer, Integer> factorial = (self, n) -> {
            if (n == 1 || n == 0) {
                return n;
            } else {
                return n * self.apply(self, n - 1);
            }
        };

        Integer res = factorial.apply(factorial, 5);
        System.out.println(res);
    }

}

class SelfReferencingLambda {

    public static <T, R> Function<T, R> recursive(Function<Function<T, R>, Function<T, R>> f) {
        return t -> f.apply(recursive(f)).apply(t);
    }

    public static void example() {
        Function<Integer, Integer> factorial = recursive(self -> n -> {
            if (n <= 1)
                return 1;
            return n * self.apply(n - 1);
        });
        System.out.println(factorial.apply(5));
    }

}

class OneLineYCombinatorTrickRecursion {

    public static void example(String[] args) {
        // Y combinator for recursion
        // Function<Function<Function<Integer, Integer>, Function<Integer, Integer>>,
        // Function<Integer, Integer>> Y = f -> ((Function<Function<Integer, Integer>,
        // Function<Integer, Integer>>) x -> f
        // .apply(y -> x.apply(x).apply(y)))
        // .apply(x -> f.apply(y -> x.apply(x).apply(y)));

        // // Define factorial using the Y combinator
        // Function<Integer, Integer> factorial = Y.apply(self -> n -> (n <= 1) ? 1 : n
        // * self.apply(n - 1));
    }

}

class ClassicExample {

    @FunctionalInterface
    interface FunctionNext<T> {
        public FunctionNext<T> call(FunctionNext<T> t);
    }

    public static void example() {
        // FunctionNext<Integer> fun = (t) -> t * 2;
    }

}