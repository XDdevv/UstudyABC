package com.uz.ustudy.repository

import com.uz.ustudy.api.ApiService
import com.uz.ustudy.model.ResponseRegister
import com.uz.ustudy.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RStep1Repository @Inject constructor(
    private val apiService: ApiService
) {

    fun getData(hashMap: HashMap<String, String>): Flow<Resource<ResponseRegister>> = flow {
        emit(Resource.loading(ResponseRegister()))
        val response = apiService.registerUser(hashMap)
        if (response.ok == true) {
            emit(Resource.success(response))
        } else {
            emit(Resource.error(response.message.toString(), null))
        }
    }
}
