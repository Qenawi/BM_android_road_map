package com.example.android_internship_program.xo_offline.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android_internship_program.R
import com.example.android_internship_program.xo_offline.data.BoardItem


/*
https://www.raywenderlich.com/21954410-speed-up-your-android-recyclerview-using-diffutil#toc-anchor-007
 */

class BoardAdapter(val onCellClick: (p1:BoardItem, p2:Int) -> Unit = {p1,p2->}) : ListAdapter<BoardItem, BoardAdapter.BoardCellViewHolder>(DiffCallback()){
  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): BoardCellViewHolder {

    val ticTacCell =
      LayoutInflater.from(parent.context).inflate(R.layout.tic_tac_cell, parent, false)
      val holder = BoardCellViewHolder(ticTacCell)
      holder.itemView.setOnClickListener{ onCellClick(getItem(holder.adapterPosition),holder.adapterPosition)}
      return  holder
  }

  override fun onBindViewHolder(
    holder: BoardCellViewHolder,
    position: Int
  ) {
    holder.bind(getItem(position))
  }

  class BoardCellViewHolder(ticTacCell: View) : RecyclerView.ViewHolder(ticTacCell) {
    private val cellText: TextView = ticTacCell.findViewById(R.id.cell)
    fun bind(item: BoardItem)
    {
      cellText.text = item.player.playerMark
    }
  }

  private class DiffCallback: DiffUtil.ItemCallback<BoardItem>() {
    override fun areContentsTheSame(
      oldItem: BoardItem,
      newItem: BoardItem
    ): Boolean {
      return oldItem == newItem
    }

    override fun areItemsTheSame(
      oldItem: BoardItem,
      newItem: BoardItem
    ): Boolean {
      return oldItem.id == newItem.id
    }
  }
}