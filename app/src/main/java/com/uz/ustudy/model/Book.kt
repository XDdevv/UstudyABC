package com.uz.ustudy.model

data class Book(
    val id: Int,
    val name: String,
    val description: String,
    val bannerImage: String,
    val category: List<Category>
)
