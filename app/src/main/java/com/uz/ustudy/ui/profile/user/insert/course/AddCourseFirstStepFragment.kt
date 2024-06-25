package com.uz.ustudy.ui.profile.user.insert.course

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.uz.ustudy.R
import com.uz.ustudy.databinding.FragmentAddCourseFirstStepBinding

class AddCourseFirstStepFragment : Fragment(R.layout.fragment_add_course_first_step) {

    //=================== VIEW BINDING ===================//
    private var _binding: FragmentAddCourseFirstStepBinding? = null
    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentAddCourseFirstStepBinding.bind(view)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}