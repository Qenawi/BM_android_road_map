package com.example.android_internship_program.week_one.day_2

/*
intro : Classes in Kotlin are declared using the keyword class:
 */

class StudentWithEmptyConstructor

class StudentWithNoneEmptyConstructor constructor(studentId: Int) // or we can use  class StudentWithNoneEmptyConstructor (studentId:Int)

/*
note : The primary constructor cannot contain any code. Initialization code can be placed in initializer blocks prefixed with the init keyword.
ex :
class "class name "()
{
  init {

    // do your intlization here

  }
}

 */

class StudentWithSecondaryConstructor(
  studentId: Int,
  studentName: String
) {
  /*
   note :
   #  secondary constructor must fulfill primary constructor
   #  During the initialization of an instance, the initializer blocks are executed in the same order as they appear in the class body
   */

  val studentIdNumber: Int
  val studentFullName: String = studentName.also { println("setting:studentFullName") }

  init {
    println("iam primary Constructor $studentId ")
    studentIdNumber = studentId.also { println("setting:studentIdNumber") }
  }

  constructor() : this(studentId = -1, studentName = "empty name") {
    println("iam secondary Constructor")
  }
}

fun main() {
  val studentWithSecondaryConstructorUsingSecondry = StudentWithSecondaryConstructor()
  println("-------- separator ---------")
  val studentWithSecondaryConstructorUsingPrimary = StudentWithSecondaryConstructor(12, "Ahmed")
}





