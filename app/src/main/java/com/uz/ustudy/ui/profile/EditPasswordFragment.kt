package com.uz.ustudy.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.uz.ustudy.R
import com.uz.ustudy.databinding.FragmentEditPasswordBinding

class EditPasswordFragment : Fragment(R.layout.fragment_edit_password) {

    //=================== VIEW BINDING ===================//
    private var _binding: FragmentEditPasswordBinding? = null
    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentEditPasswordBinding.bind(view)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}