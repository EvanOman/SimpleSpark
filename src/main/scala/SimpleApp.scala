/* SimpleApp.scala */

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object SimpleApp
{
    def main(args: Array[String])
    {
        val logFile = "./dat.txt"
        val conf = new SparkConf().setAppName("Simple Application")
        val sc = new SparkContext(conf)
        val logData = sc.textFile(logFile, 2).cache
        val numAs = logData.filter(l => l.contains("a")).count
        val numBs = logData.filter(l => l.contains("b")).count
        println(s"Lines with a: $numAs, lines with b: $numBs")
    }
}

