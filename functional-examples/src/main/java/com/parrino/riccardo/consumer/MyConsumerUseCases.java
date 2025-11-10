package com.parrino.riccardo.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MyConsumerUseCases {

    public static void main(String[] args) {
        PipelineExample.example();
    }

}

class ConsumerAndThenExample {

    public static void example() {
        Consumer<String> printLower = s -> System.out.println(s.toLowerCase());
        Consumer<String> printUpper = s -> System.out.println(s.toUpperCase());
        Consumer<String> printTrim = s -> System.out.println(s.trim());

        List<Consumer<String>> consumers = new ArrayList<>();

        // Consumer<String> printMiddle = new Consumer<String>() {

        // @Override
        // public void accept(String t) {
        // // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'accept'");
        // }

        // };

        // Consumer<String> pipeline =
        // printLower.andThen(printUpper).andThen(printTrim);

        printLower
                .andThen(s -> System.out.println("trim"))
                .andThen(s -> System.out.println("replace"))
                .andThen(s -> System.out.println("split")).accept("Meet Functional Bro");

    }

}

class ConsumerCombined {

    public static void example() {
        Consumer<String> consumers = (s -> {
            System.out.println("original");
        });
    }

}

class ConsumerList {

    private List<Consumer<String>> list = new ArrayList<>();

    public ConsumerList addConsumer(Consumer<String> consumer) {
        this.list.add(consumer);
        return this;
    }

    public List<Consumer<String>> getList() {
        return this.list;
    }

}

class Pipeline {

    private ConsumerList consumers = new ConsumerList();

    public void execute(String input) {
        List<Consumer<String>> consumersList = consumers.getList();
        Consumer<String> pipeline = consumersList
                .stream()
                .reduce(s -> {
                }, Consumer::andThen);

        pipeline.accept(input);
    }

    public ConsumerList getConsumers() {
        return this.consumers;
    }

}

class PipelineExample {

    public static void example() {
        Pipeline pipeline = new Pipeline();

        pipeline.getConsumers()
                .addConsumer(s -> {
                    System.out.println("first");
                }).addConsumer(s -> {
                    System.out.println("second");
                }).addConsumer(s -> {
                    System.out.println("third");
                });

        pipeline.execute("temp");
    }

}

class ConsumerListReduce {

    public static void example() {
        List<Consumer<String>> consumers = new ArrayList<>();

        consumers.add(s -> {
            System.out.println("strip");
        });

        consumers.add(s -> {
            System.out.println("split");
        });

        consumers.add(s -> {
            System.out.println("stream");
        });

        consumers.add(s -> {
            System.out.println("capitalize");
        });

        Consumer<String> pipeline = consumers
                .stream()
                .reduce(s -> {
                    System.out.println("original");
                }, Consumer::andThen);

        pipeline.accept("ChatGPT");
    }

}