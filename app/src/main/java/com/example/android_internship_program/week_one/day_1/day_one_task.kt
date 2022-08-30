package com.example.android_internship_program.week_one.day_1

import java.util.Scanner

/*

write a program  to calculate single math operation based on user input

 */



fun main(args: Array<String>) {
  val reader = Scanner(System.`in`)
  print("Enter two numbers: ")

  // nextDouble() reads the next double from the keyboard
  val first = reader.nextDouble()
  val second = reader.nextDouble()

  print("Enter an operator (+  , * , -): ")
  val operator = reader.next()[0]

  val result: Double = when (operator) {
    '+' -> first + second
    '-' -> first - second
    '*' -> first * second

    // operator doesn't match any case constant (+, -, *, /)

    else -> {
      System.out.printf("Error! operator is not correct")
      return
    }
  }

  System.out.printf("%.1f %c %.1f = %.1f", first, operator, second, result)
}


data class TestUserOne(val itemOne:String , val itemTwo: Int)
{

}