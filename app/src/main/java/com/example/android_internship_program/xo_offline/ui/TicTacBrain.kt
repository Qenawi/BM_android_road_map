package com.example.android_internship_program.xo_offline.ui

import com.example.android_internship_program.xo_offline.data.BoardItem
import com.example.android_internship_program.xo_offline.data.Player

object TicTacBrain {
  fun isWin(list: List<BoardItem>): Player? {
    if (list.size < 9) return null
    return when {
      list[0].isEqualNextCellData(list[1]) && list[1].isEqualNextCellData(list[2]) -> list[0].player
      list[3].isEqualNextCellData(list[4]) && list[4].isEqualNextCellData(list[5]) -> list[3].player
      list[6].isEqualNextCellData(list[7]) && list[7].isEqualNextCellData(list[8]) -> list[6].player

      list[0].isEqualNextCellData(list[3]) && list[3].isEqualNextCellData(list[6])-> list[0].player
      list[1].isEqualNextCellData(list[4]) && list[4].isEqualNextCellData(list[7])-> list[1].player
      list[2].isEqualNextCellData(list[5]) && list[5].isEqualNextCellData(list[8])-> list[2].player

      list[2].isEqualNextCellData(list[4]) && list[4].isEqualNextCellData(list[6])-> list[2].player
      list[0].isEqualNextCellData(list[4]) && list[4].isEqualNextCellData(list[8])-> list[0].player
      else -> null
    }
  }
}