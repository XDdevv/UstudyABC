package com.uz.ustudy.ui.profile.user.insert.course

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.uz.ustudy.R
import com.uz.ustudy.databinding.FragmentAddCourseThirdStepBinding

class AddCourseThirdStepFragment : Fragment(R.layout.fragment_add_course_third_step) {

    //=================== VIEW BINDING ===================//
    private var _binding: FragmentAddCourseThirdStepBinding? = null
    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentAddCourseThirdStepBinding.bind(view)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}