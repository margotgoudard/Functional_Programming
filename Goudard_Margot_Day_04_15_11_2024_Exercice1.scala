// Databricks notebook source
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._  // Import for col and other functions
import org.apache.log4j.{Level, Logger}

val filePath = "/FileStore/tables/people_data.csv"

val peopleDF = spark.read
  .option("header", "true")
  .option("inferSchema", "true")
  .csv(filePath)
  .cache() 

val filteredDF = peopleDF.filter(col("age") >= 25)

val transformedDF = filteredDF.select("name", "city")

val groupedDF = transformedDF.groupBy("city").agg(collect_list("name").as("names"))

groupedDF.show(false)

