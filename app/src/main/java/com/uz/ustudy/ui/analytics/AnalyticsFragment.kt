package com.uz.ustudy.ui.analytics

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.uz.ustudy.R
import com.uz.ustudy.databinding.FragmentAnalyticsBinding

class AnalyticsFragment : Fragment(R.layout.fragment_analytics) {

    //=================== VIEW BINDING ===================//
    private var _binding: FragmentAnalyticsBinding? = null
    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentAnalyticsBinding.bind(view)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}