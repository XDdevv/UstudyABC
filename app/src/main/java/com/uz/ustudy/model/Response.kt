package com.uz.ustudy.model

data class Response(
    val ok: Boolean = false,
    val categories:List<CategoryDTO>? = null,
    val message: String? = null
)