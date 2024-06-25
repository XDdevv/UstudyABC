package com.uz.ustudy.repository

import com.uz.ustudy.api.ApiService
import com.uz.ustudy.db.AppDatabase
import com.uz.ustudy.db.test.Test
import com.uz.ustudy.model.Response
import com.uz.ustudy.util.Resource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TestRepository @Inject constructor(
    private val apiService: ApiService,
    private val appDatabase: AppDatabase
) {

    fun test(hashMap: HashMap<String, String>) = flow<Resource<Response>> {
        emit(Resource.loading(Response()))

        val response = apiService.test(hashMap)
        if (response.ok == true) {
            emit(Resource.success(Response(response.ok)))
        } else {
            emit(Resource.error(response.message.toString(), Response()))
        }
    }

    fun insertTest(test: Test) {
        appDatabase.testDao().insertTest(test)
    }

    suspend fun getTests() : List<Test> = appDatabase.testDao().getTests()

}