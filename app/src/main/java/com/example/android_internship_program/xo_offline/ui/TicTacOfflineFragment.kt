package com.example.android_internship_program.xo_offline.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.android_internship_program.R
import com.example.android_internship_program.xo_offline.view_model.TicTacOfflineViewModel

class TicTacOfflineFragment:Fragment(R.layout.tic_tac_offline_fragment)
{
  private val viewModel:TicTacOfflineViewModel by viewModels()

  override fun onViewCreated(
    view: View,
    savedInstanceState: Bundle?
  ) {
    super.onViewCreated(view, savedInstanceState)
    val ticTacRv = view.findViewById<RecyclerView>(R.id.recyclerView)
    ticTacRv.adapter = viewModel.boardAdapter
  }
}