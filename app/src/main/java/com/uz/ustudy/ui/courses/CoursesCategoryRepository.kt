package com.uz.ustudy.ui.courses

import com.uz.ustudy.api.ApiService
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CoursesCategoryRepository @Inject constructor(private val apiService: ApiService) {

    fun getAllCategories() = flow {
        val response = apiService.getCourseCategory()
        if (response.ok){
            emit(response.categories)
        }else{
            error(response.message.toString())
        }
    }

}