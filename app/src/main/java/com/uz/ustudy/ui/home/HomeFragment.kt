package com.uz.ustudy.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.uz.ustudy.R
import com.uz.ustudy.databinding.FragmentHomeBinding


class HomeFragment : Fragment(R.layout.fragment_home) {

    //=================== VIEW BINDING ===================//
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}