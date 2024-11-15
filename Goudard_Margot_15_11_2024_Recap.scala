// Databricks notebook source
// MAGIC %md
// MAGIC ### functionnal programming
// MAGIC
// MAGIC - computation is treated as :
// MAGIC   - the evaluation of mathematicals functions
// MAGIC   - avoiding changes
// MAGIC   - mutable data
// MAGIC
// MAGIC - Key concept 
// MAGIC   - declarative style
// MAGIC   - expressions over statement
// MAGIC   - function composition
// MAGIC   - referential transparency
// MAGIC
// MAGIC - scala : hybrid language that support both oreinted-object and functional programming
// MAGIC
// MAGIC - pure functions
// MAGIC   - the output value is determined only by its input value
// MAGIC   - it has no side effects
// MAGIC   - deterministic : same input always yields the smae output
// MAGIC   - no side effect : doesn't modify any axternal state

// COMMAND ----------

def multiply(a: Int, b: Int): Int = a * b
val result = multiply(3,4)

// COMMAND ----------

val result2 = multiply(3,4)

// COMMAND ----------

var total = 0

 def addTotal(a: Int): Int = {
  total += a
  total
 }

// COMMAND ----------

val add_first_call = addTotal(5)

// COMMAND ----------

// MAGIC %md
// MAGIC ### Immutability
// MAGIC
// MAGIC - val : immutable
// MAGIC - var : mutable

// COMMAND ----------

val list = List(1,2,3)

// COMMAND ----------

list = List(0,1,2,3)

// COMMAND ----------

// MAGIC %md
// MAGIC ### cons operator or prepend operator ::
// MAGIC
// MAGIC - it is ussed to add an element to the front of the lits, cerating new list without modifying th einital one
// MAGIC - :: takes an element on the left and a list on the right
// MAGIC - prepending 0 :: to list cretaes a new list

// COMMAND ----------

val new_list = 0 :: list

// COMMAND ----------

// MAGIC %md
// MAGIC ### First Class Functions
// MAGIC - assignes to variables
// MAGIC - passed as arguments to other functions
// MAGIC - returned from functions
// MAGIC

// COMMAND ----------

val greet = (name: String) => s"Hello, $name!"

// COMMAND ----------

println(greet("Margot"))

// COMMAND ----------

def applyTwice(f: Int => Int, x : Int): Int = f(f(x))

// COMMAND ----------

val increment = (x: Int) => x+1

// COMMAND ----------

println(applyTwice(increment, 5))

// COMMAND ----------

def multiplier(factor: Int): Int => Int = {
  (x: Int) => x * factor
}

// COMMAND ----------

// MAGIC %md
// MAGIC - mltiplier is a function that takes an integer parameter factor 
// MAGIC - the return type of multiplier is Int => Int
// MAGIC - multiplier is a higher-order functio because it returns a function as its result 
// MAGIC - the inner function (x: Int) => x * factor is a closure because it captures the factor value from the environment in which it was created (the call to multiplier)

// COMMAND ----------

val triple = multiplier(3)
println(triple(20))

// COMMAND ----------

// MAGIC %md
// MAGIC ### benefits of higher-order functions
// MAGIC - abstraction : encapsultae behavior
// MAGIC - functional composition

// COMMAND ----------

// MAGIC %md
// MAGIC ### Fubnction literal
// MAGIC - lambda expression or anonymous function

// COMMAND ----------

// (val1: Type1, val2 : Type2) => expression 

(x: Int, y: Int) => x + y

// COMMAND ----------

(a,b) => a + b

// COMMAND ----------

// MAGIC %md
// MAGIC ### Underscore notation

// COMMAND ----------

val numbers = List(1,2,3)

// COMMAND ----------

val double = numbers.map()

// COMMAND ----------

// MAGIC %md
// MAGIC ### Currying and partial application
// MAGIC - allows for more flexible function defintion and can enable partial application

// COMMAND ----------

def add(x: Int)(y: Int): Int = x + y

// COMMAND ----------

println(add(5)(10))

// COMMAND ----------

// MAGIC %md
// MAGIC ### Partial application 
// MAGIC - involves fixing a few arguments of a function, proudcing another function of fewer application

// COMMAND ----------

val addFive = add(5)_

// COMMAND ----------

println(addFive(10))

// COMMAND ----------

// MAGIC %md
// MAGIC - add(5) returns a function that takes an Int and adds 5 to it
// MAGIC - _ is a placeholder indicated that

// COMMAND ----------

def log(level: String)(message: String): Unit = {
  println(s"[$level] $message")
}

// COMMAND ----------

val infoLog = log("INFO")_
val errorLog = log("EROOR")_

// COMMAND ----------

// MAGIC %md
// MAGIC log is curried function, meaning it's defined with two sets of parameters

// COMMAND ----------

// MAGIC %md
// MAGIC ### Immutable collections
// MAGIC
// MAGIC - List
// MAGIC - Vector
// MAGIC - Set
// MAGIC - Map

// COMMAND ----------

// MAGIC %md
// MAGIC - map : applies function to each element
// MAGIC - flatMap : Maps each element and flattends the result
// MAGIC - collect : maps and filters based on partial functions
// MAGIC
// MAGIC - filter : select elements that meet a condition
// MAGIC - filterNot
// MAGIC -takeWhile
// MAGIC - dropWhile
