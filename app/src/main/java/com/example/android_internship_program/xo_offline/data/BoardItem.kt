package com.example.android_internship_program.xo_offline.data

import androidx.recyclerview.widget.DiffUtil

data class BoardItem(
  val id: Int,
  val player: Player,
  val is_taken: Boolean
)