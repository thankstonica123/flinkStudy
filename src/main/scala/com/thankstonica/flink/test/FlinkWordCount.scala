package com.thankstonica.flink.test

import org.apache.flink.api.java.functions.KeySelector
import org.apache.flink.streaming.api.scala._
import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment}

/**
  * Created by thankstonica on 2020/11/14.
  */
object FlinkWordCount {
  def main(args: Array[String]): Unit = {

    /**
      * 准备环境
      */
    val env = StreamExecutionEnvironment.getExecutionEnvironment

    val initStream:DataStream[String] = env.socketTextStream("s1",8888)

    val wordStream = initStream.flatMap(_.split(" "))

    val pairStream = wordStream.map((_,1))

    val keyByStream = pairStream.keyBy(_._1)

    val resultStream = keyByStream.sum(1)

    resultStream.print()

    // 启动任务
    env.execute("FlinkWordCount")




  }

}































