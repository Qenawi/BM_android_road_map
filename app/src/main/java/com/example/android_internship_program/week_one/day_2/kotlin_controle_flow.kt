package com.example.android_internship_program.week_one.day_2

/*
intro :
Kotlin Conditional Statements: When, While, For Loop, If Else
 */


fun main() {
  // ex :
  val testExpression = false
  if (testExpression) {
    // codes to run if testExpression is true
  } else {
    // codes to run if testExpression is false
  }

  // ex :
  val a = -9
  val b = -11

  val max = if (a > b) {
    println("$a is larger than $b.")
    println("max variable holds value of a.")
    a
  } else {
    println("$b is larger than $a.")
    println("max variable holds value of b.")
    b
  }
  println("max = $max")

  // ex :

  val aa = 12
  val bb = 5
  val operator = "+"

  val result = when (operator) {
    "+" -> aa + bb
    "-" -> aa - bb
    "*" -> aa * bb
    "/" -> aa / bb
    else -> "$operator operator is invalid operator."
  }

  println("result = $result")

// ex :

  val n = -1
  when (n) {
    1, 2, 3 -> println("n is a positive integer less than 4.")
    0 -> println("n is zero")
    -1, -2 -> println("n is a negative integer greater than 3.")
  }

//ex:

  val ax = 100

  when (ax) {
    in 1..10 -> println("A positive number less than 11.")
    in 10..100 -> println("A positive number between 10 and 100 (inclusive)")
  }

  // ex :

  var i = 1

  while (i <= 5) {
    println("Line $i")
    ++i
  }

  // ex :
  for (ix in 1..5) println(ix)

  // ex :

  for (iz in 1..10) {
    if (iz == 5) {
      break
    }
    println(iz)
  }

  // ex :
  for (iv in 1..5) {
    println("$i Always printed.")
    if (iv > 1 && iv < 5) {
      continue
    }
    println("$iv Not always printed.")
  }
}