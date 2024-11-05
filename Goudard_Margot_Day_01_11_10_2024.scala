// Databricks notebook source
// MAGIC %md
// MAGIC Goudard Margot - IG5 - TP1

// COMMAND ----------

// MAGIC %md
// MAGIC ### Immutability
// MAGIC - val : immutable
// MAGIC - var : mutable

// COMMAND ----------

var x = 10


// COMMAND ----------

x = 20


// COMMAND ----------

val y = 10

// COMMAND ----------

y = 20

// COMMAND ----------

// MAGIC %md
// MAGIC ### Functions
// MAGIC - - Assigning a function to a value
// MAGIC The following two functions do the same thing

// COMMAND ----------

def add(firstInput: Int, secondInput: Int): Int = {
  val sum = firstInput + secondInput
  return  sum
}

// COMMAND ----------

val addNumbers = add(5,6)

// COMMAND ----------

def addSimple(firstInput: Int, secondInput: Int) = firstInput + secondInput

// COMMAND ----------

val addNumbers = addSimple(5,6)

// COMMAND ----------

// MAGIC %md
// MAGIC ### Higher-Order Functions
// MAGIC - It is a function that takes a function as a parameter
// MAGIC - Here, f takes an int as a parameter and returns a Long

// COMMAND ----------

def encode(n: Int, f: (Int) => Long): Long = {
  val x = n* 10
  f(x)
}

// COMMAND ----------

// MAGIC %md
// MAGIC ### Literal Functions
// MAGIC - It's an "unnamed" or "anonymous" function
// MAGIC - It can be passed as a parameter to a higher-order function
// MAGIC - It can be assigned to a variable
// MAGIC - It's not necessary to give functions a name

// COMMAND ----------

(x: Int) => {
  x + 100
}

// COMMAND ----------

val higherOrderFunctionTest = encode(10, (x: Int) => {x+100})

// COMMAND ----------

val higherOrderFunctionTest2 = encode(10, x => x+100)

// COMMAND ----------

// MAGIC %md
// MAGIC une fonction litérale peut être remplacé par _

// COMMAND ----------

val higherOrderFunctionTest3 = encode(10, _+100)

// COMMAND ----------

// MAGIC %md
// MAGIC ### Classes
// MAGIC - POO concept
// MAGIC - high abstraction

// COMMAND ----------

class Car(mk: String, ml: String, cr: String) {
  val make = mk
  val model = ml
  var color = cr
  def repaint(newColor: String) = {
    color = newColor
  }
}

// COMMAND ----------

val mustang = new Car("Ford", "Mustang", "Red")
val corvette = new Car("GM", "Corvette", "Black")

// COMMAND ----------

// MAGIC %md
// MAGIC ### Singletons
// MAGIC - only one instance

// COMMAND ----------

object DatabaseConnection {
}

// COMMAND ----------

// MAGIC %md
// MAGIC ### Case Classes
// MAGIC - Class with a case modifier
// MAGIC - always immutable

// COMMAND ----------

case class Message(from: String, to: String, content: String)

// COMMAND ----------

val request = Message("Harry", "Sam", "Disccusion")

// COMMAND ----------

// MAGIC %md
// MAGIC ### Pattern Machine
// MAGIC - Same thing that a switch but better

// COMMAND ----------

def colorToNumber(color: String): Int = {
  val num = color match {
    case "Red" => 1
    case "Blue" => 2
    case _ => 0
  }
  num
}

// COMMAND ----------

val colorName = "Red"
val colorCode = colorToNumber(colorName)
println(s"The color of the code for $colorName is $colorCode")

// COMMAND ----------

def f(x: Int, y: Int, operator: String): Double = {
  operator match {
    case "+" => x + y
  }
}

// COMMAND ----------

val sum = f(10,20, "+")
