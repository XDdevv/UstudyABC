package com.uz.ustudy.ui.books

import com.uz.ustudy.api.ApiService
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class BooksRepository @Inject constructor(private val apiService: ApiService) {

    fun fetchBooksCategories() = flow {
        val response = apiService.getBooksCategory()
        if (response.ok) {
            emit(response.categories)
        }else{
            error(response.message.toString())
        }
    }

//    fun getBookCategoryInDatabase() = flow {
//        val getAllCategoriesAppD
//    }

}