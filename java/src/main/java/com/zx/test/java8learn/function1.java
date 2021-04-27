package com.zx.test.java8learn;

import sun.security.util.Length;

import javax.swing.*;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class function1 {

    public static void main(String[] args) {
//        predicateLearn();
//        consumerLearn();
//        supplierLearn();
    }

    private static void consumerLearn() {
        Consumer<String> c = System.out::println;
        c.accept("hello lambda!");
    }

    private static void functionLearn() {
        Function<Integer,Integer> a = i -> i+1;
        Function<Integer,Integer> b = i -> i*i;
        Function<Number,Integer> c = i -> i.intValue()*i.intValue();
        Function<String, Integer> d = i -> i.length();
        System.out.println(a.apply(5));
        System.out.println(b.apply(5));
        System.out.println(a.compose(c).apply(5));
        System.out.println(c.compose(a).apply(5));
        System.out.println(a.compose(d).apply("5"));
        System.out.println(a.andThen(c).apply(5));
    }

    private static void predicateLearn() {
        Predicate<Integer> pd = a -> a > 2;
        Predicate<Integer> pd1 = a -> a > 4;
        System.out.println(pd.test(3));
        System.out.println(pd.negate().test(3));
        System.out.println(pd.and(pd1).test(3));
        System.out.println(pd.or(pd1).test(3));
        System.out.println(pd.test(3));
    }

    private static void supplierLearn() {
        Supplier<Integer> sp = () -> 5;
        System.out.println(sp.get());
    }

}
