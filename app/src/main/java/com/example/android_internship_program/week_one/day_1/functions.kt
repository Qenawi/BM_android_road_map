package com.example.android_internship_program.week_one.day_1

fun double(x: Int): Int {
  return 2 * x
}

// function usage :
val result = double(2)

//Parameters

/*
You can use a trailing comma when you declare function parameters:
 */
fun powerOf(
  number: Int,
  exponent: Int
): Int {
  return 0
}

//Default argument

/*
Function parameters can have default values,
 which are used when you skip the corresponding argument.
  `This reduces the number of overloads:
 */

fun read(
  b: ByteArray,
  off: Int = 0,
  len: Int = b.size,
) { /*left blank*/
}

