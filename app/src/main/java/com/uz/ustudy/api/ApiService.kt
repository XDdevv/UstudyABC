package com.uz.ustudy.api

import com.uz.ustudy.model.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @POST("test/index.php")
    suspend fun test(@Body hashMap: HashMap<String, String>): Response

    @POST("category/book/index.php")
    suspend fun getBooksCategory(): Response


}