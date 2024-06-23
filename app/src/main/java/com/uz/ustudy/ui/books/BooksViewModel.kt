package com.uz.ustudy.ui.books

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uz.ustudy.model.CategoryDTO
import com.uz.ustudy.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

class BooksViewModel @Inject constructor(private val booksRepository: BooksRepository) :
    ViewModel() {
    private val _bookCategory: MutableStateFlow<Resource<List<CategoryDTO>>> =
        MutableStateFlow(Resource.loading(null))
    val bookCategory: StateFlow<Resource<List<CategoryDTO>>> = _bookCategory
    fun getBooksCategories(){
        viewModelScope.launch {
            _bookCategory.value= Resource.loading(null)
            booksRepository.fetchBooksCategories().catch { error->
                _bookCategory.value = Resource.error(error.toString(),null)
            }.collect{
                _bookCategory.value = Resource.success(it)

            }
        }
    }
}

// Agar database da saqlab keyin UI ga berish kerak
// Agar mavjud bolsa Internet dan kelgan va database gini taqqoslash kerak
// bir xil bolsa Database ni malumotni update qilmasin
// bir xil bolmagan holda esa databaseni clear qilib enternet dan kelganini qushib chiqish kerak