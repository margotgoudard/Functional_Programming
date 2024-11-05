// Databricks notebook source
// MAGIC %md
// MAGIC ### Functions
// MAGIC - Expressions which have parameters and take arguments
// MAGIC
// MAGIC anonymous functions

// COMMAND ----------

(x: Int) => x+1

// COMMAND ----------

// MAGIC %md
// MAGIC ### Functions with name

// COMMAND ----------

val addOne = (x: Int) => x + 1
println(addOne(1))

// COMMAND ----------

// MAGIC %md
// MAGIC Functions with multiple parameters

// COMMAND ----------

val add = (x: Int, y: Int) => x + y 
println(add(1,2))

// COMMAND ----------

// MAGIC %md
// MAGIC Functions without parameters

// COMMAND ----------

val getTheAnswer = () => 42
println(getTheAnswer())

// COMMAND ----------

// MAGIC %md
// MAGIC ### Methods
// MAGIC
// MAGIC - defined with the def keyword
// MAGIC - def is followed by: 
// MAGIC   - name 
// MAGIC   - parameter list
// MAGIC   - return type and body

// COMMAND ----------

def add = (x: Int, y: Int) => x + y 
println(add(1,2))

// COMMAND ----------

// MAGIC %md
// MAGIC method can take multiples parameters

// COMMAND ----------

def addThenMultiply(x: Int, y: Int)(multiplier: Int): Int = (x + y) * multiplier
println(addThenMultiply(1,2)(3))

// COMMAND ----------

// MAGIC %md
// MAGIC method can take any parameter

// COMMAND ----------

def name: String = System.getProperty

// COMMAND ----------

// MAGIC %md
// MAGIC ### Classes
// MAGIC - a class can be defined with the class keyword, followed by its name and constructor parameters

// COMMAND ----------

class Greeter(prefix: String, suffix: String) {
  def greet(name: String): Unit = 
    println(prefix + name + suffix)
}

// COMMAND ----------

// MAGIC %md
// MAGIC the return type of the method greet is Unit => nothing to return

// COMMAND ----------

val greeter = new Greeter("Hello", "!")
greeter.greet("Scala developer")

// COMMAND ----------

// MAGIC %md
// MAGIC ### Case Classes
// MAGIC - by default, instances of case classes are immutable
// MAGIC - case classes are comapred by value (unlike classes, whose instances are comapred by reference)
// MAGIC - this makes them useful for mattern machine
// MAGIC - case classe can be defined with the case class keywords

// COMMAND ----------

case class Point(x: Int, y:Int)

// COMMAND ----------

// MAGIC %md
// MAGIC we can instancies without the new keyword

// COMMAND ----------

val point = Point(1,2)
val anotherPoint = Point(2,3)

// COMMAND ----------

// MAGIC %md
// MAGIC instances of case classes are comapred by value not by reference

// COMMAND ----------

if (point == anotherPoint){
  println(s"$point and $anotherPoint are the same")
}
else {
  println(s"$point and $anotherPoint are different")
}

// COMMAND ----------

// MAGIC %md
// MAGIC ### Objects
// MAGIC - single instances of their own defintion

// COMMAND ----------

object idFactory {
  private var counter = 0
  def create(): Int = {
    counter +=1
    counter
  }
}

// COMMAND ----------

// MAGIC %md
// MAGIC we can access an object by referring to its name

// COMMAND ----------

val newId: Int = idFactory.create()
println(newId)
val newerId: Int = idFactory.create()
println(newerId)

// COMMAND ----------

// MAGIC %md
// MAGIC ### Traits
// MAGIC - abstract data types containing certain fields and methods
// MAGIC - in scala inheritance, a class can only extend one other class, but it can extend mutliple traits
// MAGIC
// MAGIC we can define trait with the keyword

// COMMAND ----------

trait Greeter {
  def greet(name: String): Unit
}

// COMMAND ----------

// MAGIC %md
// MAGIC - traits can have default implementation
// MAGIC - we can extend traits with the extends keyword and override an implementation with the override keyword

// COMMAND ----------

class DefaultGreeter extends Greeter 

class CustomGreeter(prefix: String, suffix: String) extends Greeter {
  override def greet(name: String): Unit = {
    println(prefix + name + postfix)
  }
}



// COMMAND ----------

// MAGIC %md
// MAGIC
