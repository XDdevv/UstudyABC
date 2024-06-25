package com.uz.ustudy.ui.splash

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.uz.ustudy.R
import com.uz.ustudy.databinding.FragmentSplashBinding
import com.uz.ustudy.db.AppDatabase
import com.uz.ustudy.db.test.Test
import com.uz.ustudy.repository.TestRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class SplashFragment : Fragment(R.layout.fragment_splash) {

    val viewModel: SplashVM by viewModels()

    //=================== VIEW BINDING ===================//
    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSplashBinding.bind(view)

        lifecycleScope.launch {
            viewModel.test(Test(title = "ANUFRHUGRIOgrihe"))
            delay(2000)

            viewModel.test3().collect {
                Log.d("TAG_ABC", "onViewCreated: $it")

            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}