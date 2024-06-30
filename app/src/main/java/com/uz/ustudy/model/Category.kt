package com.uz.ustudy.model

data class Category(
    val id: Int,
    val name: String,
    val data: List<Category>
)
