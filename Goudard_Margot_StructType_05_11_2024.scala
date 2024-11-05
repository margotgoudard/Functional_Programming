// Databricks notebook source
import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.col
import org.apache.spark.sql.types.{IntegerType, StringType, StructType}

val csvDataFile = "/FileStore/tables/stackoverflow.csv/stackoverflow.csv"

val schema = new StructType()
  .add("postTypeId", IntegerType, nullable = true)
  .add("id", IntegerType, nullable = true)
  .add("acceptedAnswer", StringType, nullable = true)
  .add("parentId", IntegerType, nullable = true)
  .add("score", IntegerType, nullable = true)
  .add("tag", StringType, nullable = true)

val df = spark.read
  .option("header", "false")
  .schema(schema)
  .csv(csvDataFile)
  .drop("acceptedAnswer")

println(s"\nCount of records in CSV file: ${df.count()}")
df.printSchema()
df.show(5)

// COMMAND ----------

import spark.implicits._

println("\nCount tag null: " + df.filter(col("tag").isNull).count())

// COMMAND ----------

df.createOrReplaceTempView("starckoverflow")
