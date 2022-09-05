package com.example.android_internship_program.fragment_navigation

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.android_internship_program.R

class FragmentThree: Fragment(R.layout.fragment_navigation_three)
{
  override fun onViewCreated(
    view: View,
    savedInstanceState: Bundle?
  ) {
    super.onViewCreated(view, savedInstanceState)
    view.findViewById<TextView>(R.id.textView3).setOnClickListener{
      findNavController().navigate(FragmentThreeDirections.actionFragmentThreeToFragmentOne())
    }
  }
}