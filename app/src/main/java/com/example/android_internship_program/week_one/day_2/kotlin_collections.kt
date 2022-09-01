package com.example.android_internship_program.week_one.day_2

/*
intro :

# Array is the simplest Kotlin collection. Here are some points to keep in mind about
    It stores objects of the same type together and has a fixed size.
    It’s a static collection.
    Each value is indexed by the position in the array.
    The first value is actually the value with the index zero.
    The last value is at the index and is equal to the array’s size minus one.

# list :
Lists are a dynamic version of arrays.
In terms of memory, dynamic means that
you can allocate each element in any free memory slot.
Because of this, you can have very large lists of data since you
can scatter elements around in memory.
list can be both mutable and immutable in terms of their size and contents.



#Set :
A set is a collection of elements where each of the elements is
unique and there are no duplicates
. They’re useful when you need to filter out duplicates.
For example, you might use a set when storing ids or users.

Sets are a more advanced version of lists, with internal
filtering of data. Like lists, they can be both mutable and immutable




# Maps:
store pairs of objects where each value has a distinctive key. Each pair can be of any type you want and contains two objects.
Maps are collections of key/value pairs. As such, maps are extremely useful when you’re trying to tie one value to a key like an id or a String identifier.
And like other collections, maps can be both mutable and immutable.

reference : https://www.raywenderlich.com/4131729-kotlin-collections-getting-started
 */






fun main() {
  val 
  val arrayOfNumbers = arrayOf(1, 2, 3)
  arrayOfNumbers.forEach { number -> println(number) }

  // immutable
  val list = listOf(2, 3, 5, 6, 7)
  println(list)

  // mutable can add and update and remove
  val listMutable = mutableListOf(2, 3, 5, 6, 7)
  listMutable[2] = 100 // works now

  // immutable
  val setOFNumbers = setOf(1, 2, 2, 3, 4)
  println(setOFNumbers)
  // mutable
  val setOFNumbersMut = mutableSetOf(1, 2, 2, 3, 4)
  setOFNumbersMut.add(7)
  println(setOFNumbersMut)

  // immutable
  val map = mapOf(1 to "ahmed", 2 to "mohamed", 3 to "rokii")
  println(map)
  // mutable
  val mapMut = mutableSetOf(1 to "ahmed", 2 to "mohamed")
  mapMut.add(3 to "ali")
  println(mapMut)

  // operation shared across collections
  /*
    filtering elements.
    looking up data.
    grouping data.
    transforming the elements.
    validating the element.s

   */

  val showDecidedBy2 = list.filter { a -> a % 2 == 0 }.toString()
  val showDecidedBy2_set = setOFNumbers.filter { a -> a % 2 == 0 }.toString()
  val show_names_that_has_a = map.filter { a -> a.value.contains('3') }.toString()
  println("can be decided by 2  list  -> $showDecidedBy2")
  println("can be decided by 2  set -> $showDecidedBy2_set")
  println("contain char a   map -> $show_names_that_has_a")
}