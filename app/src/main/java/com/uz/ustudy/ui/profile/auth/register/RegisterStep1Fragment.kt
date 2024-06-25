package com.uz.ustudy.ui.profile.auth.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.uz.ustudy.R
import com.uz.ustudy.databinding.FragmentRegisterStep1Binding

class RegisterStep1Fragment : Fragment(R.layout.fragment_register_step1) {

    //=================== VIEW BINDING ===================//
    private var _binding: FragmentRegisterStep1Binding? = null
    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentRegisterStep1Binding.bind(view)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}