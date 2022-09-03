package com.example.android_internship_program.xo_offline.data

sealed class Player(val playerMark:String)
{
  object PlayerOne:Player("X")
  object PlayerTwo:Player("O")
  object CleanCell:Player("")
}