// Databricks notebook source
import org.apache.spark.sql.SparkSession
import org.apache.log4j.{Level,Logger}
    
val logFile = "/FileStore/tables/stackoverflow.csv/stackoverflow.csv"
val logData = spark.read
    .option("header", "false")
    .option("inferSchema", "true")
    .csv(logFile).cache()

val lineCount = logData.count()

println(s"Number of lines in the file: $lineCount")


// COMMAND ----------

logData.printSchema()

// COMMAND ----------

logData.show()
