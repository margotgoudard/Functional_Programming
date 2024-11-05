// Databricks notebook source
// MAGIC %md
// MAGIC ### Programming Paradigms
// MAGIC - A way to structure programs
// MAGIC ### Functions
// MAGIC - A block of code that takes arguments and returns a value
// MAGIC ### Methods
// MAGIC - A function that is associated with an object or a class
// MAGIC ### Functional Programming
// MAGIC - Functions: the main building block
// MAGIC - Immutable: mutable variables and loops are forbidden
// MAGIC - Less code
// MAGIC - Parallelism

// COMMAND ----------

def f(x: Int): Int = x * 2
def g(x: Int): Int = x + 2
def h(x: Int): Int = f(g(x))

// COMMAND ----------

val input = 4
println(s"g($input) = ${g(inpupt)}")
println(s"f(g($input)) = ${f(g(inpupt))}")
println(s"h($input) = ${h(inpupt)}")



// COMMAND ----------

// MAGIC %md
// MAGIC ### Scala
// MAGIC - hybrid supports both OOP and FP
// MAGIC - Statically typed
// MAGIC - Type-safe : the compiler enforces type rules

// COMMAND ----------

// statically typed: the types are known at compile time
val name: String = "Scala"
val age: Int = 25

// COMMAND ----------

val language: Int = "Scala" // error of type, type safety example

// COMMAND ----------

// MAGIC %md
// MAGIC Python is not type-safe

// COMMAND ----------

def add(x: Int, y: Int): Int = x + y
val sum = add(10,20)
println(s"sum is: $sum")

// COMMAND ----------

// MAGIC %md
// MAGIC ### Operators
// MAGIC - arithmetics
// MAGIC - relational
// MAGIC - logical
// MAGIC - scala does not have built-in operators (+ is not an operator, is a method defined in class Int)
// MAGIC - every type is a class, every operator is a method

// COMMAND ----------

val x = 10
val y = 20
val z = x + y


// COMMAND ----------

val z = x.+(y)
val z1 = x.*(y)

// COMMAND ----------

// MAGIC %md
// MAGIC ### Traits
// MAGIC - to define an interface that a set of related classes can share
// MAGIC - its an abstraction mechanism
// MAGIC - can include both method signatures and concrete method implementations

// COMMAND ----------

trait Shape {
  def area(): Int // abstract method, no implementation
}

class Square(lenght: Int) extends Shape { // like is extends, square must implements the method
  def area = lenght * lenght
}

class Rectangle(lenght: Int, width: Int) extends Shape {
  def area = lenght * width
}

val square = new Square(100)
val area = square.area

// COMMAND ----------

// MAGIC %md
// MAGIC ### Tuples
// MAGIC - Container for storing two or more elements of different types
// MAGIC - its immutable
// MAGIC - when we wnat to group non-related elements
// MAGIC - if elements have the same types => collection like array or list
// MAGIC - when a fonction return more than one value
// MAGIC - an element in a tuple has a one-based index

// COMMAND ----------

val twoElements = ("10", true)
val threeElements = ("10", "hey", true)

// COMMAND ----------

val first = threeElements._1

// COMMAND ----------

// MAGIC %md
// MAGIC ### Collections
// MAGIC - container data structure. 
// MAGIC - contains zero or more elements
// MAGIC - three categories : Sequences(Array/List/Vector), Sets, Maps

// COMMAND ----------

// MAGIC %md
// MAGIC ### Sequences
// MAGIC - collection of elements in specifi order 
// MAGIC ### Array 
// MAGIC - mutable

// COMMAND ----------

val arr = Array(10, 10)

// COMMAND ----------

arr(0) =  50

// COMMAND ----------

val first = arr(0)

// COMMAND ----------

// MAGIC %md
// MAGIC ### List 
// MAGIC - immutable 
// MAGIC - elements of a same type
// MAGIC - cannot be modified after it has been created

// COMMAND ----------

val xs = List(10,20,30,40)

// COMMAND ----------

val ys = (1 to 100).toList

// COMMAND ----------

val zs = arr.toList

// COMMAND ----------

zs.head // first element

// COMMAND ----------

// MAGIC %md
// MAGIC ### Vectors
// MAGIC - hybrid of the list and array
// MAGIC - provides constant-timr ondexed access
// MAGIC - fast random access

// COMMAND ----------

val v1 = Vector(10,20)

// COMMAND ----------

val v2 = v1 :+50

// COMMAND ----------

// MAGIC %md
// MAGIC ### Sets
// MAGIC - unordered collection of distinct elements
// MAGIC - not contain duplicates
// MAGIC - can not access an element by its index
// MAGIC - method: contains & isEmpty

// COMMAND ----------

val fruits = Set("apple", "orange")

// COMMAND ----------

fruits.contains("ananas")

// COMMAND ----------

fruits.isEmpty

// COMMAND ----------

// MAGIC %md
// MAGIC ### Map 
// MAGIC - colelction of key-value pairs
// MAGIC - for looking up a value by its key

// COMMAND ----------

val capitals = Map("France" -> "Paris", "USA" -> "Washington")

// COMMAND ----------

val FranceCapital = capitals("France")

// COMMAND ----------

// MAGIC %md
// MAGIC ### Higher-Order Methods on collection classes
// MAGIC - takes a function as its input parameter
// MAGIC - does not mutate a collection
// MAGIC - include : map/flatmap/filter/foreach/reduce

// COMMAND ----------

// MAGIC %md
// MAGIC ### Map
// MAGIC - the return has the exact same number of elements as the collection on which map was called

// COMMAND ----------

val myList1 = List(1.0, 2.0)

// COMMAND ----------

val myList2 = myList1.map((x: Double) => x * 10)

// COMMAND ----------

val myList3 = myList1.map{_ * 10} // same thing

// COMMAND ----------

val myList = List(1,2)

// COMMAND ----------

val myList4 = myList.map((x: Int) => x * 10.0) // always possible from low to higher but no higher to lower

// COMMAND ----------

// MAGIC %md
// MAGIC ### flat-map
// MAGIC - the function we provide to flatMap must return a collection for each element in the orignal collection
// MAGIC - return a flattened collection

// COMMAND ----------

val line = "Scala"

// COMMAND ----------

val SingleSpace = " "

// COMMAND ----------

val words = line.split(SingleSpace)

// COMMAND ----------

val arrayOfListOfChars = words.map{ x => x.toList }

// COMMAND ----------

val arrayOfChar = words.flatMap {x => x.toList}

// COMMAND ----------

// MAGIC %md
// MAGIC ### Filter

// COMMAND ----------

val myNewList = (1 to 100).toList

// COMMAND ----------

val even = myNewList.filter { _ %2 == 0}

// COMMAND ----------

// MAGIC %md
// MAGIC ### foreach
// MAGIC - does not return anything
// MAGIC - performs an operation 
// MAGIC - when we want to execute some code for each element without nedding a transformed result

// COMMAND ----------

val words = "Scala is fun".split(" ")

// COMMAND ----------

words.foreach(println)

// COMMAND ----------

// MAGIC %md
// MAGIC ### reduce
// MAGIC - returns a single value
// MAGIC - used to reduce a collection to a single value by applying a binary operation repeatedly to pairs of elements in the collection until only a single value remains

// COMMAND ----------

val reduceList = List(2,4,6)

// COMMAND ----------

val sum = reduceList.reduce{(x,y) => x + y}

// COMMAND ----------

val product = reduceList.reduce{(x,y) => x * y}

// COMMAND ----------

val min = reduceList.reduce {(x,y) => if (x < y) x else y}
