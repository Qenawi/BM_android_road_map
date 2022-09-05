package com.example.android_internship_program.xo_offline.data

data class BoardItem(
  val id: Int,
  val player: Player,
  val is_taken: Boolean
) {
  fun isEqualNextCellData(data: BoardItem): Boolean {
    return when {

      this.is_taken && data.is_taken && this.player == data.player -> true
      else -> false

    }
  }
}