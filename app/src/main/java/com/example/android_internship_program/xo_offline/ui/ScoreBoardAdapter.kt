package com.example.android_internship_program.xo_offline.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android_internship_program.R
import com.example.android_internship_program.xo_offline.data.ScoreBoardItem
import java.util.Calendar

/*
https://www.raywenderlich.com/21954410-speed-up-your-android-recyclerview-using-diffutil#toc-anchor-007
 */

class ScoreBoardAdapter : ListAdapter<ScoreBoardItem, ScoreBoardAdapter.ScoreBoardItemViewHolder>(
  ScoreDiffCallback()
) {
  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): ScoreBoardItemViewHolder {

    val ticTacCell =
      LayoutInflater.from(parent.context).inflate(R.layout.score_board_cell, parent, false)
    return ScoreBoardItemViewHolder(ticTacCell)
  }

  override fun onBindViewHolder(
    holder: ScoreBoardItemViewHolder,
    position: Int
  ) {
    holder.bind(getItem(position))
  }

  class ScoreBoardItemViewHolder(ticTacCell: View) : RecyclerView.ViewHolder(ticTacCell) {
    private val gameIDX: TextView = ticTacCell.findViewById(R.id.player)
    private val winnerPlayerMessage: TextView = ticTacCell.findViewById(R.id.winner_player)
    private val winTime:TextView = ticTacCell.findViewById(R.id.win_time)
    fun bind(item: ScoreBoardItem) {
      gameIDX.text = "Game # ${item.id+1}"
      winnerPlayerMessage.text = "plauer ${item.player::class.simpleName} ${item.player.playerMark}"
      winTime.text = Calendar.getInstance().time.toString()
    }
  }

  private class ScoreDiffCallback : DiffUtil.ItemCallback<ScoreBoardItem>() {
    override fun areContentsTheSame(
      oldItem: ScoreBoardItem,
      newItem: ScoreBoardItem
    ): Boolean {
      return oldItem == newItem
    }

    override fun areItemsTheSame(
      oldItem: ScoreBoardItem,
      newItem: ScoreBoardItem
    ): Boolean {
      return oldItem.id == newItem.id
    }
  }
}