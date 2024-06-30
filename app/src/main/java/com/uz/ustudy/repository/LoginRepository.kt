package com.uz.ustudy.repository

import com.uz.ustudy.api.ApiService
import com.uz.ustudy.model.Response
import com.uz.ustudy.model.ResponseLogin
import com.uz.ustudy.util.Resource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val apiService: ApiService
) {

    fun login(username: String, password: String) = flow {
        emit(Resource.loading(ResponseLogin()))
        val hashMap = HashMap<String, String>()
        hashMap["email"] = username
        hashMap["password"] = password
        val response = apiService.login(hashMap)
        if (response.ok) {
            emit(Resource.success(ResponseLogin()))
        } else {
            emit(ResponseLogin().message?.let { Resource.error(it, null) })
        }
    }
}
