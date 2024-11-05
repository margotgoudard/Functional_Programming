// Databricks notebook source
import org.apache.spark.sql.SparkSession
import org.apache.log4j.{Level,Logger}
    
val logFile = "/FileStore/tables/README.md/README.md"
val logData = spark.read.textFile(logFile).cache()

val numAs = logData.filter(line => line.contains("Spark")).count()
val numBs = logData.filter(line => line.contains("Scala")).count()
println(s"Lines with a: $numAs, Lines with b: $numBs")

