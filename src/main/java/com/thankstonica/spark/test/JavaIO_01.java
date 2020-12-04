package com.thankstonica.spark.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by thankstonica on 2020/12/4.
 */
public class JavaIO_01 {
    public static void main(String[] args) throws FileNotFoundException {


        FileInputStream fis = new FileInputStream("");

        AtomicInteger atomicInteger = new AtomicInteger(0);
        int andIncrement = atomicInteger.incrementAndGet();


    }
}
