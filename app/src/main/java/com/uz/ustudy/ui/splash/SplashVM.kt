package com.uz.ustudy.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uz.ustudy.db.test.Test
import com.uz.ustudy.repository.TestRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashVM @Inject constructor(
    val testRepository: TestRepository
) : ViewModel() {
    fun test(test: Test) {
        viewModelScope.launch(Dispatchers.IO) {
            testRepository.insertTest(test)
        }
    }

//    fun test2() : List<Test> {
//       return testRepository.getTests()
//    }

    fun test3() = flow {
        emit(testRepository.getTests())
    }

}