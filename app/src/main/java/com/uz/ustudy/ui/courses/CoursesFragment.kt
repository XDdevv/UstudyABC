package com.uz.ustudy.ui.courses

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.uz.ustudy.R
import com.uz.ustudy.databinding.FragmentCoursesBinding
import com.uz.ustudy.ui.courses.adapter.ViewPagerAdapter

class CoursesFragment : Fragment(R.layout.fragment_courses) {

    private var _binding: FragmentCoursesBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentCoursesBinding.bind(view)

        val adapter = ViewPagerAdapter(childFragmentManager)
        binding.viewPager.adapter = adapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}