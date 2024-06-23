package com.uz.ustudy.model

data class CategoryDTO(
    val id: Int,
    val name: String,
    val hash: String,
    val elementCount:String? = null
)