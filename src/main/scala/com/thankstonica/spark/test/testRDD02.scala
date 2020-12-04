package com.thankstonica.spark.test

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.parallel.mutable

/**
  * Created by thankstonica on 2020/12/4.
  */
object testRDD02 {
  def main(args: Array[String]): Unit = {

    val conf: SparkConf = new SparkConf().setMaster("local").setAppName("topN")
    val sc = new SparkContext(conf)
    sc.setLogLevel("ERROR")


    val data: RDD[String] = sc.parallelize(List(
      "hello world",
      "hello spark",
      "hello world",
      "hello hadoop",
      "hello world",
      "hello msb",
      "hello world"
    ))



  }

}
