package com.uz.ustudy.api

import com.uz.ustudy.model.Response
import retrofit2.http.Body
import retrofit2.http.POST
import uz.ustudy.model.ResponseCategories

interface ApiService {
    @POST("test/index.php")
    suspend fun test(@Body hashMap: HashMap<String, String>): Response

    @POST("category/course/index.php")
    fun getCourseCategory(): ResponseCategories

}