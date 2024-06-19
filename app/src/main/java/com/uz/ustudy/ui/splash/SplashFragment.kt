package com.uz.ustudy.ui.splash

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.uz.ustudy.R
import com.uz.ustudy.databinding.FragmentSplashBinding

class SplashFragment : Fragment(R.layout.fragment_splash) {

    //=================== VIEW BINDING ===================//
    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSplashBinding.bind(view)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}