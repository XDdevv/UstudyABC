package com.uz.ustudy.ui.profile.auth.login

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.uz.ustudy.R
import com.uz.ustudy.databinding.FragmentLoginBinding
import com.uz.ustudy.db.AppDatabase
import com.uz.ustudy.util.MyNavOption.setOption
import com.uz.ustudy.util.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.fragment_login) {

    //=================== VIEW BINDING ===================//
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val viewModel: LoginViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentLoginBinding.bind(view)

        binding.icBack.setOnClickListener { findNavController().popBackStack() }

        binding.loginBtn.setOnClickListener {
            validate()
        }

        binding.signupTv.setOnClickListener {
            findNavController().navigate(
                R.id.registerFragmentStep1,
                null,
                setOption(R.id.loginFragment)
            )
        }
    }

    private fun validate() {
        val login = binding.phoneEt.text.toString().trim()
        val password = binding.passwordEt.text.toString().trim()

        if (login.isEmpty()) {
            binding.phoneEt.error = "Login is required"
            return
        }
        if (password.isEmpty()) {
            binding.passwordEt.error = "Password is required"
            return
        }

        lifecycleScope.launch {
            viewModel.login(login, password).collect {
                when (it.status) {
                    Resource.Status.SUCCESS -> {
                        binding.progress.visibility = View.GONE
                        findNavController().navigate(
                            R.id.OTPFragment,
                            bundleOf(
                                Pair("guid", it.data?.guid),
                                Pair("phone", login)
                            ),
                            setOption()
                        )
                    }

                    Resource.Status.ERROR -> {
                        binding.progress.visibility = View.GONE
                        binding.errorTv.text = it.message
                        binding.errorTv.visibility = View.VISIBLE

                        Handler(Looper.getMainLooper()).postDelayed({
                            binding.errorTv.visibility = View.GONE
                        }, 3000)
                    }

                    Resource.Status.LOADING -> {
                        binding.progress.visibility = View.VISIBLE
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}