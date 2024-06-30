package com.uz.ustudy.ui.profile.auth.otp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.uz.ustudy.R
import com.uz.ustudy.databinding.FragmentFinishingBinding
import com.uz.ustudy.util.MyNavOption.setOption

class FinishingFragment : Fragment(R.layout.fragment_finishing) {

    //=================== VIEW BINDING ===================//
    private var _binding: FragmentFinishingBinding? = null
    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFinishingBinding.bind(view)

        binding.teacher.setOnClickListener {
            findNavController().navigate(R.id.userMainFragment, null, setOption(R.id.finishingFragment))
        }

        binding.home.setOnClickListener {
            findNavController().navigate(R.id.mainFragment, null, setOption(R.id.finishingFragment))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}