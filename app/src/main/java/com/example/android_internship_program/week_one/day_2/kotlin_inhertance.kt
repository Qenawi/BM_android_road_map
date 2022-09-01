package com.example.android_internship_program.week_one.day_2

import android.content.Intent

/*

intro :
#Inheritance defines an is-a relationship between a parent class and its subclasses.
Every non-private member of a parent class is visible inside the subclasses
if preceded by the keyword open.
: each class could only have one parent Class "eXtend" and infinite number of interfaces "implement"

#Interface  :
Interfaces establish an is, rather than an is-a,
relationship between the class and the interface.Unlike abstract classes, interfaces define a specific behavior rather than a template.

# Abstract Class :
You can see abstract classes as a mixture of interfaces and regular classes.
Abstract classes can have everything that interfaces have as well as properties and constructors.
Therefore, you can properly hold state in abstract classes, but you can’t instantiate an abstract class.
You can think of an abstract class as a template.


 */

interface Owner {
  fun getOwnerName() {
    println("My Owner is Ahmed")
  }
}

abstract class CanAnimalAttack {
  abstract fun canAttack()
}

open class Animal(
  val name: String,
  open val food: String,
) : CanAnimalAttack() {
  // function we can override and overload
  open fun getHungerAmount(): Int {
    return 0
  }

  // function we can overload
  fun showMeAnimalInfo() {
    println("-- Info -- ")
    println("$name $food")
  }

  // function we cant override and overload
  fun getNameAndFood() {
    println("name $name ->  food $food")
  }

  override fun canAttack() {
    println("no this animal cant attack")
  }
}

class Lion : Animal(name = "Lion", food = "Meat"), Owner {

  override fun getHungerAmount(): Int {
    return (0..100).random()
  }

  fun showMeAnimalInfo(age: Int) {
    super.showMeAnimalInfo()
    println("Age $age")
  }

  override val food: String
    get() = "From Lion Class : ${super.food}"

  override fun canAttack() {
    println("yes this animal cant attack")
  }
}

fun main() {
  val intent = Intent()

  val cat = Animal(name = "cat", food = "tuna")
  cat.showMeAnimalInfo()
  cat.canAttack()

  val lion = Lion()
  lion.showMeAnimalInfo(age = 23)
  lion.getOwnerName()
  lion.canAttack()
}