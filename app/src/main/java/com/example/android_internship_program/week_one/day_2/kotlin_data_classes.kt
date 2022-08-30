package com.example.android_internship_program.week_one.day_2

/*
intro :
In object-oriented programming (OOP),
 a class contains both properties and functions. However,
 classes that serve only as data models focus on properties. In such classes,
 the compiler can derive some functionality from its member properties. Kotlin facilitates this use case with data classes.
 Data classes specialize in holding data. The Kotlin compiler automatically generates the following functionality for them:

    A correct, complete, and readable toString() method
    Value equality-based equals() and hashCode() methods
    Utility copy() and componentN() methods

 */
class User(
  val name: String = "Ahmed",
  val age: Int = 20
)

data class UserDataClass(
  val name: String = "Ahmed",
  val age: Int = 20
)

fun main() {
  val user = User()
  val userDataClass = UserDataClass()
  val user2 = User()
  val userDataClass2 = UserDataClass()
  // toString
  println(user.toString())
  /*
  output : com.example.android_internship_program.week_one.day_2.User@7c30a502
   */
  println(userDataClass.toString())
  /*
 output :UserDataClass(name=Ahmed, age=20)
 */
  // compare
  println(user.equals(user2))
  /*
  output : false
   */
  println(userDataClass.equals(userDataClass2))
  /*
 output : true
 */

  // copy
  // val user3 = user.copy()   normal class dont have copy
  val userDataClass3 = userDataClass.copy()
  println(userDataClass3)
  /*
  output : UserDataClass(name=Ahmed, age=20)
   */
}