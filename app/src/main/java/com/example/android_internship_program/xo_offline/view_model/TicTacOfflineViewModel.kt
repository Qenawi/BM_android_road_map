package com.example.android_internship_program.xo_offline.view_model

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import com.example.android_internship_program.xo_offline.data.BoardItem
import com.example.android_internship_program.xo_offline.data.Player
import com.example.android_internship_program.xo_offline.data.Player.CleanCell
import com.example.android_internship_program.xo_offline.data.Player.PlayerOne
import com.example.android_internship_program.xo_offline.data.Player.PlayerTwo
import com.example.android_internship_program.xo_offline.ui.BoardAdapter

class TicTacOfflineViewModel(app: Application) : AndroidViewModel(app) {
  val boardAdapter = BoardAdapter(::onAdapterClick)
  var currentPlayer: Player = PlayerOne
  var toast: Toast? = null

  init {
    prepareField()
  }

  private fun onAdapterClick(
    cellContent: BoardItem,
    cellPosition: Int
  ) {
    if (cellContent.is_taken) {
      toast?.cancel()
      toast = Toast.makeText(getApplication(), "This Cell is Taken", Toast.LENGTH_SHORT)
      toast?.show()
    } else {
      val items = boardAdapter.currentList.toMutableList()
      items[cellPosition] = items[cellPosition].copy(id = cellPosition, player = currentPlayer, is_taken = true)
      updateBoardAfterPlayerAction(hasPlayerWon(), items)
    }
  }

  private fun hasPlayerWon(): Boolean {
    return false
  }

  private fun enablePlayer() {
    toast?.cancel()
    toast = Toast.makeText(getApplication(), currentPlayer.playerMark, Toast.LENGTH_SHORT)
    toast?.show()
  }

  private fun updateBoardAfterPlayerAction(
    isThereIsAwiner: Boolean,
    items: MutableList<BoardItem>
  ) {
    // switch for next player
    currentPlayer = when (currentPlayer) {
      CleanCell -> PlayerOne
      PlayerOne -> PlayerTwo
      PlayerTwo -> PlayerOne
    }
    // update adapter with player selection
    updateAdapter(items)
    //
    enablePlayer()
  }

  private fun prepareField() {
    val list = boardAdapter.currentList.toMutableList()
    list.clear()
    for (i in 0..8) list.add(BoardItem(id = i, player = CleanCell, is_taken = false))
    updateAdapter(list)
  }

  private fun updateAdapter(items: MutableList<BoardItem>) { boardAdapter.submitList(items) }
}