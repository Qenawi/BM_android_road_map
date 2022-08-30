package com.example.android_internship_program.week_one.day_1

/*

Nullable types and non-null types﻿

Kotlin's type system is aimed at eliminating the danger of null references, also known as The Billion Dollar Mistake.

One of the most common pitfalls in many programming languages, including Java, is that accessing a member of a null reference will result in a null reference exception. In Java this would be the equivalent of a NullPointerException, or an NPE for short.

The only possible causes of an NPE in Kotlin are:

    An explicit call to throw NullPointerException().

    Usage of the !! operator that is described below.

    Data inconsistency with regard to initialization, such as when:

        An uninitialized this available in a constructor is passed and used somewhere (a "leaking this").

        A superclass constructor calls an open member whose implementation in the derived class uses an uninitialized state.

    Java interoperation:

        Attempts to access a member of a null reference of a platform type;

        Nullability issues with generic types being used for Java interoperation. For example, a piece of Java code might add null into a Kotlin MutableList<String>, therefore requiring a MutableList<String?> for working with it.

        Other issues caused by external Java code.

In Kotlin, the type system distinguishes between references that can hold null (nullable references) and those that cannot (non-null references). For example, a regular variable of type String cannot hold null:
 */

//@Dcs : https://kotlinlang.org/docs/null-safety.html#nullable-types-and-non-null-types