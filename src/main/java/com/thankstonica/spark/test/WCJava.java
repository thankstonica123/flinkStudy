package com.thankstonica.spark.test;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;


import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by thankstonica on 2020/11/24.
 */
public class WCJava {

    public static void main(String[] args) {

        SparkConf conf = new SparkConf();
        conf.setAppName("wordcount");
        conf.setMaster("local");
        JavaSparkContext jsc = new JavaSparkContext(conf);

        JavaRDD<String> fileRDD = jsc.textFile("data/data.txt");





    }

}
