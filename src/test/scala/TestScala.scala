/**
  * Created by thankstonica on 2020/11/21.
  */
object TestScala {
  def main(args: Array[String]): Unit = {


    println("hello world!")

    val listStr = List("hello java","hello spark")

    val itr = listStr.iterator

    //val itrFlatMap = itr.flatMap(_.split(" "))
    val itrFlatMap = itr.flatMap( (x:String) => x.split(" ") )

    //val tuples = itrFlatMap.map((_,1))
    val tuples = itrFlatMap.map((x:String) => (x,1))





  }


}
