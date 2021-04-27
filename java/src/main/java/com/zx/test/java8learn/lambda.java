package com.zx.test.java8learn;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;

public class lambda {

    public static void main(String[] args) {

        String[] planets = new String[] {"A","B1","F4444","D333","C22"};
        System.out.println(Arrays.toString(planets));
        System.out.println("1:");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));
        System.out.println("2:");
        Arrays.sort(planets,(first,second) -> first.length() - second.length());
        System.out.println(Arrays.toString(planets));
//        Timer t = new Timer(1000, event ->
//                System.out.println("this time is :" + new Date()));
        Timer t = new Timer(1000, System.out::println);
                t.start();

        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);
    }

}
