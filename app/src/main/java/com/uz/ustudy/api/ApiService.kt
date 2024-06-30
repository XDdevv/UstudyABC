package com.uz.ustudy.api

import com.uz.ustudy.model.Response
import com.uz.ustudy.model.ResponseBooks
import com.uz.ustudy.model.ResponseCategories
import com.uz.ustudy.model.ResponseCourses
import com.uz.ustudy.model.ResponseLogin
import com.uz.ustudy.model.ResponseRegister
import com.uz.ustudy.model.ResponseValidate
import com.uz.ustudy.model.SendData
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @POST("test/index.php")
    suspend fun test(@Body hashMap: HashMap<String, String>): Response

    @POST("reactive/create/index.php")
    suspend fun create(@Body sendData: SendData): Response

    @POST("reactive/read/index.php")
    suspend fun readBooks(@Body sendData: SendData): ResponseBooks

    @POST("reactive/read/index.php")
    suspend fun readCourses(@Body sendData: SendData): ResponseCourses

    @POST("reactive/read/index.php")
    suspend fun readCategories(@Body sendData: SendData): ResponseCategories

    @POST("reactive/delete/index.php")
    suspend fun delete(@Body sendData: SendData): Response

    @POST("reactive/update/index.php")
    suspend fun update(@Body sendData: SendData): Response

    @POST("auth/validation/index.php")
    suspend fun validation(@Body hashMap: HashMap<String, String>): ResponseValidate

    @POST("auth/login/index.php")
    suspend fun login(@Body hashMap: HashMap<String, String>): ResponseLogin

    @POST("auth/register/index.php")
    suspend fun registerUser(@Body hashMap: HashMap<String, String>): ResponseRegister
}