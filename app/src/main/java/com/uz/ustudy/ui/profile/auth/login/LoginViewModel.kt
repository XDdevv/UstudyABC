package com.uz.ustudy.ui.profile.auth.login

import androidx.lifecycle.ViewModel
import com.uz.ustudy.model.Response
import com.uz.ustudy.model.ResponseLogin
import com.uz.ustudy.repository.LoginRepository
import com.uz.ustudy.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: LoginRepository
) : ViewModel() {
    fun login(username: String, password: String): Flow<Resource<ResponseLogin>> =
        flow {
            repository.login(username, password).collect {
                it?.let { it1 -> emit(it1) }
            }
        }
}