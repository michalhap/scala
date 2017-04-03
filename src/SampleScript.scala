import scala.util.control.Breaks._
import Array._

/**
  * Created by michal on 20.03.17.
  */

object sample {
  def hello(): Unit = {
    val text = "Hello world"
    println(text)
  }
}

sample.hello()
println("abcd")

var number:Int = 4.*(2)
println(number)

def rangeExample: Unit = {
  val range = 0 until 10
  println("range example")
}

class Compass {
  val directions = List("north","east","south","west")
  var bearing = 0
  print("Initial bearing: ")
  println(direction)
  def direction() = directions(bearing)
  def inform(turnDirection: String): Unit = {
    println("Turning " + turnDirection + ". Now bearing " + direction)
  }

  def turnRight(): Unit ={
    bearing = (bearing + 1) % directions.size
    inform("right")
  }

  def turnLeft(): Unit ={
    bearing = (bearing + (directions.size - 1)) % directions.size
    inform("left")
  }
}

val myCompass = new Compass

myCompass.turnRight()
myCompass.turnRight()

myCompass.turnLeft()
myCompass.turnLeft()
myCompass.turnLeft()

class Person(firstName: String){
  println("Outer constructor")
  def this(firstName: String, lastName: String){
    this(firstName)
    println("Inner constructor")
  }
  def talk() = println("Hi")
}

class Person2(val name: String){
  def talk(message: String) = println(name + " says " + message)
  def id(): String = name
}

class Employee(override val name: String, val number: Int)

val bob = new Person("Bob")
val bobTate = new Person("Bob", "Tate")

object TrueRing{
  def rule = println("To rule them all")
}
TrueRing.rule

val movies = <movies><movie genre="action">Pirates of the Caribbean</movie>
  <movie genre="fairytale">Edward Scissorhands</movie></movies>
println(movies.text)
val movieNodes = movies \ "movie"
println(movieNodes(0))
println(movieNodes(0) \ "@genre")