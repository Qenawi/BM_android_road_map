package com.example.android_internship_program.xo_offline.view_model

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import com.example.android_internship_program.xo_offline.data.BoardItem
import com.example.android_internship_program.xo_offline.data.Player
import com.example.android_internship_program.xo_offline.data.Player.CleanCell
import com.example.android_internship_program.xo_offline.data.Player.PlayerOne
import com.example.android_internship_program.xo_offline.data.Player.PlayerTwo
import com.example.android_internship_program.xo_offline.data.ScoreBoardItem
import com.example.android_internship_program.xo_offline.ui.BoardAdapter
import com.example.android_internship_program.xo_offline.ui.ScoreBoardAdapter
import com.example.android_internship_program.xo_offline.ui.TicTacBrain

class TicTacOfflineViewModel(app: Application) : AndroidViewModel(app) {
  val boardAdapter = BoardAdapter(::onAdapterClick)
  val scoreBoardAdapter = ScoreBoardAdapter()
  var currentPlayer: Player = PlayerOne
  private var toast: Toast? = null
  var canPlayerPlay: Boolean = true

  // update view call back
  var callBack: ViewModelCallBack? = null

  init {
    resetGame()
  }

  private fun onAdapterClick(
    cellContent: BoardItem,
    cellPosition: Int
  ) {
    if (!canPlayerPlay) return
    canPlayerPlay = false
    if (cellContent.is_taken) {
      toast?.cancel()
      toast = Toast.makeText(getApplication(), "This Cell is Taken", Toast.LENGTH_SHORT)
      toast?.show()
      canPlayerPlay = true
    } else {
      val items = boardAdapter.currentList.toMutableList()
      items[cellPosition] =
        items[cellPosition].copy(id = cellPosition, player = currentPlayer, is_taken = true)
      updateBoardAfterPlayerAction(items)
    }
  }

  private fun hasPlayerWon(list: List<BoardItem>): Player? {
    return TicTacBrain.isWin(list)
  }

  private fun enablePlayer() {
    when (currentPlayer) {
      PlayerOne -> callBack?.enablePlayerOne()
      PlayerTwo -> callBack?.enablePlayerTwo()
      else -> {}
    }
    canPlayerPlay = true
  }

  private fun updateBoardAfterPlayerAction(
    items: MutableList<BoardItem>
  ) {
    updateAdapter(items)
    when (hasPlayerWon(items.toList())) {
      PlayerOne -> {
        toast?.cancel()
        toast = Toast.makeText(
          getApplication(), "playerOne -${PlayerOne.playerMark} has won the match",
          Toast.LENGTH_SHORT
        )
        toast?.show()
        addWinLog()
        resetGame()
      }
      PlayerTwo -> {
        toast?.cancel()
        toast = Toast.makeText(
          getApplication(), "playerTwo -${PlayerTwo.playerMark} has won the match",
          Toast.LENGTH_SHORT
        )
        toast?.show()
        addWinLog()
        resetGame()
      }
      else -> {
        // switch for next player
        currentPlayer = when (currentPlayer) {
          CleanCell -> PlayerOne
          PlayerOne -> PlayerTwo
          PlayerTwo -> PlayerOne
        }
        enablePlayer()
      }
    }
  }

  private fun prepareField() {
    val list = boardAdapter.currentList.toMutableList()
    list.clear()
    for (i in 0..8) list.add(BoardItem(id = i, player = CleanCell, is_taken = false))
    updateAdapter(list)
  }

  private fun updateAdapter(items: MutableList<BoardItem>) {
    boardAdapter.submitList(items)
  }

  private fun addWinLog() {
   val list =  scoreBoardAdapter.currentList.toMutableList()
   list.add(ScoreBoardItem(id = list.size, player = currentPlayer, time = "A"))
    scoreBoardAdapter.submitList(list)
  }

   fun resetGame() {
    canPlayerPlay = false
    prepareField()
    currentPlayer = PlayerOne
    enablePlayer()
  }
}