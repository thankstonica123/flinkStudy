package com.thankstonica.spark.test

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by thankstonica on 2020/11/23.
  */
object WCSpark {

  def main(args: Array[String]): Unit = {


    val conf = new SparkConf()
    conf.setAppName("wc")
    conf.setMaster("local")
    val sc = new SparkContext(conf)

    val fileRDD = sc.textFile("data/data.txt")
    val flatRDD = fileRDD.flatMap(_.split(" "))
    val wordRDD = flatRDD.map((_,1))
    val res = wordRDD.reduceByKey(_+_)
    res.foreach(println)

    Thread.sleep(Long.MaxValue)



  }

}
