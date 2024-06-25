package com.uz.ustudy.ui.profile.auth.register

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.uz.ustudy.R
import com.uz.ustudy.databinding.FragmentRegisterStep2Binding

class RegisterStep2Fragment : Fragment(R.layout.fragment_register_step2) {

    //=================== VIEW BINDING ===================//
    private var _binding: FragmentRegisterStep2Binding? = null
    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentRegisterStep2Binding.bind(view)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}