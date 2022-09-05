package com.example.android_internship_program.xo_offline.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.android_internship_program.R
import com.example.android_internship_program.xo_offline.view_model.TicTacOfflineViewModel
import com.example.android_internship_program.xo_offline.view_model.ViewModelCallBack

class TicTacOfflineFragment : Fragment(R.layout.tic_tac_offline_fragment), ViewModelCallBack {
  private val viewModel: TicTacOfflineViewModel by viewModels()
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    viewModel.callBack = this
  }

  override fun onViewCreated(
    view: View,
    savedInstanceState: Bundle?
  ) {
    super.onViewCreated(view, savedInstanceState)
    val ticTacRv = view.findViewById<RecyclerView>(R.id.recyclerView)
    val score_board = view.findViewById<RecyclerView>(R.id.score_board)

    val resetButton = view.findViewById<Button>(R.id.button)
    ticTacRv.adapter = viewModel.boardAdapter
    score_board.adapter = viewModel.scoreBoardAdapter
    resetButton.setOnClickListener { viewModel.resetGame() }
  }

  private fun highLightPlayerOne() {
    val playerOne = view?.findViewById<TextView>(R.id.radioButton)
    val playertwo = view?.findViewById<TextView>(R.id.radioButton2)
    playerOne?.setTextColor(resources.getColor(R.color.green))
    playertwo?.setTextColor(resources.getColor(R.color.black))
  }

  private fun hightLightPlayerTwo() {
    val playerOne = view?.findViewById<TextView>(R.id.radioButton)
    val playertwo = view?.findViewById<TextView>(R.id.radioButton2)
    playerOne?.setTextColor(resources.getColor(R.color.black))
    playertwo?.setTextColor(resources.getColor(R.color.green))
  }

  override fun enablePlayerOne() {
    highLightPlayerOne()
  }

  override fun enablePlayerTwo() {
    hightLightPlayerTwo()
  }
}