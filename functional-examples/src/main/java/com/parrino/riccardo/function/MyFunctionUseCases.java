package com.parrino.riccardo.function;

import java.util.function.Function;

public class MyFunctionUseCases {

    public static void main(String[] args) {
        FirstFunctionUseCases.example();
    }

}

class SecurityFunction implements Function<String, String> {

    @Override
    public String apply(String t) {
        return "SecurityFunction";
    }

}

class FirstFunctionUseCases {

    class Pipeline {
        public static Function<String, String> start(Function<String, String> function) {
            return function;
        }
    }

    public static void example() {
        Function<String, String> process = Pipeline.start(s -> {
            System.out.println(s);
            return "first";
        }).andThen(s -> {
            System.out.println(s);
            return "second";
        }).andThen(s -> {
            System.out.println(s);
            return "third";
        }).andThen(new SecurityFunction());

        process.apply("meet functional bro");

    }

}