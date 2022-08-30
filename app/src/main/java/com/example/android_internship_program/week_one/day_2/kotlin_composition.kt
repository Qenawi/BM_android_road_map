package com.example.android_internship_program.week_one.day_2



/*
intro :
# Composition is a technique in you compose a class by adding private fields to the class that references
an instance of the existing class rather than extend it. So a “has-a” relationship
is established between the composed class and its contained instances.
The class accomplishes its responsibility by forwarding to or invoking non-private methods of its private fields.

# some issues of inheritance :
- We can only extend one class
- When we extend, we take everything from a class :
which leads to classes that have functionalities and methods they don’t need (a violation of the Interface Segregation Principle)
- Using superclass functionality is much less explicit:
In general, it is a bad sign when a developer reads a method and needs to jump into superclasses many times to understand how this method works

# full Article : https://kt.academy/article/ek-composition
 */



class LionUsingComposition {
  private val animalProperty: Animal
  private val lionAge = 20

  init {
    animalProperty = Animal(name = "Lion", food = "Meat")
  }

  fun getLionInfo() {
    animalProperty.showMeAnimalInfo()
    println("Lion Age is $lionAge")
  }
}

fun main() {
  val lion = LionUsingComposition()
  lion.getLionInfo()
}