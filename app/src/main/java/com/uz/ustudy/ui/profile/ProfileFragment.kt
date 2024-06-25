package com.uz.ustudy.ui.profile

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.uz.ustudy.R
import com.uz.ustudy.databinding.FragmentProfileBinding
import com.uz.ustudy.util.MyNavOption
import com.uz.ustudy.util.MyNavOption.setOption

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    //=================== VIEW BINDING ===================//
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentProfileBinding.bind(view)

        binding.cvRegisterTv.setOnClickListener {
            requireActivity().findNavController(R.id.fragmentContainerView).apply {
                navigate(R.id.registerFragmentStep1, null, setOption())
            }
        }

        binding.cvLoginTv.setOnClickListener {
            requireActivity().findNavController(R.id.fragmentContainerView).apply {
                navigate(R.id.loginFragment, null, setOption())
            }
        }

        sharedPreferences = requireActivity().getSharedPreferences("ustudy", Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()

        if (sharedPreferences.getBoolean("loggedIn", false)) {
            binding.paramsLogoutTv.visibility = View.VISIBLE
        }

        binding.paramsLogoutTv.setOnClickListener {
            editor.putBoolean("loggedIn", false).apply()
        }

        binding.cvProfileTv.setOnClickListener {
            requireActivity().findNavController(R.id.fragmentContainerView).apply {
                navigate(R.id.editProfileFragment, null, setOption())
            }
        }

        binding.paramsSettingsTv.setOnClickListener {
            requireActivity().findNavController(R.id.fragmentContainerView).apply {
                navigate(R.id.settingsFragment, null, setOption())
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}