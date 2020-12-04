package com.thankstonica.spark.test

import org.apache.spark.rdd.RDD
import org.apache.spark.util.LongAccumulator
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by thankstonica on 2020/11/28.
  */
object testRDD {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("test").setMaster("local")
    val sc = new SparkContext(conf)



    val rdd1 = sc.parallelize(List(("zhangsan",1),("lise",2),("wangwu",3)))
    val rdd2 = sc.parallelize(List(("zhangsan",11),("lise",22),("wangwu",33)))
    val cogroupRDD = rdd1.cogroup(rdd2)
    cogroupRDD.foreach(println)

    println("=================================")

    val data: RDD[(String, Int)] = sc.parallelize(List(
      ("zhangsan", 234),
      ("zhangsan", 5667),
      ("zhangsan", 343),
      ("lisi", 212),
      ("lisi", 44),
      ("lisi", 33),
      ("wangwu", 535),
      ("wangwu", 22)
    ))

    val group: RDD[(String, Iterable[Int])] = data.groupByKey()
    group.foreach(println)

    println("=================================")
    val res01: RDD[(String, Int)] = group.flatMap(  e =>   e._2.map(    x=>(e._1,x)    ) .iterator    )
    res01.foreach(println)

    println("=================================")
    //  行列转换
    // (wangwu,CompactBuffer(535, 22))
    val res02: RDD[(String, Int)] = group.flatMap(  e =>   e._2.map(    x=>(e._1,x)    ) .iterator    )
    res02.foreach(println)

    println("######################################################")
    val data2: RDD[Int] = sc.parallelize(1 to 10,2)
    var n = 0
    val ox: LongAccumulator = sc.longAccumulator("ooxx")
    val count: Long = data2.map(x => {
      if(x%2==0) ox.add(1)  else ox.add(100)
      n+=1
      println(s"executor:n: $n")
      x
    }).count()
    println(s"count:  $count")
    println(s"Driver:n: $n")
    println(s"Driver:ox:${ox}")
    println(s"Driver:ox.avg:${ox.avg}")
    println(s"Driver:ox.sum:${ox.sum}")
    println(s"Driver:ox.count:${ox.count}")


    while(true){}
  }


}
