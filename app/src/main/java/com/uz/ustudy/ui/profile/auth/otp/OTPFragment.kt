package com.uz.ustudy.ui.profile.auth.otp

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.uz.ustudy.R
import com.uz.ustudy.databinding.FragmentOTPBinding
import com.uz.ustudy.model.User
import com.uz.ustudy.util.MyNavOption.setOption
import com.uz.ustudy.util.Resource
import kotlinx.coroutines.launch

class OTPFragment : Fragment(R.layout.fragment_o_t_p) {

    //=================== VIEW BINDING ===================//
    private var _binding: FragmentOTPBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<OTPViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentOTPBinding.bind(view)

        val phone = viewModel.phone.value.toString()
        binding.otpLabel.text = "OTP sent to number $phone"

        binding.icBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.confirmBtn.setOnClickListener {
            val sms = binding.otp.text.toString().trim()

            lifecycleScope.launch {
                viewModel.verifyOTP(sms).collect {
                    when (it.status) {
                        Resource.Status.SUCCESS -> {
                            binding.progress.visibility = View.GONE
                            binding.errorTv.visibility = View.GONE
                            viewModel.writeToDb(User())
                            findNavController().navigate(
                                R.id.finishingFragment,
                                null,
                                setOption(R.id.OTPFragment)
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
                            binding.errorTv.visibility = View.GONE
                        }
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