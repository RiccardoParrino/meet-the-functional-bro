package com.parrino.riccardo.recreatingVavr.function;

@FunctionalInterface
public interface Function1<T, R> {
    R apply(T t);
}
