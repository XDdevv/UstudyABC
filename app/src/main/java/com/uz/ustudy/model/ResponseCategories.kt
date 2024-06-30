package com.uz.ustudy.model

data class ResponseCategories(
    val ok: Boolean = false,
    val message: String? = null,
    val data: List<Category>
)