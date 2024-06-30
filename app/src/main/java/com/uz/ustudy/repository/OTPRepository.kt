package com.uz.ustudy.repository

import com.uz.ustudy.api.ApiService
import com.uz.ustudy.db.AppDatabase
import com.uz.ustudy.model.Response
import com.uz.ustudy.model.ResponseValidate
import com.uz.ustudy.model.User
import com.uz.ustudy.util.Resource
import kotlinx.coroutines.flow.flow
import java.util.HashMap
import javax.inject.Inject

class OTPRepository @Inject constructor(
    private val apiService: ApiService,
    private val db: AppDatabase
) {

    fun validate(guid: String, sms: String) = flow<Resource<ResponseValidate>> {
        emit(Resource.loading(ResponseValidate()))
        val hashMap = HashMap<String, String>()
        hashMap["guid"] = guid
        hashMap["sms"] = sms
        val response = apiService.validation(hashMap)
        if (response.ok == true) {
            emit(Resource.success(response))
        } else {
            emit(Resource.error(response.message.toString(), null))
        }
    }

    fun writeToDb(user: User) {
        db.userDao().insertUser(user)
    }
}
