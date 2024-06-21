package com.uz.ustudy.ui.books

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.uz.ustudy.R
import com.uz.ustudy.databinding.FragmentBookBinding


class BookFragment : Fragment(R.layout.fragment_book) {

    //=================== VIEW BINDING ===================//
    private var _binding: FragmentBookBinding? = null
    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentBookBinding.bind(view)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}